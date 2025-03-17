# Spring gRPC Client Security CSRF

Start the grpc server:

```shell
cd server;
./mvnw spring-boot:run
```

Then start the application using the grpc client:

```shell
cd client;
./mvnw spring-boot:run
```

Send a request using either GET or POST:

```shell
http -a user:password GET :8080 name==World
```

```shell
http -a user:password POST :8080 name=World
```

The post request will fail with error 403. The logs with show:

```log
Invalid CSRF token found for http://localhost:8080/
```

Indicating the CSRF filter is still active, despite being disabled in the filter chain configuration.
