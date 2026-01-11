## LOMBOK ISSUE IN INTELLIJ IDEA
Starting with the next lecture, we'll be using Lombok annotations in our code. However, some students using the latest version of IntelliJ IDEA might encounter compilation issues related to these annotations. To ensure a smooth experience, please follow the steps below.

If you’re not facing any issues, feel free to skip this in

🛠️ Step 1: Enable Annotation Processing in IntelliJ IDEA

Open IntelliJ IDEA, navigate to Settings --> Build, Execution, Deployment --> Compiler --> Annotation Processors and ensure that the checkbox "Enable annotation processing" is checked



🛠️ Step 2: Update pom.xml Build Configuration

Open your pom.xml file and replace the existing build configuration with the following snippet:

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <annotationProcessorPaths>
                        <path>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                            <version>${lombok.version}</version>
                        </path>
                    </annotationProcessorPaths>
                </configuration>
            </plugin>
        </plugins>
    </build>

install lombok dependency and make sure to install the lombok Plugin for Intellij ( file→setting→plugin )

## Quick SQL setup properties

yml

```
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/interviewdb?createDatabaseIfNotExist=true
    username: root
    password: admin

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

properties

```
spring.datasource.url=jdbc:mysql://localhost:3306/interviewdb?createDatabaseIfNotExist=true
spring.datasource.username= root
spring.datasource.password = admin

spring.jpa.hibernate.ddl-auto = update

spring.jpa.show-sql=true
```
