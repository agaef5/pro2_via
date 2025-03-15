package exercise.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer
{
  public static void main(String[] args) throws IOException
  {
    final int PORT = 4025;
    System.out.println("Startin server>>");

    ServerSocket listenSocket = new ServerSocket(PORT);

    while (true){
      System.out.println("Waiting for the client");
      Socket clientSocket = listenSocket.accept();
      String client = clientSocket.getInetAddress().getHostAddress();

      BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

      String request = input.readLine();
      System.out.println("Client:" +client +">>" + request);

      if(!request.equals("connect")){
        System.out.println("Server>> Disconnected");
        output.println("disconnected");
        clientSocket.close();
      }

      output.println("Provide username:");
      String username = input.readLine();
      output.println("Hello, " + username + ". Provide password:");
      String password = input.readLine();

      if(!password.equals("admin")){
        System.out.println("Server>> Disconnected");
        output.println("disconnected");
        clientSocket.close();
      }

      System.out.println("Server>> Login approved");
      output.println("Loginu approved");
    }

  }
}
