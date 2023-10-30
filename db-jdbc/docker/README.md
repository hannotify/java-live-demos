# Start MySQL with Docker

Run the following command to start MySQL with Docker:

```sh
docker-compose up -d
```

# Connect to the MySQL process in the container

```sh
docker exec -it mysql-environment_mysql_1 mysql -p pubs
```