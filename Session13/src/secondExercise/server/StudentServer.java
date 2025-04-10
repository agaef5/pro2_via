package secondExercise.server;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class  StudentServer
{
  public static void main(String[] args) throws IOException
  {
    final int PORT = 4425;
    System.out.println("Starting the server.");
    ServerSocket listenSocket = new ServerSocket(PORT);
    while(true){
      System.out.println("Waiting for the client");
      Socket socket = listenSocket.accept();
      Thread clientThread = new Thread(new ClientHandler(socket));
      clientThread.start();
    }

  }
}
