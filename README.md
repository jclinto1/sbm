
* The Build
* Project Structure
* Deployment using Docker

The Build
=========

Maven is used to build the source as well as TravisCI.

To build from source run:

mvn clean package -DskipDocker

Project is structure with the following modules
===============================================

* sbm-grpc-api
* sbm-grpc-gateway
* sbm-core

sbm-grpc-api
------------

Module is designed to be used on the client side and provides a gRPC implementation of the API and the ability to stub the api for canned reponses useful for testing.

sbm-grpc-gateway
----------------

Module provides a gRPC gateway into the core and manages in memory which clients are connected both in and out bound events.

sbm-core
--------

Module manages access to the in-memory Live Order Board and state changes based on register and cancel order events. 

Deployment using Docker
=======================

Docker is used for deployment and is used to validate end to end the system is working as expected.


Micro Typing
============

There're a number of places where wrapping lower-level types like 'double quantity' into 'Quantity quantity' are an option, however
this does result in more objects being created and didn't add enough value for me at this stage to warrant it.
