package com.baie.message.stream.config;

import com.baie.message.stream.processor.ProcessorA;
import com.baie.message.stream.processor.ProcessorB;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
public class KafkaSteamConfig {

    @Value("${kafka.application.id}")
    private String applicationId;

    @Value("${spring.kafka.producer.bootstrap-servers}")
    private String bootStrapServices;

    @Value("${kafka.stream.directory}")
    private String stateDirConfig;

    @Value("${kafka.topic.vlv}")
    private String kafkaTopic;

    @Bean(name ="streamProperties")
    public Properties buildStreamsConfig() {
        return buildConfig();
    }

    @Bean(name="topology")
    public Topology buildTopology() {
        Topology topology = new Topology();
        topology.addSource("SOURCE", kafkaTopic)
                // 添加第一个PROCESSOR，param1 定义一个processor名称，param2 processor实现类，param3 指定一个父名称
                .addProcessor("PROCESS1", ProcessorA::new, "SOURCE")

                // 添加第二个PROCESSOR，param1 定义一个processor名称， param2 processor实现类，param3 指定一个父名称
                .addProcessor("PROCESS2", ProcessorB::new, "PROCESS1")

                // 最后添加SINK位置，param1 定义一个sink名称，param2 指定一个输出TOPIC，param3 指定接收哪一个PROCESSOR的数据
                .addSink("SINK1", "topicA", "PROCESS1")
                .addSink("SINK2", "topicB", "PROCESS2");
        return  topology;
    }

    @Bean(name="kafkaStreams")
    public KafkaStreams buildKafkaStreams(@Qualifier("topology") Topology topology, @Qualifier("streamProperties") Properties properties) {
        return new KafkaStreams(topology, properties);
    }

    private Properties buildConfig() {
        Properties config = new Properties();
        // 指定一个应用ID，会在指定的目录下创建文件夹，里面存放.lock文件
        config.put(StreamsConfig.APPLICATION_ID_CONFIG, applicationId);

        // 指定kafka集群
        config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServices);

        // 指定一个路径创建该应用ID所属的文件
        config.put(StreamsConfig.STATE_DIR_CONFIG, stateDirConfig);

        // key 序列化 / 反序列化
        config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());

        // value 序列化 / 反序列化
        config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());

        return config;
    }
}
