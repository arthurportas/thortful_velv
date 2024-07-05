FROM openjdk:17.0.2

ADD app/ /opt/app/bin/

CMD java \
    -Djava.security.egd=file:/dev/./urandom \
    ${JAVA_OPTS} --add-opens java.base/java.lang.reflect=ALL-UNNAMED --add-opens java.base/java.lang=ALL-UNNAMED \
    -jar /opt/app/bin/*.jar \
    ${APP_OPTS}
