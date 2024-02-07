pipeline {
  agent any

  stages {
    stage('Build') {
      steps {
        // Checkout your source code from GitHub
        git 'https://github.com/HaneeshDevops/ecomapp.git'

        // Build your Spring Boot application
        sh 'mvn clean install'
      }
    }

    stage('Test') {
      steps {
        // Run tests on your Spring Boot application
        sh 'mvn test'
      }
    }

    //     stage('SonarQube Analysis') {
    //   steps {
    //     script {
    //       sh 'mvn clean verify sonar:sonar ' +
    //           '-Dsonar.projectKey=EcomApp  ' +
    //           "-Dsonar.projectName='EcomApp ' " +
    //           '-Dsonar.host.url=http://3.80.229.101:9000  ' +
    //           '-Dsonar.token=sqp_a81b58ec7954e45151efef08da8565b2945b82e5'
    //     }
    //   }
    // }

        stage('SonarQube Analysis') {
            environment {
                SONAR_URL = credentials('sonarurl')
                SONAR_TOKEN = credentials('SonarQube')
            }
            steps {
                script {
                    sh "mvn clean verify sonar:sonar " +
                       "-Dsonar.projectKey=ecomapp " +
                       "-Dsonar.projectName='ecomapp' " +
                       "-Dsonar.host.url=${SONAR_URL} " +
                       "-Dsonar.login=${SONAR_TOKEN}"
                }
            }
        }


    stage('Docker Build and Push') {
      steps {
        withCredentials([usernamePassword(credentialsId: 'DockerRegistry', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
          
        sh "docker login -u ${DOCKER_USERNAME} -p ${DOCKER_PASSWORD}"
          
        // Build the Docker image
        sh 'docker build --no-cache -t haneeshdevops/ecomapp:latest .'

        // Push the Docker image to Docker Hub
        // sh 'docker login -u enterdockerid -p enterpass'
        sh 'docker push haneeshdevops/ecomapp:latest'
      }
    }
    }

    stage('Deploy') {
      environment {
        CONTAINER_NAME = 'ecomapp'
        
      }
      steps {
        // Set up Kubernetes context using kubeconfig
        withKubeConfig([credentialsId: 'k8sgroup']) {
        sh'rm -rf ecomapp'
          
        sh 'git clone https://github.com/HaneeshDevops/ecomapp.git || true'
          
          // Deploy the application to Kubernetes using the deployment YAML file
          sh 'kubectl apply -f autoscale-deployment.yml'

          //sh 'kubectl apply -f autoscale_hpa.yml'

          // Start the service
          sh 'kubectl apply -f application-service.yml'

          // Restart the deployment to apply the changes
          sh 'kubectl rollout restart deployment javapp'

        
        }
      }
    }
  }
}
