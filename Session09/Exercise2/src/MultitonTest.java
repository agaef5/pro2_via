public class MultitonTest
{
  public static void main(String[] args)
  {
    DatabaseConnector mysqlConnector = DatabaseConnector.getInstance("MySQL");
    DatabaseConnector postgresConnector = DatabaseConnector.getInstance("PostgreSQL");
    DatabaseConnector anotherMysqlConnector = DatabaseConnector.getInstance("MySQL");

    System.out.println(mysqlConnector == postgresConnector); // Should print false
    System.out.println(mysqlConnector == anotherMysqlConnector); // Should print true
  }
}