# faux hair salon

#### By _**Joey Arnstein**_

## Description

An exercise in Java for integration testing, BBD, using Sql databases. App allows a user to add stylists and assign clients to them, as well as create and update notes on each client.

## Setup/Installation Requirements

* _Clone this repository_
* _Install the [Java SDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) and [Java SRE](http://www.java.com/en/)._
* _[Install gradle](http://codetutr.com/2013/03/23/how-to-install-gradle/)_

* _Install Postgres
* _In PSQL:
CREATE DATABASE hair_salon;
CREATE TABLE stylists (id serial PRIMARY KEY, name varchar);
CREATE TABLE clients (id serial PRIMARY KEY, name varchar, stylistId int, notes varchar);

* _Navigate back to the directory where this repository has been cloned and run gradle:_
```
$ gradle run
```
* _Open localhost:4567 in a browser._

## _for testing
CREATE DATABASE hair_salon_test WITH TEMPLATE hair_salon;

## Known Bugs

_No current known bugs._

## Support and contact details

_To contact, leave a comment on Github._

## Technologies Used

* _Java_
* _JUnit_
* _FluentLenium_
* _Gradle_
* _Spark_

### License

*MIT License*

Copyright (c) 2016 **_Joey Arnstein_**
