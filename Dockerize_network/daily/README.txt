./mvnw clean package -DskipsTests
target

docker-compose up
docker-compose down

http://localhost:2222

docker image ls
docker ps

#CREATE
http://localhost:2222/api/v1/daily/create
{
    "dailyHeader":"header2",
    "dailyContent":"içerik2",
    "email":"email@xyz.com",
    "password":"Şifre1"
}

#Listelemek
http://localhost:2222/api/v1/daily/

#FIND
http://localhost:2222/api/v1/daily/1

#DELETE
http://localhost:2222/api/v1/daily/1

#UPDATE
http://localhost:2222/api/v1/daily/1
