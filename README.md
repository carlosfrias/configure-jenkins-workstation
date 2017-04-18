# Configure Jenkins Workstation

This repository is used to help manage creating a Jenkins instance that can be configured and 
running very quickly with the plugins and configurations that are necessary.

## Usage Overview

We need to configure your workstation to work with Docker and Ansible. We then use Ansible
to build the Jenkins infrastructure that will be provisioned with Docker. The top level steps to 
follow: 

* Install Docker
* Install Ansible
* Configure Jenkins plugins list
* Install and run Jenkins
 
### Configure Jenkins Plugins 
Review and update the `docker/jenkins-plugins.txt` to ensure your required plugins are installed.

### Install and Run Jenkins
Install and run Jenkins on docker with: `ansible-playbook jenkins-build.yml -e container_name=mycontainer`

 