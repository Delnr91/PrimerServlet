# Proyecto PrimerServlet

## Descripción

Este proyecto es una aplicación web Java configurada con Maven y NetBeans, destinada a ilustrar el uso de servlets y otras tecnologías relacionadas. El proyecto utiliza `Tomcat` como servidor de despliegue y varias dependencias de Eclipse para la persistencia y manejo de datos.

## Estructura del Proyecto

El proyecto contiene los siguientes archivos de configuración clave:

- `pom.xml`: Archivo de configuración de Maven que gestiona las dependencias y plugins necesarios para el proyecto.
- `nb-configuration.xml`: Archivo de configuración de NetBeans que incluye propiedades específicas del IDE para el proyecto.
- `index.jsp`: Página JSP que proporciona la interfaz de usuario para interactuar con el backend.

## Requisitos Previos

Antes de configurar y ejecutar este proyecto, asegúrate de tener instalados los siguientes requisitos:

- [Java Development Kit (JDK) 7](https://www.oracle.com/java/technologies/javase/javase7-archive-downloads.html)
- [Apache Maven](https://maven.apache.org/)
- [Apache Tomcat](https://tomcat.apache.org/)
- [NetBeans IDE](https://netbeans.apache.org/)

## Configuración del Proyecto

## 1. Clonar el Repositorio

Clona el repositorio en tu máquina local usando el siguiente comando:

```bash
git clone https://github.com/Delnr91/PrimerServlet.git
PrimerServlet
```

## 2. Configurar el Archivo pom.xml:
   
El archivo pom.xml gestiona las dependencias del proyecto. Asegúrate de que las versiones de las dependencias sean correctas y estén actualizadas. Este archivo incluye dependencias esenciales como org.eclipse.persistence, javax, y mysql-connector-j. Además, configura los plugins necesarios para la compilación y despliegue del proyecto.

## 3. Configurar el Archivo nb-configuration.xml:

Este archivo contiene configuraciones específicas de NetBeans para el proyecto, incluyendo la versión de Java EE y el servidor de despliegue (Tomcat). Estas configuraciones aseguran que el proyecto se integre correctamente con el IDE.
```bash
<properties xmlns="http://www.netbeans.org/ns/maven-properties-data/1">
    <org-netbeans-modules-maven-j2ee.netbeans_2e_hint_2e_j2eeVersion>1.7-web</org-netbeans-modules-maven-j2ee.netbeans_2e_hint_2e_j2eeVersion>
    <org-netbeans-modules-maven-j2ee.netbeans_2e_hint_2e_deploy_2e_server>Tomcat</org-netbeans-modules-maven-j2ee.netbeans_2e_hint_2e_deploy_2e_server>
</properties>
```
## 4. Configurar la Página index.jsp
La página index.jsp proporciona la interfaz de usuario para interactuar con el backend. Incluye formularios para agregar, ver, editar y eliminar usuarios.

## 5. Compilar y Ejecutar el Proyecto
Navega al directorio del proyecto y usa Maven para compilar el proyecto:

```bash
mvn clean install
```
Una vez compilado, puedes desplegar la aplicación en Apache Tomcat. Asegúrate de que Tomcat esté configurado y en funcionamiento. Puedes copiar el archivo WAR generado en el directorio target a la carpeta webapps de Tomcat o usar un comando Maven para desplegar directamente:

```bash
mvn tomcat7:deploy
```
## 6. Acceder a la Aplicación
Abre un navegador web y accede a la URL donde Tomcat está sirviendo tu aplicación, típicamente:
```bash
http://localhost:8080/PrimerServlet
```
# Proyecto Maven

Este proyecto Maven utiliza varias dependencias clave para proporcionar funcionalidad de persistencia, APIs de Java EE y conectividad con MySQL. A continuación se describen las dependencias principales incluidas en el archivo `pom.xml`:

## Dependencias

### EclipseLink

**Grupo:** `org.eclipse.persistence`  
**ArtifactId:** `org.eclipse.persistence.jpa`  
**Versión:** `2.7.9`  

EclipseLink es utilizado para la persistencia y el mapeo objeto-relacional (ORM).

### Java EE APIs

**Grupo:** `javax`  
**ArtifactId:** `javaee-api`  
**Versión:** `8.0`  
**Alcance:** `provided`  

Incluye las APIs de Java EE necesarias para la aplicación web. Estas APIs proporcionan las interfaces y clases necesarias para el desarrollo de aplicaciones empresariales en Java.

### MySQL JDBC Connector

**Grupo:** `mysql`  
**ArtifactId:** `mysql-connector-java`  
**Versión:** `8.0.23`  

El conector JDBC para la base de datos MySQL permite que la aplicación se conecte y trabaje con bases de datos MySQL.

## Instalación

Para usar estas dependencias, asegúrate de incluirlas en tu archivo `pom.xml`. Luego, puedes compilar y ejecutar tu proyecto Maven normalmente.

```xml
<dependencies>
    <!-- EclipseLink for ORM -->
    <dependency>
        <groupId>org.eclipse.persistence</groupId>
        <artifactId>org.eclipse.persistence.jpa</artifactId>
        <version>2.7.9</version>
    </dependency>

    <!-- Java EE APIs -->
    <dependency>
        <groupId>javax</groupId>
        <artifactId>javaee-api</artifactId>
        <version>8.0</version>
        <scope>provided</scope>
    </dependency>

    <!-- MySQL JDBC Connector -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.23</version>
    </dependency>
</dependencies>

```
## Plugins de Maven

Este proyecto utiliza varios plugins de Maven para gestionar la compilación, empaquetado y despliegue del proyecto.

### maven-compiler-plugin

Este plugin se utiliza para la compilación del código fuente. Configura el nivel de compatibilidad de Java y otras opciones de compilación.

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>3.8.1</version>
    <configuration>
        <source>1.8</source>
        <target>1.8</target>
    </configuration>
</plugin>
```
### maven-war-plugin
Este plugin se utiliza para empaquetar la aplicación como un archivo WAR (Web Application Archive). Es esencial para aplicaciones web que se desplegarán en un servidor de aplicaciones.

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-war-plugin</artifactId>
    <version>3.3.1</version>
    <configuration>
        <failOnMissingWebXml>false</failOnMissingWebXml>
    </configuration>
</plugin>
```
### maven-dependency-plugin
Este plugin se utiliza para manejar las dependencias específicas del proyecto. Permite copiar, resolver y analizar dependencias.

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-dependency-plugin</artifactId>
    <version>3.1.2</version>
    <executions>
        <execution>
            <id>copy-dependencies</id>
            <phase>package</phase>
            <goals>
                <goal>copy-dependencies</goal>
            </goals>
            <configuration>
                <outputDirectory>${project.build.directory}/lib</outputDirectory>
            </configuration>
        </execution>
    </executions>
</plugin>
```


## Contribuir

Si deseas contribuir a este proyecto, por favor sigue estos pasos:

1. Haz un fork del repositorio.

2. Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`).

3. Realiza tus cambios y haz commit (`git commit -am 'Agrega nueva funcionalidad'`).

4. Empuja la rama (`git push origin feature/nueva-funcionalidad`).

5. Abre un Pull Request.

   
## Contacto

Para cualquier duda o consulta, por favor contacta a:

- **Nombre**: [Daniel Núñez Rojas]
- **Email**: [invdesdelnr@outlook.com]
- **LinkedIn**: []





