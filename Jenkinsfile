pipeline {
    agent {
        docker {
            image 'maven:3.8.8-eclipse-temurin-17'
        }
    }

    stages {
        stage('Clone') {
            steps {
                git branch: 'main', url: 'https://github.com/Abhay19999/opens-shift-test.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('Deploy to OpenShift') {
            steps {
                script {
                    openshift.withCluster() {
                        openshift.withProject('abhay-dev') {
                            def bc = openshift.selector('bc', 'spring-boot-pipeline')
                            bc.startBuild("--wait=true")
                        }
                    }
                }
            }
        }
    }
}
