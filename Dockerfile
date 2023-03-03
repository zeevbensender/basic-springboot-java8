FROM openjdk

RUN groupadd --gid 1000 jgroup \
    && useradd --uid 1000 --gid jgroup --shell /bin/bash --create-home juser

WORKDIR application
ARG JAR_FILE=/target/*.jar
COPY ${JAR_FILE} nodeport.jar

RUN jar xfv nodeport.jar \
    && rm nodeport.jar \
    && chown -R juser:jgroup . 

USER juser
ENTRYPOINT ["java", "-cp", "./classes:./BOOT-INF/classes:./BOOT-INF/lib/*", "com.lupo.nodeport.NodeportApplication"]