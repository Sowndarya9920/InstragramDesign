
# ***Instagram Design***

- The aim of the project is to perform the basic CRUD operations with some authentication and mappings.
- Spring initializer was used to create a spring boot application project.


## **Frameworks and Languages used :**

- Java
- Spring Boot

## **Dependency used :**

- Spring web
- Spring Boot Dev Tool
- Lombok
- Validations
- MySQL Driver

## **Data Flow :**

## **Model :** 

- It consists of a  ___Userclass___ , ___PostClass___and ___AuthenticationClass___ which consists of Entity's used to model our data application.
- By using Lombok dependency , ___@Data___ , ___@AllArgsConstructor___ , ___@NoArgsConstructor___ is used to create getters and setters as well as default and parameterized constructors.

## **Controller :**

- It consists of ___PostController___and ___UserController___ class which basically control the flow of data.
- ___@RestController___ annotation is used to make the RestaurantController class as controller layer.
- ___@GetMapping , @PostMapping , @PutMapping , @DeleteMapping___ annotations are used to perform the CRUD operations.




- ### **API Reference :**

### **User Controller :**

#### ***SignIn***

```http
  http://localhost:8080/signIn
```

#### ***SignUp***

```http
  http://localhost:8080/signUp
```


#### ***Update users by email***

```http
  http://localhost:8080/getEmployeeById/{id}
```



### **Post Controller :**

#### ***Add posts***

```http
  http://localhost:8080/save
```

#### ***Get All posts***

```http
  http://localhost:8080/get
```



## **Service :** 

- It consists of ___UserService___, ___AuthenticationService___  and ___PostService___ class which helps us to write the business functionalities.
- ___@Service___ annotation is used to make the class as a service layer.

## **Repository :**
- It consists of ___IUserDao___ , ___IPostDao and ___IAuthenticationDao___ which is used to manage or datas.
- ___@Repository___ annotation is used to make the class repository layer.





## **Summary :**

- In this project , I had created the RestApi's performing various ___CRUD operations___ such as fetch , save , delete and update users.
- The RestApi's are tested by using ___Postman___ which is a client used to test our Api's.
- The data's were stored in the ___MySQL database___ which is ___persistent database___.

