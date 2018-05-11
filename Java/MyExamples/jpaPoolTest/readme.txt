Enable connection pool using the servlet container (Tomcat)
-----------------------------------------------------------
This Spring application includes both Dev and Production settings for JPA Connection Pool.
It is an MVC application, but the main point here is 
how to setup a connection pool using the application server(tomcat in this case).
 
Instructions:
------------
In the (context.xml) file inside tomcat installation (or if you  are using Eclipse, in the "Servers" expand in the project explorer, on your left) add the following:


<!-- Dev env. DB connections pool -->
<Resource 
        name="jdbc/SpringJpa"
        auth="Container" 
        type="javax.sql.DataSource"
		maxTotal="55" 
		maxIdle="21"
		minIdle="13"
		maxWaitMillis="10000"
		timeBetweenEvictionRunsMillis="34000"
		minEvictableIdleTimeMillis="55000"
		validationQuery="SELECT 1"
      	        testOnBorrow="true"
    	        removeAbandonedOnBorrow="true"
    	        removeAbandonedTimeout="233"
		username="USERNAME" password="PASSWORD"
		driverClassName="com.microsoft.sqlserver.jdbc.SQLServerDriver"
		defaultTransactionIsolation="READ_COMMITTED"
		url="jdbc:sqlserver://127.0.0.1:4433;DatabaseName=tds_netdb;" 
/>
	
	<!-- Production env. DB connections pool-->
<!-- <Resource 
                name="jdbc/SpringJpa"
                auth="Container" 
                type="javax.sql.DataSource"
		maxTotal="377" 
		maxIdle="233"
		minIdle="89"
		maxWaitMillis="10000"
		timeBetweenEvictionRunsMillis="34000"
		minEvictableIdleTimeMillis="55000"
		validationQuery="SELECT 1"
    	        testOnBorrow="true"
    	        removeAbandonedOnBorrow="true"
    	        removeAbandonedTimeout="55"
		username="USERNAME" password="PASWSWORD"
		driverClassName="com.microsoft.sqlserver.jdbc.SQLServerDriver"
		defaultTransactionIsolation="READ_COMMITTED"
		url="jdbc:sqlserver://127.0.0.1:4433;DatabaseName=tds_netdb;" 
	/> -->