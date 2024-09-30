pipeline {
    agent any

    stages {
        stage('Clone Repository') {
            steps {
                // Checkout source code from the repository
                git branch: 'master', url: 'https://github.com/subbu9133/ecommerceproject.git'
            }
        }

        stage('Build') {
            steps {
                // Run Maven build
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                // Run tests
                sh 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying application...'
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
    }        echo 'Pipeline failed. Check the logs for more details.'

}
}


