
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Log
{

  private static Log instance;
  private static final Lock lock = new ReentrantLock();

  private Queue<LogLine> logQueue;
  private File logFile;
  private DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd  hh:mm:ss");

  private Log()
  {
    //All setup has been moved to separate method to make it easier to refactor to Singleton
    initialize();
  }

  private void initialize() {
    logQueue = new LinkedList<>();
    Date currentTime = Calendar.getInstance().getTime();
    DateFormat dateFormat = new SimpleDateFormat("hh-mm-ss");
    String filename ="log-" + dateFormat.format(currentTime) + ".txt";
    logFile = new File(filename);
    try {
      Thread.sleep(1500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public synchronized void add(String log)
  {
    if (log == null || log.equals("")) //Don't log empty lines
    {
      return;
    }
    // add to the queue
    LogLine logLine = new LogLine(log, dateFormat.format(Calendar.getInstance().getTime()));
    logQueue.add(logLine);
    addToFile(logLine.toString());          // add to the file
    System.out.println(logLine); // add to the console
  }

  public Queue<LogLine> getAll()
  {
    return logQueue;
  }

  //Method to write logEntries to a file
  private void addToFile(String log)
  {
    if (log == null)
    {
      return;
    }
    BufferedWriter out = null;
    try
    {
      out = new BufferedWriter(new FileWriter(logFile, true));
      out.write(log + "\n");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      try
      {
        out.close();
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
  }

  public static Log getInstance(){
    if(instance == null){
        synchronized (lock){
          if(instance == null){
            instance = new Log();
          }
        }
    }
    return instance;
  }
}
