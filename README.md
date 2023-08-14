# Spring OAuth2 Client GitHub Demo
This repository shows how to build a simple application using [Spring OAuth2 Client](https://docs.spring.io/spring-security/reference/servlet/oauth2/client/index.html).

The goal of the application is to create secured [Spring Web](https://docs.spring.io/spring-framework/reference/web/webmvc.html) application, that enable login via [GitHub](https://github.com).

## Prerequisites
- `Java` version 17 or later.
- [GitHub](https://github.com) account. 
- Text editor or IDE.
- `Maven`

## Setup Project
1. Clone this repository.
2. Configure `GITHUB_CLIENT_ID` and `GITHUB_CLIENT_SECRET` to `.env` file.
```
# .env file example
GITHUB_CLIENT_ID=<your-app-client-id>
GITHUB_CLIENT_SECRET=<your-app-client-secret>
```

>you'll have to register oauth2 application with github to get `client-id` and `client-secret` for your application.
> 
>you can read on how to create github oauth2 app here: https://docs.github.com/en/apps/oauth-apps/building-oauth-apps/creating-an-oauth-app .</br> </br> make sure the "callback" URL to point `http://localhost:8080/login/oauth2/code/github` .

## Run the Application
- With Maven : `./mvnw clean install`
- or run the application with an IDE.
>Once the application starts, point your browser to `http://localhost:8080`
