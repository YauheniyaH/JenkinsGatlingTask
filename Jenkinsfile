pipeline {

 agent any

 stages {

 stage('Gatling preparation') {
    steps {
      sh "rm -rf /var/tmp/gatling3"
       sh "mkdir /var/tmp/gatling3"
      
       sh "/opt/homebrew/bin/wget https://repo1.maven.org/maven2/io/gatling/highcharts/gatling-charts-highcharts-bundle/3.3.0/gatling-charts-highcharts-bundle-3.3.0-bundle.zip -P /var/tmp/gatling3"
      
       sh "unzip -o /var/tmp/gatling3/gatling-charts-highcharts-bundle-3.3.0-bundle.zip -d /var/tmp/gatling3"
      
       sh "export GATLING_HOME=/var/tmp/gatling3/gatling-charts-highcharts-bundle-3.3.0"
      
       sh "export PATH=$PATH:/var/tmp/gatling3/gatling-charts-highcharts-bundle-3.3.0/bin"
   }
 }

 stage('Performance Tests') {
  steps{
       dir('.') {
           sh "/var/tmp/gatling3/gatling-charts-highcharts-bundle-3.3.0/bin/gatling.sh -rf . -rsf src/resources/ -sf src/simulations/ -s PerfTestSimulation"
           gatlingArchive()
          }
    }

  }

}
}
