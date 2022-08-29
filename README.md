"# news-spring-boot"

**1. Create Mysql database**
```bash
create database newsspringboot
```

**2. Change mysql username and password**
- open file ```src/main/resources/application.properties```
- change `spring.datasource.username` and `spring.datasource.password` your mysql

**3. Request Controller (http://localhost:8081/api)**

### Categories
| Method | 				Url 				| 		Description 		| Sample Valid Request Body |
|--------|----------------------------------|---------------------------|---------------------------|
| GET | /categories | get all category | |
| POST | /categories | create category | |
| PUT | /categories/{id} | update category | |
| DELETE | /categories/{id} | delete category | |


### Users
| Method | 				Url 				| 		Description 		| Sample Valid Request Body |
|--------|----------------------------------|---------------------------|---------------------------|
| GET | /users | get all users | |
| GET | /users/{id} | get user by id | |
| POST | /users | create users | |
| PUT | /users/{id} | update users | |
| DELETE | /users/{id} | delete users | |


### News
| Method | 				Url 				| 		Description 		| Sample Valid Request Body |
|--------|----------------------------------|---------------------------|---------------------------|
| GET | /news | get all news | |
| GET | /news?page={page}&size={size} | get list news with paging | |
| GET | /news/{id} | get news by id | |
| GET | /news/search?keyword={title} | search news by keyword | |
| POST | /news | add news | [JSON] |
| PUT | /news/{id} | update news | [JSON] |
| DELETE | /news | delete news | [ARRAY] |
