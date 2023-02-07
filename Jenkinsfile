def CONTAINER_NAME = "department-service"
def CONTAINER_TAG = getTag(env.BUILD_NUMBER)
def HTTP_PORT = "5054"
node{
    try{
        stage('Initialize') {
            def dockerHome = tool 'DockerLaTest'
            def mavenHome = tool 'MavenLaTest'
            env.PATH = "${dockerHome}/bin:${mavenHome}/bin:${env.PATH}"
        }

        stage('Checkout') {
            checkout scm
        }

        stage('Build with test') {
            sh "mvn clean install"
        }

        stage("Image Prune") {
            imagePrune(CONTAINER_NAME)
        }

        stage ('Image Build'){
            imageBuild(CONTAINER_NAME, CONTAINER_TAG)
        }

        stage('Push to Docker Registry') {
            withCredentials([usernamePassword(credentialsId: 'dockerhubcredential', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                pushToImage(CONTAINER_NAME, CONTAINER_TAG, USERNAME, PASSWORD)
            }
        }

        stage ('Clear Image'){
            clearImage(CONTAINER_NAME, CONTAINER_TAG)
        }

//         stage('Run App') {
//             withCredentials([usernamePassword(credentialsId: 'dockerhubcredential', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
//                 runApp(CONTAINER_NAME, CONTAINER_TAG, USERNAME, HTTP_PORT)
//
//             }
//         }


    } finally{
        deleteDir()
    }
}