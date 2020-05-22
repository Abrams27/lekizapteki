FROM adoptopenjdk/maven-openjdk11


COPY api/ lekizapteki/api
COPY app/ lekizapteki/app
COPY pom.xml lekizapteki/pom.xml
COPY entrypoint.sh lekizapteki/entrypoint.sh

EXPOSE 7312:7312

ENTRYPOINT ["./lekizapteki/entrypoint.sh"]
