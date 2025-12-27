#!/bin/bash

cd /tmp && tar -xzf /home/usuario/Downloads/bin/kafka_2.13-4.1.1.tgz

# Format Log Directories
export KAFKA_HOME=/tmp/kafka_2.13-4.1.1
$KAFKA_HOME/bin/kafka-storage.sh format --standalone -t $KAFKA_CLUSTER_ID -c $KAFKA_HOME/config/server.properties

#export KAFKA_LOG4J_OPTS="-Dlog4j2.configurationFile=/tmp/config/log4j2.yaml"
#cp $KAFKA_HOME/config /tmp
# Start the Kafka Server
$KAFKA_HOME/bin/kafka-server-start.sh $KAFKA_HOME/config/server.properties

# Create a topic to store your events
$KAFKA_HOME/bin/kafka-topics.sh --create --topic logs --bootstrap-server localhost:9092
