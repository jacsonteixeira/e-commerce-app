# Configuration

## Docker

To run a new app, you needs to install docker
After install run in terminal: 
```bash
docker compose up -d
```

If you decide to stop, type in terminal: 
```bash
docker compose down
```

## Postgres

To validate postgress, check pgAdmin at url: http://localhost:5050

Type user and password configured in file docker-compose.yml in section pgadmin

After login type root password, anyone you want

Then click in add new server, type a name, and in connection section, in hostname/adress type localhost or

If you are Windows user, you need to check ip from docker image container:
```bash
-docker ps
```

get container id from postgres image, then type:
```bash
 -docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' [postgress_container_id]
 ```

With this you will get ip of postgres, put in hostname/adress, let port in default, give username and password 
configured in docker-compose, postgres section

## Mongodbexpress

To validate mondodbexpress, check at url http://localhost:8081/ , login and password default is:
admin:pass