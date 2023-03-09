# Advisor app

### Language: Java (version 17.0.6)
### Framework: Spring boot (version 3.0.2)

---

## Run with JAR

### Install dependencies and build the JAR
Run ``gradle build``

### Start the application by running

~~~
java \
-Dninja.api-key=axm28RlQA+lj1nAtf7Q6hg==J1K1HMnOBplpdfz3 \
-Dspring.security.user.name=advisor \
-Dspring.security.user.password=f7cd82c8-ac20-4380-8977-07bdb0f291cf \
-Dedamam.app-id=b2771b14 -Dedamam.app-key=cc745cfd1b7364aeaed05d726a012ff4 \
-Dspoonacular.api-key=ee1e32845d554092af39d65cecb22b54 \
-jar ./build/libs/advisor-app-0.0.1-SNAPSHOT.jar
~~~

---

## Run with Docker

### Build Docker Image
``docker build . -t winglok0416/advisor-app:{version}``

### Push Docker Image
``docker push winglok0416/advisor-app:{version}``

### Create and Run Docker Container
~~~
docker run \
-e NINJA_API_KEY={Your NINJA API KEY} \
-e AUTH_USER_NAME="advisor" \
-e AUTH_USER_PASSWORD={Your custom auth password} \
-e EDAMAM_APP_ID={Your EDAMAM APP ID} \
-e EDAMAM_APP_KEY={Your EDAMAM APP KEY} \
-e SPOONACULAR_API_KEY={Your SPOONACULAR API KEY} \
-p 80:8080 -d --name advisor-app --restart always winglok0416/advisor-app:{version}
~~~