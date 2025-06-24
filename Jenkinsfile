pipeline {
    agent any

    stages {
        stage('Clone') {
            steps {
                git 'https://github.com/Abhay19999/opens-shift-test.git'
            }
        }

        stage('Build') {
            steps {
                sh './mvnw clean install -DskipTests'
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
