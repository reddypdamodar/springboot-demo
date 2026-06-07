pipeline {
    agent any

    tools {
        jdk 'JDK25'
        maven 'Maven'
    }

    stages {

        stage('Stop Existing App') {
            steps {
                bat '''
                for /f "tokens=5" %%a in ('netstat -ano ^| findstr :8081') do taskkill /F /PID %%a
                exit /b 0
                '''
            }
        }

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

        stage('Deploy') {
            steps {
                bat '''
                timeout /t 5 /nobreak > nul
                start "SpringBootApp" /B java -jar target\\demo-0.0.1-SNAPSHOT.jar
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
