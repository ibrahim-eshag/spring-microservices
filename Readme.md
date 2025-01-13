### Learning Points from this Microservice Project:

1. #### Microservices Architecture: ####

   > How to create a microservices project in Spring Boot, using Spring Boot Cloud, and related dependencies.

2. #### Multi-Module Maven Architecture: ####

   > How to create Multi module Maven project, and knowing parent child modules relationships.

3. #### Custom Module Reusability: ####

   > How to Add and reuse a self developed module in future projects by injecting it as a dependency.

4. #### Entity Mapping Consistency : ####

   > - Ensure that the Java entity field types match the database column types exactly.
   > - For ID fields, verify whether the database column is `String` or a numeric type (like `BIGINT`, `INT`, etc.) and
       adjust the entity class field type accordingly.
   > - When using `@Id` along with `@GeneratedValue` for primary keys, ensure the data type is compatible with the
       chosen
   > - generation strategy (e.g., `AUTO`, `IDENTITY`, or `SEQUENCE` generators are commonly paired with numeric types,
       not
       `String`).

5. #### Clear Understanding of JPA/Hibernate Configuration: #### 

   > - How to Configure Spring Data JPA and Hibernate for database connection settings and entity mappings.
   >- Make sure that the `hibernate.dialect` matches the database (e.g., `PostgreSQL`, `MySQL`, etc.).

6. #### Validation During Development: #### 

   > Validate the schema mapping using Hibernate auto-generation features (e.g.,
   `spring.jpa.hibernate.ddl-auto=validate`
   during development).

7. #### Exceptions handling: #### 

   > How to catch Exceptions

8. #### Primary Key Best Practices: #### 

   > - In this project I preferred using numerical IDs for primary keys where possible to leverage `@GeneratedValue`
       effectively with sequence.
   > - Researching how to make `String` as an ID, using other strategies strategy (e.g., UUID generator).

9. #### Logging : #### 

   > Adding logging for debugging and following issues that may happen.

10. #### Multiple Databases with different DMS : #### 

    > In this project I have used **PostgreSQL**, and **MongoDB** for different Microservices.

11. ### Communications between Microservices : ###

    > **HTTP** has been used as the communication pattern between microservices, at first restTemplate
    was used , then Open Feign was used to abstract clients and reduce redundancy, repeated, and hard to manage
    configurations.

12. ### Service Discovery : ###

    > At first communication between services was done manually by referring to the host and PORT, but since that
    introduce challenges
    in real-world projects, **Eureka Server** was used as Server discovery

13. ### Load Balancing : ###

    > To Efficiently distribute the requests between many instance of the same service, a load balancer (using Round
    Robin) was implemented by utilizing @LoadBalanced annotation. 