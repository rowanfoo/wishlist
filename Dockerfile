FROM openjdk:8-jdk-alpine
EXPOSE 8045
ADD target/wishlist-0.0.1-SNAPSHOT.jar wishlist.jar
RUN echo "Asia/Kuala_Lumpur" > /etc/timezone
# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/wishlist.jar"]
