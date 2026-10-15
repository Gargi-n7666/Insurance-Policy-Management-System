# Insurance Policy Management System

Beginner Spring Boot CRUD API based on the provided requirement document.

## Tech stack
Java 17, Spring Boot 3, Spring Web, Spring Data JPA, Hibernate, MySQL, Validation, Maven, Postman. Lombok is used to generate getters/setters/constructors. Enable annotation processing in your IDE if needed.

## Setup
1. Install JDK 17 and MySQL 8.
2. Run `CREATE DATABASE insurance_db;` in MySQL.
3. In `src/main/resources/application.properties`, replace `CHANGE_ME` with your local MySQL password. Never commit real credentials.
4. Open the folder as a Maven project and run `InsuranceApplication.java`.
5. API base URL: `http://localhost:8080`.

## Main endpoints
Admin customers: `POST/GET /api/admin/customers`, `GET/PUT/DELETE /api/admin/customers/{id}`, `POST /api/admin/customers/{id}/login-account`.
Admin policies: `POST /api/admin/policies?customerId=1`, `GET /api/admin/policies`, `GET/PUT/DELETE /api/admin/policies/{id}`.
Admin payments: `GET /api/admin/payments`, `PUT/DELETE /api/admin/payments/{id}`.
Admin claims: `GET /api/admin/claims`, `PUT /api/admin/claims/{id}/status`, `DELETE /api/admin/claims/{id}`.
Customer APIs: `GET /api/customer/customers/{id}`, `GET /api/customer/customers/{id}/policy`, `POST/GET /api/customer/policies/{id}/payments`, `POST/GET /api/customer/policies/{id}/claims`, `PUT /api/customer/claims/{id}`.
Login: `POST /api/login`.

## Sample create-customer JSON
```json
{"name":"Asha Patil","address":"Pune, Maharashtra","email":"asha@example.com","phoneNumber":"9876543210","age":28,"gender":"Female"}
```
## Sample create-policy JSON
Send `POST /api/admin/policies?customerId=1` with:
```json
{"policyNumber":"POL-1001","policyType":"HEALTH","coverageAmount":500000.00,"startDate":"2026-01-01","endDate":"2026-12-31","policyStatus":"ACTIVE","agentId":101,"agentName":"Ravi Deshmukh","agentBranch":"Pune","agentContact":"9876501234"}
```
## Important limitations
This is a learning project, not a production insurance system. The basic login compares plain-text passwords only to mirror the brief; never use that in a real application. Admin/customer URL prefixes do not implement security or authorization. Add password hashing and Spring Security before any real deployment. Entity responses are returned directly for simplicity.


## Service interface structure (updated)
Business service contracts are declared in `service/` and implemented in `service/impl/`.
Controllers depend on the interfaces, while Spring injects the corresponding `@Service` implementation.
For example, `CustomerService` is the interface and `CustomerServiceImpl` contains the CRUD logic.


## Eclipse setup (Java 17)

1. Extract this ZIP to a normal folder.
2. In Eclipse choose **File > Import > Maven > Existing Maven Projects** and select the extracted folder containing `pom.xml`.
3. Choose **Maven > Update Project** after import.
4. Create a MySQL database named `insurance_db`.
5. Edit `src/main/resources/application.properties` and set your MySQL username/password.
6. Run `InsuranceApplication.java` as **Spring Boot App**.

This project does not require Lombok; entity getters and setters are written explicitly.
