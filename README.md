Expedia-Weather-APP
===================

Spring MVC application to consumer a weather service to display weather information for a valid zip code in the US


************************ Deployment Instructions ************************

For build re-deployment, Tomcat plugin is requried.
Setting up the Maven Tomcat plugin consists of three steps -

1. Setup a Tomcat manager account.
2. Add the manager credentials to your settings.xml
3. Add the Maven Tomcat plugin to your POM file.

# e.g. for step1 <tomcat 6 installation folder>/conf/tomcat-users.xml

<tomcat-users>
  <role rolename="manager-gui"/>
	<role rolename="manager-script"/>
	<user username="admin" password="password" roles="manager-gui, manager-script"/>
</tomcat-users>

# e.g. for step 2  /users/<username>/<.m2 installation folder>/settings.xml
<servers>
	  <server>
		<id>myserver</id>
		<username>admin</username>
		<password>password</password>
	</server>
</servers>

# e.g. for step 3 <your application folder>/pom.xml
The Maven Tomcat Plugin is configured by adding the following XML to the <plugins> section of your project’s POM file:
<plugin>
	<groupId>org.codehaus.mojo</groupId>
	<artifactId>tomcat-maven-plugin</artifactId>
	<version>1.1</version>
	<configuration>
		<server>myserver</server>
		<url>http://localhost:8080/manager/text</url>
	</configuration>
</plugin>

***************************************************

You can now start your server and run a Maven build using the "mvn install tomcat:deploy" command. Once installed, switch to the "tomcat:redeploy" goal.
