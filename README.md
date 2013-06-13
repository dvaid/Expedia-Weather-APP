Expedia-Weather-APP
===================

Spring MVC application to consumer a weather service to display weather information for a valid zip code in the US


************************ Deployment Instructions ************************

For build re-deployment, Tomcat plugin is requried.
Setting up the Maven Tomcat plugin consists of three steps -

1. Setup a Tomcat manager account.
2. Add the manager credentials to your settings.xml
3. Add the Maven Tomcat plugin to your POM file.

e.g. for step1 &lt;tomcat 6 installation folder&gt;/conf/tomcat-users.xml

&lt;tomcat-users&gt;
  &lt;role rolename="manager-gui"/&gt;
	&lt;role rolename="manager-script"/&gt;
	&lt;user username="admin" password="password" roles="manager-gui, manager-script"/&gt;
&lt;/tomcat-users&gt;

e.g. for step 2  /users/&lt;username&gt;/&lt;.m2 installation folder&gt;/settings.xml
&lt;servers&gt;
	&lt;server&gt;
		&lt;id&gt;myserver&lt;/id&gt;
		&lt;username&gt;admin&lt;/username&gt;
		&lt;password&gt;password&lt;/password&gt;
	&lt;/server&gt;
&lt;/servers&gt;

e.g. for step 3 &lt;your application folder&gt;/pom.xml
The Maven Tomcat Plugin is configured by adding the following XML to the &lt;plugins&gt; section of your project’s POM file:
&lt;plugin&gt;
	&lt;groupId&gt;org.codehaus.mojo&lt;/groupId&gt;
	&lt;artifactId&gt;tomcat-maven-plugin&lt;/artifactId&gt;
	&lt;version&gt;1.1&lt;/version&gt;
	&lt;configuration&gt;
		&lt;server&gt;myserver&lt;/server&gt;
		&lt;url&gt;http://localhost:8080/manager/html&lt;/url&gt;
	&lt;/configuration&gt;
&lt;/plugin&gt;

***************************************************

You can now start your server and run a Maven build using the "mvn install tomcat:deploy" command. Once installed, switch to the "tomcat:redeploy" goal.
