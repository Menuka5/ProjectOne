# Project one
___

### Introduction

This project is to practice JSP and serverlets. Main objective of this project is a simple login function using the different methods

1. embedded credintials
2. mysql stored credintials 
3. mongodb stored credintials

___

### Prerequisite

This project created using below sdk's and built tools.

1. **java version "1.8.0_74"**
2. **Java(TM) SE Runtime Environment (build 1.8.0_74-b02)**
3. **Apache Maven 3.3.9**

and deployed and tested on

* **apache-tomcat-8.0.32**

___

### Configuration and building

1. First there are three type of web app in the **ProjectOne** project, go to the project you want to built the .war files.

`cd $BASE_FOLDER/Menuka-login`

then run maven to bulid the .war file.

`mvn clean install`

you can see you war file in created target folder. 

___

### How to Deploy.

As Mentioned before the .war file in the target directory. Copy it and paste it into **$CATALINA_HOME/webapp** folder. Restart the tomcat server. Then type in web browser's address bar

`localhost:8080/Menuka-login`

(Here I use the Menuka-login because I did the those steps with it. You must add your web app name after localhost:8080)

___
