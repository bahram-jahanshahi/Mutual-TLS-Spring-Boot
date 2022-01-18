# Mutual TLS and Spring Boot
This project aims to implement a solution for **secure data transfer between client and server** via **mutual TLS**.  
There are four goals to achieve:
1. Server identity
2. Client identity
3. Manipulation of data
4. Visibility of dat

## HTTPS Everywhere

## Enabling HTTPS on the server
The first step is to generate a key store includes private and public key.
```shell
keytool -v -genkeypair -keystore https-server/src/main/resources/server-identity.jks -storepass password -keypass password -keyalg RSA -keysize 2048 -alias https-server -validity 3650 -deststoretype pkcs12
```
Then it's the time to enable https on spring boot adding these lines to the ``application.properties``
```properties
server.ssl.enabled=true
server.ssl.key-store=classpath:server-identity.jks
server.ssl.key-password=password
server.ssl.key-store-password=password
```
Congratulations! You enabled TLS-encrypted connection!

