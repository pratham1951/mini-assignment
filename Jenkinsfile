pipeline {
    agent any
    parameters {
        choice(name: 'ENVIRONMENT',
            choices: [ 'DEVELOPMENT', 'PRODUCTION' ],
            description: 'Choose the environment for this deployment')
        choice(name: 'BRANCH',
            choices: [ 'dev', 'prod' ],
            description: 'Choose the Branch for the deployment')    
    }
    tools {
       maven "MAVEN_HOME"
    }
    
    stages {

        stage('CLEAN WORKSPACE') {
            steps {
                cleanWs()
            }
        }
        
        stage('CODE CHECKOUT') {
            steps {
               git url:'https://github.com/pratham1951/mini-assignment.git', branch :'$BRANCH'
                // checkout scm
            }
        }
        
        
        stage('BUILD') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('SONAR SCANNER') {
            environment {
            sonar_token = credentials('SONAR_TOKEN')
            }
            steps {
                sh 'mvn sonar:sonar -Dsonar.projectName=$JOB_NAME \
                    -Dsonar.projectKey=$JOB_NAME \
                    -Dsonar.host.url=https://crispy-robot-v7pwvgqvvrcpjx5-9000.app.github.dev \
                    -Dsonar.token=$sonar_token'
            }
        } 

        //  stage('Artifactory'){
        //     steps{
            
        //     rtUpload (
        //         serverId: 'artifactory-docker',
        //         spec: '''{
        //               "files": [
        //                 {
        //                   "pattern": "*.war",
        //                   "target": "libs-release-local"
        //                 }
        //              ]
        //         }''',
        //     )
        //     }
        // }

        
        stage ('Deploy to Development environments') {
            when {
                expression { params.ENVIRONMENT != 'PRODUCTION' }
            }
            steps {
                echo "Deploying to ${params.ENVIRONMENT}"
                sh 'docker build -t $JOB_NAME:v1.$BUILD_ID  . '
                sh 'docker stop miniproject || true && docker rm miniproject || true'
                sh 'docker run -d -p 8090:8080  --name miniproject $JOB_NAME:v1.$BUILD_ID'

            }
        }
        stage ('Deploy to production environment') {
            when {
                expression { params.ENVIRONMENT == 'PRODUCTION' }
            }
            steps {
                input message: 'Confirm deployment to production...', ok: 'Deploy'
                echo "Deploying to ${params.ENVIRONMENT}"
                sh 'docker build -t $JOB_NAME:v1.$BUILD_ID  . '
                sh 'docker stop miniproject-prod || true && docker rm miniproject-prod || true'
                sh 'docker run -d -p 9090:8080  --name miniproject-prod $JOB_NAME:v1.$BUILD_ID'
            }
        }
       stage('PUSH DEVELOPMENT IMAGE ON DOCKERHUB') {
           when {
                expression { params.ENVIRONMENT != 'PRODUCTION' }
            }
            environment {
            dockerhub_user = credentials('DOCKERHUB_USER')            
            dockerhub_pass = credentials('DOCKERHUB_PASS')
            }    
            steps{
                sh 'docker tag  $JOB_NAME:v1.$BUILD_ID $dockerhub_user/$JOB_NAME:v1.$BUILD_ID'
                sh 'docker tag $JOB_NAME:v1.$BUILD_ID $dockerhub_user/$JOB_NAME:latest'
                sh 'docker login -u $dockerhub_user -p $dockerhub_pass '
                sh 'docker push $dockerhub_user/$JOB_NAME:v1.$BUILD_ID'
                sh 'docker push $dockerhub_user/$JOB_NAME:latest'
                sh 'docker logout'
            }
        }
        stage('PUSH PRODUCTION IMAGE ON DOCKERHUB') {
            when {
                expression { params.ENVIRONMENT == 'PRODUCTION' }
            }
            environment {
            dockerhub_user = credentials('DOCKERHUB_USER')            
            dockerhub_pass = credentials('DOCKERHUB_PASS')
            }    
            steps{
                sh 'docker tag  $JOB_NAME:v1.$BUILD_ID $dockerhub_user/$JOB_NAME-prod:v1.$BUILD_ID'
                sh 'docker tag $JOB_NAME:v1.$BUILD_ID $dockerhub_user/$JOB_NAME-prod:latest'
                sh 'docker login -u $dockerhub_user -p $dockerhub_pass '
                sh 'docker push $dockerhub_user/$JOB_NAME-prod:v1.$BUILD_ID'
                sh 'docker push $dockerhub_user/$JOB_NAME-prod:latest'
                sh 'docker logout'
            }
        }
        stage('Email Notification')
        {
           steps{
               mail bcc: '', body: '''This Jenkins job ran successfully.
              Thanks & regards
              Pratham Sharma 
              ''', cc: '', from: '', replyTo: '', subject: 'Jenkins Job run Succesfully', to: 'sharmapratham1951@gmail.com'
           }
        }
    }    
     
}        
        
        
