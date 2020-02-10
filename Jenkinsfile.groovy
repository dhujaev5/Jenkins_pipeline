node {
    stage("Pull Repo"){
        echo "Hello"
    }
    stage("Build Image"){
        sh "packer version"
        
    }
    stage("Send Notification to Slack"){
        echo "Hello"
        
    }
    stage("Send Email"){
        echo "Hello"
    }
}
