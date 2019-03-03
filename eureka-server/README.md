---------server----------
1. introduce jar

dependencies {
    implementation 'org.springframework.cloud:spring-cloud-starter-config' #don't for get the config client jar if you want to use the spring cloud config
    implementation 'org.springframework.cloud:spring-cloud-starter-netflix-eureka-server'
}

dependencyManagement {
    imports {
        mavenBom "org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}"
    }
}

2. @EurekaApplication

3. Specify the properties 
eureka.instance.hostname=localhost
eureka.client.registerWithEureka=false
eureka.client.fetchRegistry=false
eureka.client.serviceUrl.defaultZone=http://localhost:8881/eureka/

4. verify by url
http://localhost:8888/eureka-server.properties

------client-----
1. jar
spring-cloud-starter-netflix-eureka-client

2. @EnableEurekaClient

3. register with 
eureka.client.serviceUrl.defaultZone=http://localhost:8881/eureka/


