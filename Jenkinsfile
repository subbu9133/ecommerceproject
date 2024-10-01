pipeline {
    agent any

    tools {
        jdk 'JDK 17'
        maven 'Maven 3.9.9'
    }

    environment {
        // Optional: Define environment variables if needed
    }

    stages {
        stage('Checkout') {
            steps {
                // Use the 'credentialsId' parameter to refer to stored Jenkins credentials
                git branch: 'master', url: 'https://github.com/subbu9133/ecommerceproject.git', credentialsId: 'ff5f3856-0038-4807-86dc-9837f45c0bbf'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying the application...'
                // Add deployment steps here
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed. Check the logs for more details.'

}}
}