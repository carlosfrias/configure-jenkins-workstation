configPrefixMessage = "CUSTOM CONFIGURATION"

println "$configPrefixMessage: Configuring Git"
import jenkins.model.Jenkins
import hudson.tools.*
import hudson.plugins.git.*

descriptor = Jenkins.instance.getDescriptorByType(hudson.plugins.git.GitSCM.DescriptorImpl.class)
println "$configPrefixMessage: Configuring GitSCM..."

println "$configPrefixMessage: Setting global git properties..."
descriptor.globalConfigName = System.env.GIT_NAME
descriptor.globalConfigEmail = System.env.GIT_EMAIL
descriptor.createAccountBasedOnEmail = false

println "$configPrefixMessage: Saving Git Configuration."
descriptor.save()

println "$configPrefixMessage: Git Configuration Complete."
