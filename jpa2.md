# JPQL - Query Methods , Custom Methods

## Query Methods
- create method like that so spring data jpa can identify and generate query 
- return type - list or optional : return all , single object or property : first one it finds
- method name - using column names , or filters , or range 

---

## JPQL

- Write custom query for a method to work with db , hibernates converts it acc to db used
- @Query("select e from Entity e where ...")
- (@Param("value") Long id) - to use parameter value in query as - :value 
- @Modifying above the query which is updating , @Transactional also required


- "select new packagePath.Class(parameter) from ..." - returns data as object of that class , we have to create the class acc to method. 
- "select e.property, count(e) from Entity e group by e.property" - returns count of rows with same property value


- Pagination using Pageable from springframework.data.domain , return type Page