1. Start up the Kafka cluster
   cd /Users/vlv/Documents/shared/kafka/kafka_2.11-2.1.0
   bin/zookeeper-server-start.sh config/zookeeper.properties
   bin/kafka-server-start.sh config/server-0.properties
   bin/kafka-server-start.sh config/server-1.properties
   bin/kafka-server-start.sh config/server-2.properties
   
2. Startup ConfigServerApplication

3. Startup EurekaApplication
   
4. Test Kafka Message
   5.1 http://localhost:8080/kafka/stream/start
   5.2 http://localhost:8080/kafka/batchsend  post
   checking log
   
   http://localhost:8081/kafka/send?message=mymessage
   
   
5. Kafka dependencies 
      org.apache.kafka:kafka-streams
      org.springframework.kafka:spring-kafka

6. Kafka Stream
   3.1 Define the Processor
   3.2 Define the Topology
   3.2 Define the KafkaStreams
   
7. Kafka Message
   6.1 Define the Producer
   6.2 Define the Consumer
     
8. Kafka Message configuration is in ConfigServerApplication

9. There is a customized starter

Issues:
1. Make sure the MessageApplication is under package path com.baie else can't find the bean of integrationAPIService 


