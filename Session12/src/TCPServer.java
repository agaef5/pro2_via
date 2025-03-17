import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TCPServer
{
  public static void main(String[] args) throws IOException
  {

final int port = 4025;
    System.out.println("Startting server...");
    ServerSocket listenSocket = new ServerSocket(port);
    while(true){
      System.out.println("Waiting for the client");
      Socket socket = listenSocket.accept();

// create IO streams
      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

      //communicate with client
      String request =  in.readLine();
      System.out.println("Client > " + request);

      //process request
      String reply = request.toUpperCase();
      System.out.println("Server>> " + reply);

//      send to client
      out.println(reply);
//      loop back to wait for another client connection
    }
//    close streams and socket
    
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
  }
}