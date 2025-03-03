package via.pro2.runnable;

import javafx.scene.control.skin.TableHeaderRow;

public class LambdaRunnable
{
  public static void main(String[] args){
    Runnable myLambdaRunnable = () -> System.out.println("This is from Lambda Runnable");

    Thread thread = new Thread(myLambdaRunnable);
    thread.start();
  }
}
