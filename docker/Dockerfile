FROM jenkins:2.46.1
COPY ./jenkins_plugins.txt /usr/share/jenkins/ref
USER root
RUN /bin/chown jenkins /usr/share/jenkins/ref/jenkins_plugins.txt
USER jenkins
RUN /usr/local/bin/plugins.sh /usr/share/jenkins/ref/jenkins_plugins.txt
