1. Gradle dependencies 
   org.springframework.boot:spring-boot-autoconfigure
   org.springframework.boot:spring-boot-configuration-processor

2. Properties entity, used to bind with the properties defined in application.properties

3. Define the AutoConfiguration to create the bean

4. Create META-INF/spring.factories

5. Package jar
   version '1.0-SNAPSHOT'
   jar {
       baseName = 'country-spring-boot-starter'
       enabled = true
   }
   bootJar {
       enabled = false
   }

@ConditionalOnClass：当类路径classpath下有指定的类的情况下进行自动配置
@ConditionalOnMissingBean:当容器(Spring Context)中没有指定Bean的情况下进行自动配置
@ConditionalOnProperty(prefix = “example.service”, value = “enabled”, matchIfMissing = true)，当配置文件中example.service.enabled=true时进行自动配置，如果没有设置此值就默认使用matchIfMissing对应的值
@ConditionalOnMissingBean，当Spring Context中不存在该Bean时。
@ConditionalOnBean:当容器(Spring Context)中有指定的Bean的条件下
@ConditionalOnMissingClass:当类路径下没有指定的类的条件下

@ConditionalOnExpression:基于SpEL表达式作为判断条件

@ConditionalOnJava:基于JVM版本作为判断条件
@ConditionalOnJndi:在JNDI存在的条件下查找指定的位置
@ConditionalOnNotWebApplication:当前项目不是Web项目的条件下
@ConditionalOnWebApplication:当前项目是Web项目的条件下
@ConditionalOnResource:类路径下是否有指定的资源
@ConditionalOnSingleCandidate:当指定的Bean在容器中只有一个，或者在有多个Bean的情况下，用来指定首选的Bean
