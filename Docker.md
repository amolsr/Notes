#### Running Bash into docker container
```docker exec -it <ContainerName/ContainerID> bash```

#### Copy File into Docker Container
```docker cp <file-path> <ContainerName>:<destinationPath>```


#### Docker Postgres Setup

1. Open cmd and pull the docker postgres image using command : ```docker pull postgres```

2. Wait for it download

3. Run the container using command : ```docker run --name postgresContainer -e POSTGRES_PASSWORD=123 -d -p 5432:5432 postgres```

4. Verify if the container is running using command : ```docker ps```

5. You can execute psql commands using command : ```docker exec -it ContainerID psql -U postgres```

Where ContainerID is the ID you obtain from docker ps command

6. Once psql opens, use this command to create a test database : ```create DATABASE test_db;```

7. More docker resources : https://hub.docker.com/_/postgres/


#### Docker MySQL Setup

1. Open cmd and pull the docker postgres image using command : ```docker pull mysql```

2. Wait for it download

3. Run the container using command : ```docker run --name mysqlContainer -e MYSQL_ROOT_PASSWORD=123 -d -p 3306:3306 mysql```

4. Verify if the container is running using command : ```docker ps```

5. You can execute psql commands using command : ```docker exec -it ContainerID mysql --user=root --password```

Where ContainerID is the ID you obtain from docker ps command

6. Enter the password.

6. Once mysql opens, use this command to create a test database : ```create DATABASE test_db;```

7. More docker resources : https://hub.docker.com/_/mysql/
