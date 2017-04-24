//credentials = new File("${System.env.JENKINS_HOME}/plugin_config/credentials.groovy")
//if(credentials.exists()) {
//    println "INIT: Loading Credentials Configuration..."
//    evaluate(credentials)
//    println "INIT: Credentials Configuration Loaded."
//}

credentials = new File("${System.env.JENKINS_HOME}/plugin_config/stringCredentials.groovy")
if(credentials.exists()) {
    println "INIT: Loading StringCredentials Configuration..."
    evaluate(credentials)
    println "INIT: StringCredentials Configuration Loaded."
}

gitScm = new File("${System.env.JENKINS_HOME}/plugin_config/gitScm.groovy")
if(gitScm.exists()) {
    println "INIT: Loading GitSCM Configuration..."
    evaluate(gitScm)
    println "INIT: GitSCM Configuration Loaded."
}

maven = new File("${System.env.JENKINS_HOME}/plugin_config/maven.groovy")
if(maven.exists()) {
    println "INIT: Loading Maven Configuration..."
    evaluate(maven)
    println "INIT: Maven Configuration Loaded."
}

node = new File("${System.env.JENKINS_HOME}/plugin_config/nodejs.groovy")
if(node.exists()) {
    println "INIT: Loading NodeJS Configuration..."
    evaluate(node)
    println "INIT: Maven NodeJS Loaded."
}

