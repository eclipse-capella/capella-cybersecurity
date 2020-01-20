pipeline {
  agent { label "migration" }
  tools {
        maven "apache-maven-latest"
        jdk "oracle-jdk8-latest"
  }
  environment {
    /******************* ADDON SPECIFIC VARIABLES *******************/
    
    TP_POM = "releng/org.polarsys.capella.cybersecurity.target/pom.xml"
    
    ADDON_DROPINS_DIR = "/home/data/httpd/download.eclipse.org/capella/addons/cybersecurity/dropins/nightly"
    ADDON_DROPINS_SITE = "https://download.eclipse.org/capella/addons/cybersecurity/dropins/nightly"
    
    ADDON_PRODUCTS_DIR = "/home/data/httpd/download.eclipse.org/capella/addons/cybersecurity/products/nightly"
    ADDON_PRODUCTS_SITE = "https://download.eclipse.org/capella/addons/cybersecurity/products/nightly"
    
    ADDON_UPDATES_DIR = "/home/data/httpd/download.eclipse.org/capella/addons/cybersecurity/updates/nightly"
    ADDON_UPDATES_SITE = "https://download.eclipse.org/capella/addons/cybersecurity/updates/nightly"
    
    
    /********************** GENERIC VARIABLES **********************/
    FROM_PR = "${env.BRANCH_NAME}".contains("PR-");
    
    SSH_ACCOUNT = "genie.capella@projects-storage.eclipse.org";
    
    CAPELLA_PRODUCTS_DIR = "/home/data/httpd/download.eclipse.org/capella/core/products/nightly";
    CAPELLA_PRODUCTS_SITE = "https://download.eclipse.org/capella/core/products/nightly/"
    
    CAPELLA_UPDATES_DIR = "/home/data/httpd/download.eclipse.org/capella/core/updates/nightly";
    CAPELLA_UPDATES_SITE = "https://download.eclipse.org/capella/core/updates/nightly/"
    
    ADDON_BRANCH = "${env.FROM_PR}".replace("true", "${env.CHANGE_TARGET}").replace("false", "${env.BRANCH_NAME}");
    CAPELLA_VERSION = "${env.ADDON_BRANCH}".replace("master", "master").replaceFirst(/^v/, "");
    
    ADDON_KEY = "${env.ADDON_BRANCH}".replaceFirst(/^v/, "");
    BUILD_KEY = "${env.FROM_PR}".replace("true", "${env.ADDON_KEY}-${env.BRANCH_NAME}-${env.BUILD_ID}").replace("false", "${env.BRANCH_NAME}-${env.BUILD_ID}").replaceAll('/','-');
    
    CAPELLA_BUILD = "releases/1.4.0-R20191121-173601/capella-1.4.0.201911211736-win32-win32-x86_64.zip"
  }
  
  stages {
    
    stage('Generate Target Platform') {
      steps {
        sh 'env'
        sh 'mvn clean verify -f ${TP_POM}'
      }
    }
  
    stage('Compile and Package') {
        steps {
            wrap([$class: 'Xvnc', takeScreenshot: false, useXauthority: true]) {
	            sh 'mvn -Psign -DSKIP_SONAR=false -Djacoco.skip=true -DjavaDocPhase=none clean verify -f pom.xml'
            }
        }
    }
    
    stage('Publish site to nightly') {
      when {
        expression { return "${env.FROM_PR}".contains("false") } 
      }
      steps {
        sshagent (['projects-storage.eclipse.org-bot-ssh']) {
            sh '''
                # Identify local dropins
                addon_local_dropins_name=`ls ${WORKSPACE}/releng/org.polarsys.capella.cybersecurity.site/target | grep 'Cybersecurity-dropins'`
                addon_local_dropins_path=${WORKSPACE}/releng/org.polarsys.capella.cybersecurity.site/target/${addon_local_dropins_name}
                
                # Create product directory and copy
                addon_dropins_remote_path=${ADDON_DROPINS_DIR}/${BUILD_KEY}
                ssh $SSH_ACCOUNT mkdir -p ${addon_dropins_remote_path}
                scp -rp ${addon_local_dropins_path} ${SSH_ACCOUNT}:${addon_dropins_remote_path} 
                
                # Identify local update site
                addon_local_site_name=`ls ${WORKSPACE}/releng/org.polarsys.capella.cybersecurity.site/target | grep 'Cybersecurity-updateSite'`
                addon_local_site_path=${WORKSPACE}/releng/org.polarsys.capella.cybersecurity.site/target/${addon_local_site_name}
                
                # Create product directory and copy
                addon_site_remote_path=${ADDON_UPDATES_DIR}/${BUILD_KEY}
                ssh $SSH_ACCOUNT mkdir -p ${addon_site_remote_path}
                scp -rp ${addon_local_site_path} ${SSH_ACCOUNT}:${addon_site_remote_path} 
                
            '''
        }
        script { currentBuild.description = "${env.BUILD_KEY} <a href=\"https://download.eclipse.org/capella/addons/cybersecurity/dropins/nightly/${env.BUILD_KEY}\">dropins</a>" } 
        
      }
    }
    
    
    
    stage('Download Capella') {
        when {
            expression { return "${env.FROM_PR}".contains("false") } 
        }
      steps {
            sh "wget -O director.zip www.eclipse.org/downloads/download.php?file=/tools/buckminster/products/director_latest.zip"
            sh "wget -O capella.zip http://download.eclipse.org/capella/core/products/$CAPELLA_BUILD"
            sh "unzip -q capella.zip -d ."
            sh "unzip -q director.zip -d ."
        }
    }
    stage('Adapt Capella to DARC') {
        when {
            expression { return "${env.FROM_PR}".contains("false") } 
        }
        steps {
            //Install Cybersecurity on Capella
            sh "ls -lat ."
            sh "ls -lat ${WORKSPACE}/releng/org.polarsys.capella.cybersecurity.site/target/repository"
            sh "chmod 755 ./director/director"
            sh "./director/director -application org.eclipse.equinox.p2.director -profile DefaultProfile -destination ${workspace}/capella/eclipse/ -repository file:/${WORKSPACE}/releng/org.polarsys.capella.cybersecurity.site/target/repository -installIU org.polarsys.capella.cybersecurity.feature.feature.group -noSplash"
            
            //Adapt eclipse.ini config.ini and other things
            sh "cat capella/eclipse/eclipse.ini"
            sh "cat capella/eclipse/configuration/config.ini"
            sh "sed -i \"s,eclipse.product=org.polarsys.capella.rcp.product,eclipse.product=org.polarsys.capella.cybersecurity.rcp.product,g\" capella/eclipse/configuration/config.ini"
            sh "sed -i 's,osgi.splashPath=platform\\\\:/base/plugins/org.polarsys.capella.core.platform.sirius.ui.perspective,osgi.splashPath=platform\\\\:/base/plugins/org.polarsys.capella.cybersecurity.rcp,g' capella/eclipse/configuration/config.ini"
            sh "cat capella/eclipse/configuration/config.ini"
            sh "mv capella capella-darc"
        }
    }
    stage('Publish product to nightly') {
        when {
            expression { return "${env.FROM_PR}".contains("false") } 
        }
        steps {
            sshagent (['projects-storage.eclipse.org-bot-ssh']) {
                
            sh '''
                # Identify darc name
                addon_local_dropins_name=`ls ${WORKSPACE}/releng/org.polarsys.capella.cybersecurity.site/target | grep "Cybersecurity-dropins" | cut -d"-" -f3 | sed "s/.zip//"`
                
                DARC_BUILD="capella-darc-${addon_local_dropins_name}-win32-win32-x86_64.zip"
                zip -q -r $DARC_BUILD capella-darc
            
                # Create product directory and copy
                addon_products_remote_path=${ADDON_PRODUCTS_DIR}/${BUILD_KEY}
                addon_local_products_path=${WORKSPACE}/$DARC_BUILD
                ssh $SSH_ACCOUNT mkdir -p ${addon_products_remote_path}
                scp -rp ${addon_local_products_path} ${SSH_ACCOUNT}:${addon_products_remote_path} 
            '''
            }
            
            script { currentBuild.description = "${env.BUILD_KEY} - <a href=\"https://download.eclipse.org/capella/addons/cybersecurity/dropins/nightly/${env.BUILD_KEY}\">dropins</a> - <a href=\"https://download.eclipse.org/capella/addons/cybersecurity/products/nightly/${env.BUILD_KEY}\">product</a>" } 
        }
    }
    stage('Logs') {
        steps {
            sh "ls -lat ."
            //sh "find director/configuration -name *.log -type f -exec cat {} +"
            //sh "find capella-darc/eclipse/configuration -name *.log -type f -exec cat {} +"
        }
    }
      
    
  }
  

  post {
    always {
       archiveArtifacts artifacts: '**/*.log, **/Cybersecurity*.zip, **/capella-darc*.zip'
    }
  }
  
    
}