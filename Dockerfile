FROM java:openjdk-8u111-alpine
CMD java ${JAVA_OPTS} -jar eventuate-tram-0.0.1-SNAPSHOT.jar
COPY build/libs/eventuate-tram-0.0.1-SNAPSHOT.jar .
