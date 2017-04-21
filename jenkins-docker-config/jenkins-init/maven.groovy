
import hudson.tasks.*
import hudson.tasks.Maven.*
import jenkins.model.*

configPrefixMessage = "CUSTOM CONFIGURATION"

println "$configPrefixMessage: Configuring Maven..."
descriptor = Jenkins.instance.getDescriptorByType(Maven.DescriptorImpl.class)
if(!descriptor.installations.size()) {
    println "$configPrefixMessage: Creating a Maven Configuration..."
    installation = new Maven.MavenInstallation("Maven 3.3.9", "/usr/share/maven/apache-maven-3.3.9", null)
    descriptor.installations = [ installation ]
    descriptor.save()
    println "$configPrefixMessage: Saved Maven configuration."
}