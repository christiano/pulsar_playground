# Apache Pulsar playground

This is a dummy playground project, used for didactic purpose. 

The project consists of:

- A producer (using `POJO` to validate the schema)
- A consumer
- A fake user generation (using the faker project)

It generates a __fatty__ `jar` with dependencies. 

## How to generate the jar

Use Maven to generate the `jar` with dependencies:

```
mvn clean compile assembly:single
```

## How to start the consumer

```
java -jar pulsar_playground-1.0-SNAPSHOT-jar-with-dependencies.jar consumer
```

## How to start the producer

```
java -jar pulsar_playground-1.0-SNAPSHOT-jar-with-dependencies.jar producer
```