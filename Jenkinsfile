pipeline {

 environment {
     dockerImage = ""
     image_name=""
     name="wishlist"
     portno="8045"
     targetport="10400"
  }
    agent any

    tools {
        maven 'maven'
    }


    stages {


        stage('BUILD WISHLIST') {
            steps {
              sh 'mvn -version'
              sh 'mvn compile'
              sh 'mvn package -DskipTests'
            }
        }

        stage('DOCKER TIME'){
            steps{
                script {
                    image_name = "rowanf/wishlist:$BUILD_NUMBER"
                   dockerImage =  docker.build image_name
                    sh 'pwd'
                }
            }
         }

        stage('DEPLOY '){
            steps{
                script {
                    docker.withRegistry( '', "mydocker-cred" ) {
                        dockerImage.push()
                    }
                }
            }
        }


       stage('Build') {
            steps {
                sh 'ssh -p 1600 root@192.168.0.10 date'
                 sh "ssh -p 1600 root@192.168.0.10 ansible-playbook -vvv /home/rowan/myplaybook.yaml -e \"name=${name}\"  -e \"image_name=${image_name}\" -e \"portno=${portno}\" -e \"targetport=${targetport}\"  "
            }
       }


    }


}
