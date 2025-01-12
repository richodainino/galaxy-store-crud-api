# Galaxy Store CRUD API

Welcome to the Galaxy Store CRUD API! This API allows you to perform Create, Read, Update, and Delete (CRUD) operations on a database table called `application`. The `application` table contains the following fields:
- `id`: Unique identifier for each application using UUID
- `title`: Title of the application
- `publisher`: Publisher of the application
- `description`: Description of the application
- `price`: Price of the application

## Description

The Galaxy Store CRUD API is designed to manage a list of applications in an app store. It provides a set of endpoints to create new applications, retrieve details of existing applications, update application information, and delete applications from the database. The API is built using Spring Boot and follows RESTful principles to ensure a clean and efficient design.

### Key Features

- **Add New Application:** Add new application to the store with details such as title, publisher, description, and price.
- **Get Applications:** Retrieve information about specific application using their unique identifiers or retrieve all applications that exist in the database.
- **Update Application:** Modify the details of existing application, including title, publisher, description, and price.
- **Delete Application:** Remove application from the store by their unique identifiers using soft delete method to ensure a safer deletion.

### API Documentation

For detailed information about the API endpoints, please refer to the [Postman documentation](https://documenter.getpostman.com/view/13493249/2sAYQWJtTE).
