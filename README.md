# Library Catalogue

Данное веб-приложение представляет собой библиотечную картотеку. Оно позволяет добавлять, редактировать и удалять новые книги и пользователей. Каждый человек может закрепить за собой(взять домой) несколько книг. 

## Установка
Для установки достаточно стянуть репозиторий и настроить подключение к бд в файле application.properties. Код для создания таблиц в бд нахоится в src/main/sql/libraryCatalogueDB.sql.
Также необходимо добавить в application.properties следующую строку, чтобы разблокировать скрытые HTTP методы PATCH и DELETE:
```
spring.mvc.hiddenmethod.filter.enabled=true
```

#### Стек: Java, Spring Boot, PostgreSQL, JDBCTemplate, Thymeleaf
