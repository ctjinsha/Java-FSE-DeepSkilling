
# Difference between JPA, Hibernate and Spring Data JPA

## Java Persistence API (JPA)

* JPA stands for **Java Persistence API**.
* It is a **specification (JSR 338)** for Object Relational Mapping (ORM).
* It defines standard APIs for storing, retrieving, updating, and deleting Java objects from a database.
* JPA does **not** provide an implementation.
* It requires an implementation such as Hibernate.

### Features

* Standard ORM specification
* Database-independent
* Uses annotations like `@Entity`, `@Id`, `@Table`
* Improves portability between ORM implementations

### Example

```java
import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
}
```

---

## Hibernate

* Hibernate is an **Object Relational Mapping (ORM) framework**.
* It is one of the most widely used **implementations of JPA**.
* Hibernate maps Java objects to database tables automatically.
* It provides additional features beyond JPA.

### Features

* Implements JPA
* Supports HQL (Hibernate Query Language)
* Caching
* Lazy Loading
* Batch Processing
* Automatic table creation

### Example

```java
public Integer addEmployee(Employee employee) {

    Session session = factory.openSession();
    Transaction tx = null;
    Integer employeeID = null;

    try {
        tx = session.beginTransaction();
        employeeID = (Integer) session.save(employee);
        tx.commit();
    } catch (HibernateException e) {
        if (tx != null)
            tx.rollback();
    } finally {
        session.close();
    }

    return employeeID;
}
```

---

## Spring Data JPA

* Spring Data JPA is a **Spring Framework module**.
* It simplifies database access by reducing boilerplate code.
* It works with JPA implementations such as Hibernate.
* It provides built-in CRUD operations through repositories.

### Features

* Reduces boilerplate code
* Provides `JpaRepository`
* Automatic transaction management
* Pagination and sorting support
* Custom query methods

### Example

**EmployeeRepository.java**

```java
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository
        extends JpaRepository<Employee, Integer> {

}
```

**EmployeeService.java**

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public void addEmployee(Employee employee) {

        employeeRepository.save(employee);

    }
}
```

---

# Difference Table

| JPA                                    | Hibernate                    | Spring Data JPA                                |
| -------------------------------------- | ---------------------------- | ---------------------------------------------- |
| Specification                          | ORM Framework                | Spring Module                                  |
| Defines ORM standards                  | Implements JPA               | Simplifies JPA usage                           |
| No implementation                      | Complete implementation      | Uses JPA implementation (Hibernate by default) |
| Vendor-independent                     | Vendor-specific              | Spring abstraction over JPA                    |
| Uses annotations like `@Entity`, `@Id` | Uses Session, HQL, Cache     | Uses `JpaRepository`                           |
| Cannot access the database by itself   | Performs database operations | Provides ready-made CRUD methods               |

---

# Architecture

```text
Spring Boot
      │
      ▼
Spring Data JPA
      │
      ▼
JPA (Specification)
      │
      ▼
Hibernate (Implementation)
      │
      ▼
Database
```

---

# Advantages

### JPA

* Standard specification
* Portable across different ORM providers
* Database-independent

### Hibernate

* Powerful ORM framework
* Rich features like caching, HQL, lazy loading
* High performance

### Spring Data JPA

* Less code to write
* Easy CRUD operations
* Built-in pagination and sorting
* Easy integration with Spring Boot

---

# Conclusion

* **JPA** defines the standard rules for object-relational mapping but does not provide an implementation.
* **Hibernate** is an ORM framework that implements JPA and performs the actual database operations.
* **Spring Data JPA** is a Spring module that works on top of JPA implementations like Hibernate and simplifies data access by providing repositories such as `JpaRepository`.

---


