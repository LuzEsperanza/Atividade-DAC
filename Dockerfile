FROM postgres:10
ENV POSTGRES_DB dac-jsf
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD 12345
COPY create.sql /docker-entrypoint-initdb.d/
