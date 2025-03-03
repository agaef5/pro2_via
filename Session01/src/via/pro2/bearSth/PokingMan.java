package via.pro2.bearSth;

public class PokingMan implements Runnable
{
  private Thread bear;

  public PokingMan (Thread bear){this.bear = bear;};

  public void run(){
    try{
      Thread.sleep(2500);
      bear.interrupt();
    }catch (InterruptedException ie){
      ie.printStackTrace();
    }
  };
}
