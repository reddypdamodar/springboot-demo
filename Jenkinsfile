pipeline {
    agent any

    tools {
        jdk 'JDK25'
        maven 'Maven'
    }

    stages {

        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Deploy Artifact') {
            steps {
                bat '''
                if not exist C:\\deployments mkdir C:\\deployments
                copy /Y target\\demo-0.0.1-SNAPSHOT.jar C:\\deployments\\demo.jar
                '''
            }
        }
    }

    post {
        success {
            echo 'Build, Test and Deployment Successful'
        }

        failure {
            echo 'Pipeline Failed'
        }
    }
}
