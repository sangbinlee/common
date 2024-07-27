pipeline {
    agent any 	// 사용 가능한 에이전트에서 이 파이프라인 또는 해당 단계를 실행
    stages {
        stage('Checkout') { 
            steps {
                sh 	'echo  git source 다운로드를 수행합니다. -> git clone'
            }
        }
        stage('Build') { 
            steps {
                sh 	'echo "빌드" 단계와 관련된 몇 가지 단계를 수행합니다.'
                sh 'chmod +x gradlew'
                sh  './gradlew clean build -x test'
                sh 'ls -al ./build'
                sh 'ls -al ./build/libs'
                sh 'pwd'
            }
            post {
                success {
                    echo 'gradle build success'
                }

                failure {
                    echo 'gradle build failed'
                }
            }
        }
        stage('Test') { 
            steps {
                echo  '테스트 단계와 관련된 몇 가지 단계를 수행합니다.'
            }
        }
        stage('Deploy') { 
            steps {
                sh  'echo "배포" 단계와 관련된 몇 가지 단계를 수행합니다.'
//                dir('build/libs'){
//                    sh '''
//                    CURRENT_PID=$(ps -ef | grep java | grep common | grep -v nohup | awk '{print $2}')
//                    if [ -z ${CURRENT_PID} ] ; then
//                        echo "> 현재 구동중인 애플리케이션이 없으므로 종료하지 않습니다."
//                    else
//                        echo "> 실행중인 어플리케이션 : $CURRENT_PID"
//                        sudo kill -9 $CURRENT_PID
//                        sleep 10
//                    fi
//                    
//                    echo "> common 배포 작업 시작"
//                    JENKINS_NODE_COOKIE=dontKillMe nohup java -jar common-0.0.1-SNAPSHOT.jar &
//                    '''
//                }
                sh '''
//                CURRENT_PID=$(PS -EF | GREP JAVA | GREP COMMON | GREP -V NOHUP | AWK '{PRINT $2}')
//                IF [ -Z ${CURRENT_PID} ] ; THEN
//                    ECHO "> 현재 구동중인 애플리케이션이 없으므로 종료하지 않습니다."
//                ELSE
//                    ECHO "> 실행중인 어플리케이션 : $CURRENT_PID"
//                    SUDO KILL -9 $CURRENT_PID
//                    SLEEP 10
//                FI
                
                ECHO "> COMMON 배포 작업 시작"
                JENKINS_NODE_COOKIE=DONTKILLME NOHUP gradlew bootRun &
                '''
            }
        }
    }
}