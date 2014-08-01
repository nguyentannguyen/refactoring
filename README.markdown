Java Refactoring Test Project
=============================

**Please, before starting the test read these instructions carefully.**

Introduction
------------

This is a refactoring testing project used for our hiring process.

The idea of this exercise is to evaluate your ability to identify poor coding practices and improve the code through the use of best practices.

The main project is a very basic user management application. We are not looking to add any supplementary features, instead we are verifying the following:

* Your knowledge of REST.
* Your knowledge of Maven.
* Your ability to identify and refactor poor Java code.
* Your ability to identify and fix bugs.
* Your ability to apply proven design principles.
* Your ability to write useful and effective tests.

Feel free to modify whatever you want! :)

Pre-reqs
--------

* The first thing you need is to have a github account. If you don't have it yet, you can create it on [github website][2].

* This repo uses git as SCM. If you don't have it you need to install it on your machine. You can download git for your OS on the [official git website][3]

* To build this project you must install Maven. If you do not have it installed, please refer to the [maven website][1] for assistance.

* For deployment you can use any web container/application server you want. We used tomcat version 7.0.26 to validate if the application was starting up correctly.

Instructions
------------

1. Fork this repo from the github website to your github account.
1. Clone your new forked repo from github to your computer.
1. At the project root directory, run:
    `$ mvn package`
1. At this point the maven build should run successfully and every test should be passing.
1. Perform the refactoring you deem necessary, following what you know to be the best practices. (feel free to innovate!).
1. At the end of your work you should push the code to your forked repo. (Attention: You should **NOT** do a pull request).
1. The final step is to send an email to your contact at the company informing him/her that you finished the test and the username you used on github.

Good luck!

[1]: http://maven.apache.org/
[2]: https://github.com/
[3]: http://git-scm.com/
