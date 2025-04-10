package firstExercise.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable
{
  private BufferedReader input;
  private PrintWriter output;
  Socket socket;

  public ClientHandler(Socket socket) throws IOException
  {
    this.socket = socket;

//    create input stream
    input = new BufferedReader(new InputStreamReader(
        this.socket.getInputStream()));

//    create output stream
    output = new PrintWriter(this.socket.getOutputStream(), true);
  }

  @Override public void run()
  {
    try{
      String request = input.readLine();
      System.out.println("Client >> " + request + "\nOn thread " +
           Thread.currentThread().getName() );

      String reply = request.toUpperCase();
      System.out.println("Server >> " + reply);
      output.println(reply);
    }catch (IOException e){
      e.printStackTrace();
    }
  }
}
