pipeline {
	agent {
		label 'migration'
	}
  
	tools {
		maven 'apache-maven-latest'
		jdk 'openjdk-jdk14-latest'
	}
  
	environment {
		BUILD_KEY = (github.isPullRequest() ? CHANGE_TARGET : BRANCH_NAME).replaceFirst(/^v/, '')
		CAPELLA_PRODUCT_PATH = "${WORKSPACE}/capella/capella"
  	}
  
  	stages {
  	
		stage('Generate Target Platform') {
	    	steps {        
	        	script { 
		        	if(github.isPullRequest()){
		        	    github.buildStartedComment()
		        	}
		        	
		        	sh 'env'
		        	sh 'mvn clean verify -f releng/org.polarsys.capella.cybersecurity.target/pom.xml'
	       		}         
	     	}
	    }
	    
    	stage('Build and Package') {
      		steps {
      			script {
      				def customParams = github.isPullRequest() ? '' : '-Psign'
      	    
      	    		sh "mvn -Djacoco.skip=true -DjavaDocPhase=none ${customParams} clean package -f pom.xml"
	       		}         
	     	}
	    }
	    
	    stage('Download Capella') {
        	steps {
        		script {
					def capellaURL = capella.getDownloadURL("${BUILD_KEY}", 'linux', '')
					def capellaURL_WIN = capella.getDownloadURL("${BUILD_KEY}", 'win', '')
					
					sh "curl -k -o capella.tar.gz ${capellaURL}"
					sh "tar xzf capella.tar.gz"
					
					sh "curl -k -o capella-win.zip ${capellaURL_WIN}"
					sh "unzip -q capella-win.zip -d tmp ; mv tmp/capella capella-win ; rm -rf tmp"
	       		}
	     	}
	    }
	    
		stage('Deploy to Nightly') {
      		steps {
				script {
		    		def deploymentDirName = 
		    			(github.isPullRequest() ? "${BUILD_KEY}-${BRANCH_NAME}-${BUILD_ID}" : "${BRANCH_NAME}-${BUILD_ID}")
		    			.replaceAll('/','-')		
					
					deployer.addonNightlyDropins("${WORKSPACE}/releng/org.polarsys.capella.cybersecurity.site/target/*-dropins-*.zip", deploymentDirName)
					deployer.addonNightlyUpdateSite("${WORKSPACE}/releng/org.polarsys.capella.cybersecurity.site/target/*-updateSite-*.zip", deploymentDirName)					
					
					currentBuild.description = "${deploymentDirName} - <a href=\"https://download.eclipse.org/capella/addons/cybersecurity/dropins/nightly/${deploymentDirName}\">drop-in</a> - <a href=\"https://download.eclipse.org/capella/addons/cybersecurity/updates/nightly/${deploymentDirName}\">update-site</a>"
	       		}         
	     	}
	    }
    
    	stage('Install test features') {
        	steps {
        		script {
	        		sh "chmod 755 ${CAPELLA_PRODUCT_PATH}"
	            	sh "chmod 755 ${WORKSPACE}/capella/jre/bin/java"
	        		
	        		eclipse.installFeature("${CAPELLA_PRODUCT_PATH}", 'http://download.eclipse.org/tools/orbit/downloads/drops/R20130827064939/repository', 'org.jsoup')	        		
	        		eclipse.installFeature("${CAPELLA_PRODUCT_PATH}", capella.getTestUpdateSiteURL("${BUILD_KEY}"), 'org.polarsys.capella.test.feature.feature.group')
	        		
	        		eclipse.installFeature("${CAPELLA_PRODUCT_PATH}", "file:/${WORKSPACE}/releng/org.polarsys.capella.cybersecurity.site/target/repository/".replace("\\", "/"), 'org.polarsys.capella.cybersecurity.feature.feature.group')
	        		eclipse.installFeature("${CAPELLA_PRODUCT_PATH}", "file:/${WORKSPACE}/releng/org.polarsys.capella.cybersecurity.site/target/repository/".replace("\\", "/"), 'org.polarsys.capella.cybersecurity.tests.feature.feature.group')
	       		}         
	     	}
	    }
	    
    	stage('Run tests') {
        	steps {
        		script {
        			wrap([$class: 'Xvnc', takeScreenshot: false, useXauthority: true]) {
		        		
		        		tester.runUITests("${CAPELLA_PRODUCT_PATH}", 'CybersecurityTestSuite', 'org.polarsys.capella.cybersecurity.test', 
		        			['org.polarsys.capella.cybersecurity.test.CybersecurityTestSuite'])		        			 
	        		}
	        		
	        		tester.publishTests()
				}
			}
		}
		
		stage('Sonar') {
			steps {
				script {
					sonar.runSonar("eclipse_capella-cybersecurity", "eclipse/capella-cybersecurity", 'sonarcloud-token-cybersecurity')
				}
			}
		}
	}
  
	post {
    	always {
			archiveArtifacts artifacts: '**/*.log, *.log, *.xml, **/*.layout, *.exec'
    	}
    	
    	success  {
    		script {
    			if(github.isPullRequest()){
        			github.buildSuccessfullComment()
        		}
        	}
    	}
    	
	    unstable {
	    	script {
	    		if(github.isPullRequest()){
	        		github.buildUnstableComment()
	        	}
	        }
	    }
    
	    failure {
	    	script {
	    		if(github.isPullRequest()){
	        		github.buildFailedComment()
	        	}
	        }
	    }
	    
	    aborted {
	    	script {
	    		if(github.isPullRequest()){
	        		github.buildAbortedComment()
	        	}
	        }
	    }
	}
}
