# TODO Test with version 2.32.2 which is used by RCCL
FROM jenkins:2.46.1

USER root
RUN apt-get update -y
RUN apt-get install -y tree maven git
COPY ssh/ /usr/share/jenkins/ref/.ssh
COPY ./jenkins_plugins.txt /usr/share/jenkins/ref
COPY ./init.groovy /usr/share/jenkins/ref/init.groovy
COPY ./credentials.groovy /usr/share/jenkins/ref/plugin_config/credentials.groovy
COPY ./maven.groovy /usr/share/jenkins/ref/plugin_config/maven.groovy
COPY ./gitScm.groovy /usr/share/jenkins/ref/plugin_config/gitScm.groovy

RUN /bin/chmod 0400 /usr/share/jenkins/ref/.ssh/id_rsa
RUN /bin/chmod 0400 /usr/share/jenkins/ref/.ssh/id_rsa.pub
RUN /bin/chmod 0544 /usr/share/jenkins/ref/.ssh/known_hosts
RUN /bin/chown jenkins:jenkins /usr/share/jenkins/ref/.ssh/id_rsa
RUN /bin/chown jenkins:jenkins /usr/share/jenkins/ref/.ssh/id_rsa.pub
RUN /bin/chown jenkins:jenkins /usr/share/jenkins/ref/jenkins_plugins.txt
RUN /bin/chown jenkins:jenkins /usr/share/jenkins/ref/init.groovy
RUN /bin/chown jenkins:jenkins /usr/share/jenkins/ref/plugin_config/credentials.groovy
RUN /bin/chown jenkins:jenkins /usr/share/jenkins/ref/plugin_config/maven.groovy
RUN /bin/chown jenkins:jenkins /usr/share/jenkins/ref/plugin_config/gitScm.groovy
ADD node-v6.10.2-linux-x64.tar.xz /var/jenkins_home/apps/
RUN ln -s /var/jenkins_home/apps/node-v6.10.2-linux-x64/bin/node /usr/bin/node
RUN ln -s /var/jenkins_home/apps/node-v6.10.2-linux-x64/bin/npm /usr/bin/npm
RUN /bin/chown -R jenkins:jenkins /var/jenkins_home
RUN /bin/chown -R jenkins:jenkins /var/jenkins_home/apps
ENV PATH="$PATH:/var/jenkins_home/apps/node-v6.10.2-linux-x64/bin"

USER jenkins
RUN /usr/local/bin/plugins.sh /usr/share/jenkins/ref/jenkins_plugins.txt
