"# news-spring-boot"

**1. Create Mysql database**
```bash
create database newspringboot
```

**2. Change mysql username and password**
- open file ```src/main/resources/application.properties```
- change `spring.datasource.username` and `spring.datasource.password` your mysql

**3. Request Controller (http://localhost:8081/api)**

### Categories
| Method | 				Url 				| 		Description 		|
|--------|----------------------------------|---------------------------|
| GET	 | /categories						| get all category			|


### Users
| Method | 				Url 				| 		Description 		|
|--------|----------------------------------|---------------------------|
| GET	 | /users							| get all users				|
| GET	 | /users/{id}						| get user by id			|


### News
| Method | 				Url 				| 		Description 		|
|--------|----------------------------------|---------------------------|
| GET	 | /news							| get all news				|
| GET	 | /news?page={page}&limit={limit}	| get list news with paging |
| GET	 | /news/{id}						| get news by id 			|
| GET	 | /news/search?keyword={title}		| search news by keyword	|
| POST   | /news							| add news [JSON]			|
| PUT	 | /news/{id}						| update news				|
| DELETE | /news							| delete news [array]		|
