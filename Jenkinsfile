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
            }
        }
        stage('Deploy') { 
            steps {
                sh  'echo "배포" 단계와 관련된 몇 가지 단계를 수행합니다.'
            }
        }
    }
}