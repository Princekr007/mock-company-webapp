pipeline {
    agent any

    tools {
        jdk 'jdk21'  // or 'jdk17' depending on your Jenkins setup
    }

    environment {
        GRADLE_OPTS = "-Dorg.gradle.jvmargs=-Xmx1024m"
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Cloning repository...'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Running build...'
                sh './gradlew assemble'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                sh './gradlew test'
            }
        }
    }

    post {
        success {
            echo '✅ Build and tests passed!'
        }
        failure {
            echo '❌ Build or tests failed!'
        }
    }
}
