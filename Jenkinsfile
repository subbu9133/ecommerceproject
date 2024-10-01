pipeline {
    agent any

    tools {
        // Specify Maven installation
        maven 'Maven 3.9.9' // Replace with your Maven installation name
    }

    stages {
        stage('Build') {
            steps {
                script {
                    // Clean, compile, and package the project
                    sh 'nohup mvn clean compile package'
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    // Run tests
                    sh 'nohup mvn test'
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    // Deploy the application (modify as necessary for your deployment)
                    sh 'nohup mvn deploy -DskipTests' // Skip tests during deployment
                }
            }
        }
    }

    post {
        success {
            echo 'Build, tests, and deployment successful!'
            // Optionally notify stakeholders, e.g., Slack, email
            // slackSend(channel: '#your-channel', message: 'Build, tests, and deployment successful!')
        }
        failure {
            script {
                echo 'Build, tests, or deployment failed.'
                // Optionally send notifications for failure
                // slackSend(channel: '#your-channel', message: 'Build, tests, or deployment failed.')
            }
        }
    }
}