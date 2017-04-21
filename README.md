# Configure Jenkins Workstation

This repository is used to help manage creating a Jenkins instance that can be configured and 
ready for local development.

## Usage Overview

We need to configure your workstation with Docker and Ansible. We then use Ansible
to build the Jenkins infrastructure that will be provisioned with Docker. The top level steps to 
follow: 

* Create SSH key pair
* Install Docker
* Install Ansible
* Configure Jenkins plugins list
* Create and update ~/.apigee/credentials.yml
* Install and run Jenkins

### Create SSH Key Pair

Use ssh to create a key pair. Open a terminal and invoke ```ssh-keygen``` accepting default 
parameters for test purposes.

### Install Docker
Install Docker for your platform following the installation instructions provided by Docker 
at https://docs.docker.com/engine/installation.

### Install Ansible
Install Ansible for your platform following the installation instructions provided by Ansible
at http://docs.ansible.com/ansible/intro_installation.html.
 
### Configure Jenkins Plugins 
You can have Jenkins plugins installed when the Docker image is constructed. Review and update 
the file `jenkins-docker-config/jenkins-init/jenkins-plugins.txt` with your required plugins. 
Plugins are listed in the following format:
```jenkins plugin id:plugin version```

### Create and update ~/.apigee/credentials.yml
Sensitive attributes such as passwords are stored in the credentials.yml file located in a folder
called .apigee in the user home. This is a YAML formatted file. Please follow these instructions
to set this up:
 
    mkdir ~/.apigee
    touch ~/.apigee/credentials.yml
    cp templates/credentials.yml.template ~/.apigee/credentials.yml
    
#### ~/.apigee/credentials.yml
Please edit the file ```~/.apigee/credentials.yml``` with your credentials.    

### Install and Run Jenkins
Install and run Jenkins on docker with: `ansible-playbook jenkins-docker-build-init.yml`
