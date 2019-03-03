--------- for server --------
1. add dependencies, don't forget dependencyManagement

dependencies {
    implementation 'org.springframework.cloud:spring-cloud-config-server'
}

dependencyManagement {

    imports {
        mavenBom "org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}"
    }
}

2. specify config file url, spring.cloud.config.server.git.uri is the git url
spring.cloud.config.server.git.uri=https://github.com/vlv3530359/baie.git
spring.cloud.config.server.git.searchPaths=config-server/cloud-config

3. @EnableConfigServer

4. verify by url
http://localhost:8082/message-dev.properties


------ for client -------
1. add dependencies, don't forget dependencyManagement

dependencies {
    implementation 'org.springframework.cloud:spring-cloud-starter-config'
}

dependencyManagement {
    imports {
        mavenBom "org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}"
    }
}
2. specify config server in application.properties
#spring.cloud.config.label=1002  default is master
#spring.cloud.config.profile=dev  if there is no file like message-dev.properties will ready the message.properties
spring.cloud.config.uri=http://localhost:8888/