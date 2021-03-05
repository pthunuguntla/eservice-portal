
Run this application using docker.


Please follow the below steps to continue


Make sure docker is installed in your system and login is done.

To check docker installed in system, open terminal and just enter below command

docker -v // it should output docker version

Next step is to build image

navigate to folder from terminal and execute below command

docker build -f Dockerfile -t eservice-portal-ui

once above step is succeeded then image will be created with named (eservice-portal-ui).

To verify execute below command

docker images // this will list all the images 

once we verify our image with named eservice-portal-ui execute below command to start application


docker run -p 3000:3000 eservice-portal-ui


the above will start application on localhost:8090

Happy Using !!


If there is no docker installed,

Navigate to folder


perform npm istall

wait for installation to be done and then

npm start


