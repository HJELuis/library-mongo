# Getting started

This project uses the next Docker images: [mongo](https://hub.docker.com/_/mongo)  [mongo-express](https://hub.docker.com/_/mongo-express)

## Commands to create containers

`docker run -d --rm --name mongo -e MONGO_INITDB_ROOT_USERNAME=root -e MONGO_INITDB_ROOT_PASSWORD=toor -p 27017:27017 mongo`

`docker run -d --rm --name mongo-express -e ME_CONFIG_MONGODB_ADMINUSERNAME=root -e ME_CONFIG_MONGODB_ADMINPASSWORD=toor -e ME_CONFIG_MONGODB_URL=mongodb://root:toor@172.17.0.2:27017/ -p 8081:8081 mongo-express`

## Before execution

You've already created a database `libreria`

