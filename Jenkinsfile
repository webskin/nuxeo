pipeline {
    agent {
        node {
            label 'ondemand'
        }
    }
    stages {
        stage('checkout') {
            steps {
                checkout scm
                sh "./clone.py ${env.BRANCH_NAME}"
            }
        }
        stage('compile') {
            steps {
                script {
                    withMaven(
                        maven: 'maven-3',
                        mavenSettingsConfig: '51acdf6a-30c6-44d6-9390-b08bccb22b1d') {
                        sh "mvn -nsu -Paddons,distrib compile -DskipTests"
                    }
                }
            }
        }
        stage('test') {
            steps {
                withMaven(
                    maven: 'maven-3',
                    mavenSettingsConfig: '51acdf6a-30c6-44d6-9390-b08bccb22b1d') {
                    sh "mvn -nsu -Paddons,distrib test"
                }
            }
        }
        stage('verify') {
            steps {
                withMaven(
                    maven: 'maven-3',
                    mavenSettingsConfig: '51acdf6a-30c6-44d6-9390-b08bccb22b1d') {
                    sh "mvn -nsu -Paddons,distrib -DskipTests verify"
                }
            }
        }
    }
}
