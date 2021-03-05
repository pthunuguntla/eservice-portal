
Run this application using docker.


Pre Requisite : perform below steps

mvn clean
mvn install


After executing above steps, target folder is created with jar file named <eservice-portal.jar>


Once above step is verified, Please follow the below steps to continue


Make sure docker is installed in your system and login is done.

To check docker installed in system, open terminal and just enter below command

docker -v // it should output docker version

Next step is to build image

navigate to folder from terminal and execute below command

docker build -f Dockerfile -t eservice-portal-backend

once above step is succeeded then image will be created with named (eservice-portal-backend).

To verify execute below command

docker images // this will list all the images 

once we verify our image with named eservice-portal-backend execute below command to start application


docker run -p 8090:8090 eservice-portal-backend


the above will start application on localhost:8090

Happy Using !!


