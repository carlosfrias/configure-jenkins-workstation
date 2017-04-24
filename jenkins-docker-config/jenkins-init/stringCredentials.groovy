import com.cloudbees.plugins.credentials.*
import com.cloudbees.plugins.credentials.domains.*
import com.cloudbees.plugins.credentials.impl.*
import org.jenkinsci.plugins.plaincredentials.impl.StringCredentialsImpl
import hudson.util.Secret

configPrefixMessage = "CUSTOM CONFIGURATION"

println "$configPrefixMessage: Configuration StringCredentials..."
systemCredProvider = SystemCredentialsProvider.instance

println "$configPrefixMessage: Creating StringCredentials..."
secret = Secret.fromString(System.env.GIT_SECRET_TOKEN)
credentialsImpl = new StringCredentialsImpl(
        CredentialsScope.GLOBAL,
        System.env.GIT_NAME,
        'Github Personal Token',
        secret)

println "$configPrefixMessage: Searching for existing StringCredentials..."
creds = systemCredProvider.credentials
credential = creds.find { it.username == System.env.GIT_NAME}
domain = Domain.global()

if(credential) {
    println "$configPrefixMessage: Updating StringCredentials..."
    systemCredProvider.updateCredentials(domain, credential, credentialsImpl)
} else {
    println "$configPrefixMessage: Adding StringCredentials..."
    systemCredProvider.addCredentials domain, credentialsImpl
}

println "$configPrefixMessage: Saving StringCredentials..."
systemCredProvider.save()
println "$configPrefixMessage: StringCredentials configuration complete."