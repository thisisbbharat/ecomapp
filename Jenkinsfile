pipeline {
  agent any

  stages {
    stage('Build') {
      steps {
        git 'https://github.com/HaneeshDevops/ecomapp.git'
        sh 'mvn clean install -DskipTests'
           }
                 }

    stage('Test') {
      steps {
        sh 'mvn test'
            }
                 }

stage('Deploy') {
    steps {
        script {
          
          sh 'docker rm -f $(docker ps -aq)'
          sh 'docker rmi -f $(docker images -aq)'
          sh 'docker-compose up -d'
               }
         }
               }

  }
}
