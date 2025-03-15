package exercise.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Locale;

public class TCPServer
{
  public static void main(String[] args) throws IOException
  {
    final int PORT = 4025;
    ArrayList<String> log = new ArrayList<>();
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

      request = input.readLine();
      while (!request.equals("exit")){
        log.add(LocalDateTime.now() + " " + client + ": " + request);
      }
      log.add(LocalDateTime.now() + " " + client + " is disconnected");
      output.println("disconnected");
      clientSocket.close();
    }
  }
}
