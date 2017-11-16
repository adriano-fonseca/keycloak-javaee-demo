# Keycloak Java EE Demo

Demo for Java EE and Keycloak SSO integration.
To try this you need to have the keycloak server running, you can do that in a docker engine throug the commands bellow:
 
```
docker container run --name db --rm -p 5432:5432 -v /home/adr-fonseca/docker/docker-postgres/postgresql/:/var/lib/postgresql -e DB_USER=app -e DB_PASS=app -e DB_NAME=app -e DB_USER=keycloak -e DB_PASS=keycloak -e DB_NAME=keycloak adrianofonseca/postgres:9.5
```

```
docker run --name keycloak -e KEYCLOAK_USER=keycloak -e KEYCLOAK_PASSWORD=keycloak --link db:postgres -e POSTGRES_DATABASE=keycloak -e POSTGRES_USER=keycloak -e POSTGRES_PASSWORD=keycloak jboss/keycloak
```

After you will need to add a realm and set your client configuration tu use a public schema your client configuration should seems like follows:

![alt text](https://github.com/adriano-fonseca/keycloak-javaee-demo/blob/master/src/main/webapp/static/client_config.png "Client config")


 

