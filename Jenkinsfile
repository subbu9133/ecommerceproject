pipeline {
    agent any

    tools {
        jdk 'JDK 17' // Replace with your JDK version
        maven 'Maven 3.9.9' // Replace with your Maven version
    }

    environment {
        APP_NAME = "ecommerceproject"
        ENV_TYPE = "dev"
        DB_HOST = "localhost"
        DB_PORT = "3306"
        // Add other properties as needed
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/subbu9133/ecommerceproject.git', credentialsId: 'ff5f3856-0038-4807-86dc-9837f45c0bbf'
            }
        }

        stage('Build') {
            steps {
                sh "mvn clean package -DskipTests -Dapp.name=${env.APP_NAME} -Denv.type=${env.ENV_TYPE}"
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                // Add your deployment steps here, using environment variables as needed
                sh "mvn deploy -DskipTests -Ddeployment.target=${env.ENV_TYPE}"
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed. Check the logs for more details.'
        }
    }
}