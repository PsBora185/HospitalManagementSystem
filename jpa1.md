# Spring Data JPA Complete Guide

## Table of Contents

- [Introduction](#introduction)
- [Spring Data JPA Layers](#spring-data-jpa-layers)
- [Setting Up Your Project](#setting-up-your-project)
- [Entity and Table Mapping](#entity-and-table-mapping)
- [Repository Layer](#repository-layer)
- [EntityManager & PersistenceContext](#entitymanager--persistencecontext)
- [Dirty Checking & Transactions](#dirty-checking--transactions)
- [Table Constraints & Indexes](#table-constraints--indexes)
- [Database Initialization](#database-initialization)
- [Enumerated Types](#enumerated-types)
- [Real-World Practices](#real-world-practices)
- [Common Interview Topics](#common-interview-topics)
- [Reference Project Flow](#reference-project-flow)
- [FAQ & Revision Points](#faq--revision-points)

---

## Introduction

Spring Data JPA is a library for simplifying database operations in Java Spring Boot applications. It lets developers
easily map Java objects to database tables using Object-Relational Mapping (ORM)[attached_file:1].

---

## Spring Data JPA Layers

| Layer                         | Purpose                                         |
|-------------------------------|-------------------------------------------------|
| JDBC                          | Connects Java app to database; runs SQL queries |
| JPA (Jakarta Persistence API) | Specification for ORM                           |
| Hibernate                     | Implements JPA; handles query optimization      |
| Spring Data JPA               | Abstraction; reduces boilerplate code           |

Spring Data JPA sits above Hibernate and JPA and removes most boilerplate code for database access[attached_file:1].

---

## Setting Up Your Project

- Use Spring Initializer to create a Maven/Gradle project.
- Add dependencies: Spring Web, Spring Data JPA, Lombok, and your DB driver.
- Set database config in `application.properties`:
- Understand the options for `ddl-auto`: `create`, `create-drop`, `update`, `validate`, `none`[attached_file:1].

---

## Entity and Table Mapping

- Define a Java class for each table.
- Use `@Entity` for mapping a class to a DB table and `@Id` for primary key.
- Add other annotations:
- `@Table` : set name or add constraints, `@Column`, `@GeneratedValue`, `@Enumerated`
- Example:
- Choose generation type: TABLE, SEQUENCE, IDENTITY, AUTO, UUID[attached_file:1].

---

## Repository Layer

- Create an interface extending `JpaRepository<Entity, IdType>`.
- Get built-in CRUD: `save()`, `findAll()`, `findById()`, `delete()`
- Add custom queries:

---

## EntityManager & PersistenceContext

- EntityManager manages entity lifecycles and DB operations.
- PersistenceContext tracks entity states, enables dirty checking[attached_file:1].

---

## Dirty Checking & Transactions

- Changes to entities are tracked inside a transaction and saved on commit (`@Transactional`).
- Dirty checking automates update detection[attached_file:1].

---

## Table Constraints & Indexes

- Use `@Column(unique = true)` for uniqueness.
- Index fields for performance.
- Handle relationships: `OneToOne`, `OneToMany`, `ManyToOne`[attached_file:1].

---

## Database Initialization

- Seed the database using `data.sql` or code (CommandLineRunner).
- Useful for initial test/demo data[attached_file:1].

---

## Enumerated Types

- For `enum` fields, use `@Enumerated(EnumType.STRING)` for readable DB representation.

---

## Real-World Practices

- Use `update` for development; in production, prefer `validate` or `none`.
- Show SQL for debugging, not in production.
- Ensure proper transaction and exception management[attached_file:1].

---

## Common Interview Topics

- Mapping relationships (1-1, 1-N, N-1, N-N)
- Indexing/performance
- N+1 query problem
- Data seeding
- Repository/custom queries[attached_file:1]

---

## Reference Project Flow

1. Set up project and dependencies
2. Configure database
3. Create entities (`@Entity`)
4. Create repository interfaces
5. Add services/controllers
6. Use DTOs for I/O
7. Handle transactions/exceptions[attached_file:1]

---

## FAQ & Revision Points

- **Why use Hibernate?** Default JPA provider; optimizes queries and mapping.
- **What is ddl-auto for?** Controls schema creation/update.
- **How do entities map to tables?** Using annotations and EntityManager.
- **What does dirty checking do?** Auto-detects unsaved changes.
- **How to run custom queries?** Method naming or `@Query` annotation.
- **What is data seeding?** Adding initial data for dev/test.
- **How to secure production database?** Use pooling, user permissions, set `ddl-auto` to `none` or
  `validate`[attached_file:1].

---

**Add in spring boot project , application.properties**

```
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
```

---

**ddl-auto**

- create : reset db , when starting application
- create-drop : delete db data when apllication close
- update : keep adding data and store in db
- validate : verifies if data is correct , object is for table , if problem show error
- none : no changes in db

---

* Use toString to get data properly , toString.Exclude

* JpaRepository implements other interfaces, Implementations are in SimpleJpaRepository , using EntityManager

---

# Hibernate Entity Lifecycle - Basic Notes

Hibernate entities go through different states during their life in an application. There are 4 main states:

---

### 1. Transient State
- Object is newly created with `new`.
- Not associated with Hibernate session or database.
- Not saved or tracked.
- Example: `Employee e = new Employee();` (e is transient)

---

### 2. Persistent State
- Object is connected to Hibernate session.
- Represents a row in the database.
- Changes are tracked and saved automatically.
- Transition happens by saving or loading the object.
- Example: `session.save(e);` (e is now persistent)

---

### 3. Detached State
- Object was persistent but session is closed or cleared.
- No longer tracked; changes won’t be saved automatically.
- Can be reattached with `merge()` or `update()`.
- Example: `session.close();` (e becomes detached)

---

### 4. Removed State
- Object is scheduled for deletion from database.
- Happens after calling `session.delete(e);`.
- Object will be deleted upon commit/flush.
- Changes after removal have no effect.

---

### Summary Table

| State      | Description                          | Session Connected | Database Row | Changes Saved Automatically |
|------------|----------------------------------|--------------------|--------------|-----------------------------|
| Transient  | New object, not in session       | No                 | No           | No                          |
| Persistent | Managed by session, synced       | Yes                | Yes          | Yes                         |
| Detached   | Previously persistent, no session| No                 | Yes          | No (unless merged)           |
| Removed    | Scheduled for deletion           | Yes (until commit) | Yes          | No                          |

---
# @Transactional - Quick Notes

---

### What is @Transactional?
- Annotation to manage database transactions automatically.
- Ensures all operations inside a method succeed or fail together (atomicity).
- Spring handles transaction start, commit, and rollback for you.

---

### When to Use @Transactional?
- Use on service layer methods performing multiple database operations.
- Ideal when you want consistency across multiple steps (like saving several entities).
- Use when you want easy rollback on exceptions without manual code.

---

### Key Points
- Spring auto-starts a transaction when entering the method.
- If method completes normally, transaction commits.
- If method throws a runtime exception, transaction rolls back.
- Can be applied to class (all methods) or individual methods.
- Commonly used in Spring Boot apps with JPA/Hibernate.

---

### Example
```java
@Transactional
public void transferMoney(Account from, Account to, BigDecimal amount) {
debit(from, amount);
credit(to, amount);
}
```

- If debit or credit fails, whole transaction rolls back.

---



