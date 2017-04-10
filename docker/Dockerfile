FROM jenkins:2.46.1

COPY ssh/ /usr/share/jenkins/ref/.ssh
COPY ./jenkins_plugins.txt /usr/share/jenkins/ref
COPY ./init.groovy /usr/share/jenkins/ref/init.groovy
COPY ./credentials.groovy /usr/share/jenkins/ref/plugin_config/credentials.groovy
COPY ./maven.groovy /usr/share/jenkins/ref/plugin_config/maven.groovy
COPY ./gitScm.groovy /usr/share/jenkins/ref/plugin_config/gitScm.groovy

USER root
RUN /bin/chown jenkins /usr/share/jenkins/ref/.ssh/id_rsa
RUN /bin/chown jenkins /usr/share/jenkins/ref/.ssh/id_rsa.pub
RUN /bin/chown jenkins /usr/share/jenkins/ref/jenkins_plugins.txt
RUN /bin/chown jenkins /usr/share/jenkins/ref/init.groovy
RUN /bin/chown jenkins /usr/share/jenkins/ref/plugin_config/credentials.groovy
RUN /bin/chown jenkins /usr/share/jenkins/ref/plugin_config/maven.groovy
RUN /bin/chown jenkins /usr/share/jenkins/ref/plugin_config/gitScm.groovy

USER jenkins
RUN /usr/local/bin/plugins.sh /usr/share/jenkins/ref/jenkins_plugins.txt
