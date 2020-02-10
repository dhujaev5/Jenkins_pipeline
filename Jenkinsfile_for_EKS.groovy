node {
    stage("Pull Repo"){
        git 'https://github.com/bkarakas/terraform-iaac-eks-burak'

    }
    stage("stage2"){
        echo "Hello"
        
    }
    stage("stage1"){
         echo "Hello"
        
    }
    stage("stage1"){
         echo "Hello"
        
    }

}