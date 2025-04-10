package firstExercise.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPMultiThreadedServer
{
  final static int PORT = 4425;

  public static void main(String[] args) throws IOException
  {
    System.out.println("Starting server");

//    create listen socket
    ServerSocket listenSocket = new ServerSocket(PORT);
    while(true){
      System.out.println("Waiting for a client...");
      Socket socket = listenSocket.accept();

//    start a new thread with new client
      ClientHandler client = new ClientHandler(socket);
      Thread thread = new Thread(client);
      thread.start();
    }
  }
}
