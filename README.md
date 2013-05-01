# tomcat-deployment-webapp-experiment

A lab aimed to develop a "typical" solution for Spring MVC/Maven web application deployment to Tomcat 7. Requirements are:

1. There should be a solution to run application locally.
2. There should be a solution to configure, build and deploy application to Tomcat 7 server.

## How to play with it

1. Running application locally using embedded Jetty: `mvn clean jetty:run-exploded`. Because I have no idea how to make it work with `jetty:run` without lots of extra stuff in `pom.xml`, my solution is: first, build `war` package and explode it, then, run exploded package with Jetty.
2. Deploying application to Tomcat 7 (predefined settings): `mvn clean tomcat7:redeploy -Ptomcat-deployment`
3. Deploying application to Tomcat 7 (Teamcity settings): `mvn clean tomcat7:redeploy -Pteamcity`. This will expect the environment to provide:
 * `TOMCAT_SERVER` - server name described in Maven's `settings.xml`.
 * `TOMCAT_URL` - URL of Tomcat's management application. Normally, something like `http://localhost:8080/manager/text`.
 * `TOMCAT_PATH` - relative path to deploy application to. Example: `/experiment`.
 * `ENVNAME` - used only for illustrative purposes. Can be whatever desired.
 * `ROOTURL` - used only for illustrative purposes. Can be whatever desired.

## Environment pre-configuration

Tomcat 7 should have a user with deployment permissions. This is done by making changes to `[tomcat7]/conf/tomcat-users.xml`:    

    <tomcat-users>
      ...
      <user name="deployer" password="deploy123" roles="manager-script" />
      ...
    </tomcat-users>
    
Deployment requires Maven to have credentials for accessing Tomcat's management service. This is done by making changes to `settings.xml`:

    <settings>
      ...
      <servers>
        ...
        <server>
          <id>TomcatServer</id> <!-- It's, BTW, what `TOMCAT_SERVER` is -->
          <username>deployer</username>
          <password>deploy123</password>          
        </server>
        ...
      </servers>
      ...
    </settings>
