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

        stage('Stop Existing App') {
            steps {
                bat '''
                for /f "tokens=5" %%a in ('netstat -ano ^| findstr :8081') do taskkill /F /PID %%a
                exit /b 0
                '''
            }
        }

        stage('Deploy') {
            steps {
                bat '''
                start /B java -jar target\\demo-0.0.1-SNAPSHOT.jar
                '''
            }
        }
    }

    post {
        success {
            echo 'Deployment Successful'
        }

        failure {
            echo 'Deployment Failed'
        }
    }
}
