pipeline {

 agent { label 'perf-testing-node'}

 stages {

 stage('Gatling preparation') {
    steps {
       sh "mkdir /var/tmp/gatling3"
      
       sh "wget https://repo1.maven.org/maven2/io/gatling/highcharts/gatling-charts-highcharts-bundle/3.0.3/gatling-charts-highcharts-bundle-3.0.3-bundle.zip -P /var/tmp/gatling3"
      
       sh "unzip -o /var/tmp/gatling3/gatling-charts-highcharts-bundle-3.0.3-bundle.zip -d /var/tmp/gatling3"
      
       sh "export GATLING_HOME=”/var/tmp/gatling3/gatling-charts-highcharts-bundle-3.0.3\""
      
       sh "export PATH=$PATH:/var/tmp/gatling3/gatling-charts-highcharts-bundle-3.0.3/bin"
   }
 }

 stage('Performance Tests') {
  steps{
       dir('.') {
           sh "gatling.sh -rf . -rsf src/resources/ -sf src/simulations/ -s Simulation_Class_Name"
           gatlingArchive()
          }
    }

  }

}
}
