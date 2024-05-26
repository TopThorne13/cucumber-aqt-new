pipeline {
    agent any
    
    tools {
        jdk 'JDK'
        maven 'Maven'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/TopThorne13/cucumber-aqt.git/' 
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                script {
                    try {
                        bat 'mvn test'
                    } catch (e) {
                        unstable('Testing failed now')
                        echo 'Tests failed'
                    }
                }
            }
        }
        stage('Cleanup') {
            steps {
                bat 'del /f /s /q Screenshots 1>nul'
                bat 'rmdir /s /q Screenshots'
                bat 'del /f /s /q Logger 1>nul'
                bat 'rmdir /s /q Logger'
            }
        }
    }
}