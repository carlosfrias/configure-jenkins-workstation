# Configure Jenkins Workstation

This repository is used to help manage creating a Jenkins instance that can be configured and 
running very quickly with the plugins and configurations that are necessary.

## Usage
* Install Docker
* Install ansible
* Configure Jenkins plugins list
* Install and run Jenkins
 
### Configure Jenkins Plugins 
Review and update the `docker/jenkins-plugins.txt` to ensure your required plugins are installed.

### Install and Run Jenkins
Install and run Jenkins on docker with: `ansible-playbook jenkins-build.yml -e container_name=mycontainer`

 