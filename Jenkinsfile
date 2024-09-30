pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    // Ensure Maven is installed and available
                    sh 'mvn clean package'
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    // Run tests
                    sh 'mvn test'
                }
            }
        }
    }

    post {
        success {
            echo 'Build and tests successful!'
        }
        failure {
            script {
                echo 'Build or tests failed.'
            }
        }
    }
}
