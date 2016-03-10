# LogAppSql

###Prerequisites you need;
* JDK Version 1.8.0_73
* mysql Server version: 5.6.28-0
* apache-maven-3.3.9
* tomcat-8.0.32

###How to configure 
- Open the terminal and shutdown the tomcat server if it is running, by the command ``$CATALINA_HOME/binshutdown.sh``.
- Then move to the application directory 'LogAppSql' by ``cd /Projects/LogAppSql`` and type ``mvn clean install``.
- Then it builds the project and make the war file as LogAppSql.war inside the LogAppSql directory.

###How to deploy in Tomcat server
- Then copy the LogAppSql.war file into your tomcat's webbapps directory as follows.
``~/LogAppSql cp LogAppSql.war /usr/local/tomcat-8.0.32/webapps ``
- Start the tomcat server by the command ``$CATALINA_HOME/bin/startup.sh start``.

###How to run
- Open the browser and type the URL as "localhost:8080/LogAppSql" or "127.0.0.01:8080/LogAppSql". (here 8080 is the tomcat's configured port)
- Then the index page of the application should appear.
- Also, if you navigate to the localhost:8080/manager, you will see a directory named /LogAppSql. When click on it also gives the index page.
