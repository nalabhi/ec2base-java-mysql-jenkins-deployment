FROM centos:7
RUN mkdir -p /opt/tomcat/
WORKDIR /opt/tomcat
RUN curl -O https://dlcdn.apache.org/tomcat/tomcat-9/v9.0.62/bin/apache-tomcat-9.0.62.tar.gz
RUN tar xvfz apache*.tar.gz
RUN mv apache-tomcat-9.0.62/* /opt/tomcat/.
RUN yum install java-1.8.0-openjdk -y
RUN java -version
WORKDIR /opt/tomcat/webapps
COPY target/*.war /opt/tomcat/webapps
ENV dbDriver=com.mysql.jdbc.Driver dbConnectionUrl=jdbc:mysql://mysqldb-container:3306/collegeapp_db dbUserName=root dbPassword=user123
EXPOSE 8080
CMD ["/opt/tomcat/bin/catalina.sh", "run"]
