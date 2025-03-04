import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DatabaseConnector
{

  private static Map<String, DatabaseConnector> instances = new HashMap<>();
  private static final Lock lock = new ReentrantLock();

  private DatabaseConnector()
  {
  }

  public static DatabaseConnector getInstance(String databaseName)
  {
    if(!instances.containsKey(databaseName)){
      synchronized (lock){
        if (!instances.containsKey(databaseName)){
          instances.put(databaseName, new DatabaseConnector());
        }
      }
    }
    return instances.get(databaseName);
  }

  public void connect()
  {
    System.out.println("Database connection established");
  }
}
