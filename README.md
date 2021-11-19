# Pet Store API

## Running the test suite

To run the test suite, navigate to the root folder and run the following command

    ./gradlew test

Then after the execution, navigate to the build/reports/tests/test directory and open the index.html file to view the final report created from the test. All the test outputs and test statuses will be displayed in this file.

## Building and deploying the API

First, a native image of the application must be created by running following command in the root folder of the project

    ./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true

As the next step, package this native image with docker by running the following command in the root directory.

    ./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true -Dquarkus.container-image.build=true

Then, the application and the Grafana dashboard can be deployed by running the following command by in the build folder

    docker-compose up

## Accessing the pet store API

After successfully deploying the application, the pet store will be available on the address, http://localhost:8080

## Accessing the pet store API insights

The Grafana dashboard will be available at the following address. The API insights can be viewed by entering admin:admin credentials by visiting the address, http://localhost:3000

After deploying the application, the APIs can be accessed via CURL/WGET tools. Following section contains the instructions to run a simple API request to the pet store API using above tools

## CURL

All the pet details can be retrieved by running the following command in a terminal. 
    
    curl http://localhost:8080/pets

## WGET

Details of the pet with id number 1 can be retrieved by running the following command in a terminal.

    wget http://localhost:8080/pets/1

-------------------------------------------------------------------------------------------------
    
## Additional Details

The application can be also built running the following command

    ./gradlew build -Dquarkus.package.type=uber-jar

Then the application can be executed by entering following command

    java -jar build/petstore-runner.jar

## Running the application in developer mode

You can run your application in dev mode that enables live coding using:

    ./gradlew quarkusDev
