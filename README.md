# Food app backend

### Language: Java (version 17.0.6)
### Framework: Spring boot (version 3.0.2)

---

## Run with JAR

### Install dependencies and build the JAR
Run ``gradle build``

### Start the application by running

~~~
java \
-Dninja.api-key={Your NINJA API KEY} \
-Dspring.security.user.name=advisor \
-Dspring.security.user.password={Your custom auth password} \
-Dspoonacular.api-key={Your SPOONACULAR API KEY} \
-jar ./build/libs/food-app-backend-0.0.1-SNAPSHOT.jar
~~~

---

## Run with Docker

### Build Docker Image
``docker build . -t winglok0416/food-app-backend:{version}``

### Push Docker Image
``docker push winglok0416/food-app-backend:{version}``

### Create and Run Docker Container
~~~
docker run \
-e NINJA_API_KEY={Your NINJA API KEY} \
-e AUTH_USER_NAME="advisor" \
-e AUTH_USER_PASSWORD={Your custom auth password} \
-e SPOONACULAR_API_KEY={Your SPOONACULAR API KEY} \
-p 80:8080 -d --name food-app-backend --restart always winglok0416/food-app-backend:{version}
~~~