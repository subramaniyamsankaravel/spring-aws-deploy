pipeline{
  agent any
    stages{
      stage ('ssh-test'){
        steps{
          sshagent(['4caf8f9d-4507-4358-a814-4a2866505100']){
            sh 'ssh -o StrictHostKeyChecking=no ubuntu@18.216.159.12 pwd'
            }
            }
            }
            }
            }
