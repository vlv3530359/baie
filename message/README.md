1. Start up the Kafka cluster
   bin/zookeeper-server-start.sh config/zookeeper.properties
   bin/kafka-server-start.sh config/server-0.properties
   bin/kafka-server-start.sh config/server-1.properties
   bin/kafka-server-start.sh config/server-2.properties

2. Kafka dependencies 
   org.apache.kafka:kafka-streams
   org.springframework.kafka:spring-kafka

3. Kafka Message
   
4. Kafka Stream
   3.1 Define the Processor
   3.2 Define the Topology
   3.2 Define the KafkaStreams
   
5. Test Kafka Message
   5.1 http://localhost:8080/kafka/stream/start
   5.2 http://localhost:8080/kafka/batchsend  post
   
6. Kafka Message
   6.1 Define the Producer
   6.2 Define the Consumer
