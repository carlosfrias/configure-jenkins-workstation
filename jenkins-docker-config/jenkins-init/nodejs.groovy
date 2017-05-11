import hudson.tasks.*
import jenkins.model.*
import jenkins.plugins.nodejs.tools.*
import jenkins.plugins.nodejs.*


configPrefixMessage = "CUSTOM CONFIGURATION"

println "$configPrefixMessage: Configuring NodeJS..."
descriptor = Jenkins.instance.getDescriptorByType(NodeJSInstallation.DescriptorImpl.class)
if(!descriptor.installations.size()) {
    println "$configPrefixMessage: Creating a NodeJS Configuration..."
    installation = new NodeJSInstallation('NodeJS', null, null, Platform.LINUX)
    descriptor.installations = [ installation ]
    descriptor.save()
    println "$configPrefixMessage: Saved NodeJS configuration."
}
