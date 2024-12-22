# Business Rules Resume

This starts with a product register, then you can choose some itens for you purchase. After this you need to register, in this step you will put your custormer datas. In end you can put payment method and finalize. 

This will be precessing and storage all information divided by microservices and database styles, incluided kafka stream for orders processing, and assincronous funcions.


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
