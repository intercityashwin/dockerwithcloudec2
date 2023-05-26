pipeline {
    agent any
    stages {
        stage('Build and Package Automated Tests as executable Jar') {
            steps {
                bat "mvn clean package -DskipTests"
            }
        }
        stage('Build Docker File') {
             steps {
                bat "docker build -t=seleniumdocker ."
             }
        }
        stage('Spin up Selenium Grid Infrastructure') {
             steps {
                bat "docker-compose up -d hub chrome firefox"
             }
        }
        stage('Execute the Test Suite') {
             steps {
                 bat "docker-compose up tests"
             }
        }
    }
    post{
          always {
                    archiveArtifacts artifacts : 'output/**'
                    bat "docker-compose down"
                 }
    }
}