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
	        		
	        		sh "curl -k -o capella.zip ${capellaURL}"
					sh "unzip -q capella.zip"

	       		}         
	     	}
	    }
	    
	    stage('Adapt Capella to DARC') {
	        steps {
	            //Install Cybersecurity on Capella
	            sh "ls -lat ."
	            sh "ls -lat ${WORKSPACE}/releng/org.polarsys.capella.cybersecurity.site/target/repository"
	            sh "chmod 755 ./capella/capella"
	            sh "chmod 755 ./capella/jre/bin/java"
	            sh "./capella/capella -application org.eclipse.equinox.p2.director -repository file:/${WORKSPACE}/releng/org.polarsys.capella.cybersecurity.site/target/repository -installIU org.polarsys.capella.cybersecurity.feature.feature.group -noSplash"            
	            
	            //Adapt eclipse.ini config.ini and other things
	            sh "cp -rp capella capella-darc"
	            sh "cat capella-darc/capella.ini"
	            sh "cat capella-darc/configuration/config.ini"
	            sh "sed -i \"s,eclipse.product=org.polarsys.capella.rcp.product,eclipse.product=org.polarsys.capella.cybersecurity.rcp.product,g\" capella-darc/configuration/config.ini"
	            sh "sed -i 's,osgi.splashPath=platform\\\\:/base/plugins/org.polarsys.capella.core.platform.sirius.ui.perspective,osgi.splashPath=platform\\\\:/base/plugins/org.polarsys.capella.cybersecurity.rcp,g' capella-darc/configuration/config.ini"
	            sh "cat capella-darc/configuration/config.ini"
	            sh '''
	                # Identify darc name
	                addon_local_dropins_name=`ls ${WORKSPACE}/releng/org.polarsys.capella.cybersecurity.site/target | grep "Cybersecurity-dropins" | cut -d"-" -f3 | sed "s/.zip//"`
	                # Build the product zip
	                DARC_BUILD="capella-darc-${addon_local_dropins_name}-win32-win32-x86_64.zip"
	                zip -q -r $DARC_BUILD capella-darc
	            '''
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
					deployer.addonNightlyProduct("${WORKSPACE}/capella-darc-*-win32-win32-x86_64.zip", deploymentDirName)
					
					currentBuild.description = "${deploymentDirName} - <a href=\"https://download.eclipse.org/capella/addons/cybersecurity/dropins/nightly/${deploymentDirName}\">drop-in</a> - <a href=\"https://download.eclipse.org/capella/addons/cybersecurity/updates/nightly/${deploymentDirName}\">update-site</a> - <a href=\"https://download.eclipse.org/capella/addons/cybersecurity/products/nightly/${deploymentDirName}\">product</a>"
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
       		archiveArtifacts artifacts: '**/*.log, *.log, *.xml, **/*.layout'
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