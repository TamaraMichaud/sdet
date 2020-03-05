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

> docker run -d -p 4444:4444  -v /dev/shm:/dev/shm selenium/standalone-chrome:latest

^ docker run {background} {port} {som

^ -d == background, out of the way.  NB: this information can also be found in the Selenium Docker github readme
^ 4444:4444 << {my local port}:{container-port} : basically, redirect what appears to be a local call, to my container
^ -v /dev/shm:/dev/shm << these paths help Chrome/Firefox not break by allowing docker to use the host's shared memory

^ returns an id of some kind...  so then run again
> docker ps

to see more

