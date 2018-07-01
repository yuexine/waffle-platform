pipeline {
  agent any
  stages {
    stage('compile') {
      steps {
        echo 'hello, world'
        sh 'mvn -B -DskipTests -DskipDockerfile clean package'
      }
    }
  }
}