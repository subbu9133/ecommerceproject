pipeline {
    agent any

    tools {
        // Specify Maven installation
        maven 'Maven_3.9.9' // Replace with your Maven installation name
    }

    stages {
        stage('Build') {
            steps {
                script {
                    // Clean and package the project
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

        stage('Deploy') {
            steps {
                script {
                    // Deploy the application (modify as necessary for your deployment)
                    sh 'mvn deploy'
                }
            }
        }
    }

    post {
        success {
            echo 'Build and tests successful!'
            // Optionally notify stakeholders, e.g., Slack, email
            // slackSend(channel: '#your-channel', message: 'Build and tests successful!')
        }
        failure {
            script {
                echo 'Build or tests failed.'
                // Optionally send notifications for failure
                // slackSend(channel: '#your-channel', message: 'Build or tests failed.')
            }
        }
    }
}
