// get data from db
// convert to json
// pass as body for api
(// compare api result against db)

----------------
DOCKER
-> (see Selenium Docker github account for better info re: selenium images)
-> once logged into Docker desktop:

> docker ps

^ will confirm if any containers are running in your machine already

> docker pull selenium/standalone-chrome\
> docker pull selenium/standalone-chrome:latest

> docker pull selenium/standalone-chrome:{version-number}

^ download an image.  if no ":{version-number}", it will just use ":latest"

> docker images

^ show all installed images