docker build -f docker/Dockerfile -t fischermatte/bookstore .
docker run -p 8080:8080 -t fischermatte/bookstore:latest
docker run -i -t fischermatte/bookstore /bin/bash
# list all running container
docker ps -a
# stop all container
docker stop $(docker ps -a -q)
# remove all container
docker rm $(docker ps -a -q)
# get ip of docker container
docker-machine ip