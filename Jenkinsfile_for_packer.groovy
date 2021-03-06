node {
    properties(
        buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '', numToKeepStr: '3')),
        [parameters([
            choice(choices: [
                'golden_ami', 
                'tower', 
                'elk', 
                'nagiosxi', 
                'gitlab', 
                'nexus'
                'vault'
                'artemisv1'], 
                description: 'What tool would you like to build', 
                name: 'TOOL_TO_PROVISION'), 
                choice(choices: [
                    'us-east-1', 
                    'us-east-2', 
                    'us-west-1', 
                    'us-west-2'], 
                    description: 'Please choose a region', name: 'AMI_REGION')])])

    stage("Pull Repo"){
        git 'https://github.com/farrukh90/packer.git'
    }
    stage("Build Image"){
        sh "packer version"
       // sh "packer build -var region=${AMI_REGION} tools/TOOL_TO_PROVISION.json"
        
    }
    stage("Send Notification to Slack"){
     //   slackSend channel: 'nagios_alerts', message: "${TOOL_TO_PROVISION} has been built"
        
    }
    stage("Send Email"){
        mail bcc: '', 
        body: "hi your ami created IN ${AMI_REGION} ", 
        cc: '', from: '', replyTo: '', 
        subject: "${TOOL_TO_PROVISION}created Thanks", 
        to: 'anyemail2020@yahoo.com'
    }
}
