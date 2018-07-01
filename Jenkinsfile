pipeline {
  agent {
    docker {
      image 'maven:3-alpine'
      args '-v /root/.m2:/root/.m2'
    }

  }
  stages {
    stage('compile') {
      steps {
        echo 'hello, world'
        sh 'mvn -B -DskipTests -Ddockerfile.skip clean package'
      }
    }
  }
}