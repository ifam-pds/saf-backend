###Configuração

Servidor : [Wildfly 10.1.0.Final](http://download.jboss.org/wildfly/10.1.0.Final/wildfly-10.1.0.Final.zip). Baixar e inicializar.

Baixar o [mysql-connector](http://central.maven.org/maven2/mysql/mysql-connector-java/6.0.4/mysql-connector-java-6.0.4.jar)

Colocar na pasta `[RAIZ_JBOSS]/standalone/deployments/`

Pela linha de comando a partir da pasta `[RAIZ_JBOSS]/bin/` executar

`./jboss-cli.sh --connect` ou `jboss-cli.bat --connect`

Executar o comando abaixo substituindo `<SENHA>` pela senha verdadeira ou omitir caso não haja senha

```data-source add --name=safDS --driver-name=mysql-connector-java-6.0.4.jar --jta=true --connection-url=jdbc:mysql://localhost:3306/saf --jndi-name=java:jboss/datasources/safDS --user-name=root --password=<SENHA> --max-pool-size=25```


###Deploy

A partir da raiz do projeto

```$ mvn install -pl web -am && mvn wildfly:deploy -pl web```