import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DatabaseConnector
{

  private static DatabaseConnector instance;
  private static final Lock lock = new ReentrantLock();

  private DatabaseConnector()
  {
    //Initializing the database connection would happen here.
  }

  public static DatabaseConnector getInstance()
  {
    if(instance == null){
      synchronized (lock){
        if (instance == null){
          instance = new DatabaseConnector();
        }
      }
    }
    return instance;
  }

  public void connect()
  {
    System.out.println("Database connection established");
  }
}
