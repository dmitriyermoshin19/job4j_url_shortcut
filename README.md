# job4j_url_shortcut
[![Build Status](https://travis-ci.com/dmitriyermoshin19/job4j_url_shortcut.svg?branch=main)](https://travis-ci.com/dmitriyermoshin19/job4j_url_shortcut)
[![codecov](https://codecov.io/gh/dmitriyermoshin19/job4j_url_shortcut/branch/main/graph/badge.svg)](https://codecov.io/gh/dmitriyermoshin19/job4j_url_shortcut)

### Описание проекта
Сервис позволяет обеспечить безопасность пользователей на сайте заменяя обычные ссылки на преобразованные.  Проект представляет собой так же сервис для сбора статистики посещений страниц для различных сайтов, зарегистрированных в системе. Это веб-приложение реализует принцип архитектуры RESTful.

### Использованные технологии
* Java 14
* Spring Boot 2
* Spring Security & JWT authorization
* Spring Data JPA
* PostgreSQL
* Liquibase
* Maven
* Travis C.I.
* Checkstyle
* Jacoco

### Сценарии использования
Это приложение можно использовать с любой средой разработки, поддерживающей Java (IntellijIDEA, Eclipse, другие).

### HTTP запросы к серверу

#### Регистрация сайта
````
curl --location --request POST 'http://localhost:8080/register' \
--header 'Content-Type: application/json' \
--data-raw '{
    "site": "joob4j.ru"
}'
````

![GitHub Logo](images/reg.png)

#### Повторная регистрация сайта

![GitHub Logo](images/regf.png)

#### Получение токена
````
curl --location --request POST 'http://localhost:8080/login' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json' \
--data-raw '{
    "login": "your_login",
    "password": "your_password"
}'
````

![GitHub Logo](images/gettoken.png)


#### Конвертация ссылки
````
curl --location --request POST 'http://localhost:8080/convert' \
--header 'Authorization: Bearer your_token\
--header 'Content-Type: application/json' \
--data-raw '{
    "url": "http://job4j.ru:8888/TrackStudio/staticframeset.html#253134"
}'
````

![GitHub Logo](images/schort.png)


#### Переадресация. Выполняется без авторизации.
````
curl --location --request GET 'http://localhost:8080/redirect/B170d971' \
````

![GitHub Logo](images/redirect.png)


#### Получение статистики
````
curl --location --request GET 'http://localhost:8080/statistic' \
--header 'Authorization: Bearer your_token\
````

![GitHub Logo](images/stat.png)

#### Контакты
dmstrannnik@bk.ru
