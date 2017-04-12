import com.cloudbees.plugins.credentials.*
import com.cloudbees.plugins.credentials.domains.*
import com.cloudbees.plugins.credentials.impl.*

configPrefixMessage = "CUSTOM CONFIGURATION"

println "$configPrefixMessage: Configuration usernamePasswordCredentials..."
systemCredProvider = SystemCredentialsProvider.instance

println "$configPrefixMessage: Creating usernamePasswordCredentials..."
credentialsImpl = new UsernamePasswordCredentialsImpl(CredentialsScope.GLOBAL,
        System.env.GIT_NAME,
        'Carlos Frias Credentials',
        System.env.GIT_EMAIL,
        System.env.GIT_PASSWORD)

println "$configPrefixMessage: Searching for existing usernamePasswordCredentials..."
creds = systemCredProvider.credentials
credential = creds.find { it.username == System.env.GIT_EMAIL}
domain = Domain.global()

if(credential) {
    println "$configPrefixMessage: Updating usernamePasswordCredentials..."
    systemCredProvider.updateCredentials(domain, credential, credentialsImpl)
} else {
    println "$configPrefixMessage: Adding usernamePasswordCredentials..."
    systemCredProvider.addCredentials domain, credentialsImpl
}

println "$configPrefixMessage: Saving Credentials..."
systemCredProvider.save()
println "$configPrefixMessage: Credentials configuration complete."