Feature: DataBase Test

  Scenario Outline: We should be able to connect to the database and get the data
    When connection is established using <url> <driver> <userName> and <passKey>
    And I run a select query to get <columnName> containing <queryColumnName> the data from the <tableName> where <columnName> equals <queryColumn>
    Then I should see the result as <columnValue>

    #DataBase Based Query Testing
    Examples: |
    |                url                            | driver                  | username   | password | columnName     | queryColumnName | tableName   | columnValue | queryColumn |
    | "jdbc:mysql//localhost:3306/revaturejwadb"    | "com.mysql.jdbc.Driver" | "root"     | "root"   | "product_Name" | "product_Id"    | "products"  | "Monitor"   |           3 |
    | "jdbc:h2:file://localhost:8080/revaturejwadb" | "com.mysql.jdbc.Driver" | "root"     | "root"   | "Ename"        | "EmpId"         | "employee"  | "Mohan"     |          11 |
    | "jdbc:postgresql://localhost:5432/postgres"   | "org.postgresql.Driver" | "postgres" | "root"   | "first_name"   | "id"            | "student"   | "Steven"    |         100 |

## QUERY = select product_Name from products where product_Id = 3
## result columnValue - Monitor