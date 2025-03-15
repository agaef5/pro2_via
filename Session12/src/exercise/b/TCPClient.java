package exercise.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPClient
{

public static void main(String[] args) throws UnknownHostException, IOException
{
  final int PORT = 4025;
  final String HOST = "localhost";

  Scanner input = new Scanner(System.in);
  Socket clientSocket = new Socket(HOST, PORT);

  BufferedReader in = new BufferedReader(
      new InputStreamReader(clientSocket.getInputStream()));
  PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

  String request = input.nextLine();
  System.out.println("Client>> " + request);
  out.println(request);

  String serverReply = in.readLine();

  while (!serverReply.equals("disconnected")){
    System.out.println("Server>>" + serverReply);
    request = input.nextLine();
    System.out.println("Client >>" + request);
    out.println(request);
    serverReply = in.readLine();
  }

  System.out.println("Server reply>>" + serverReply);
  in.close();
  out.close();
  clientSocket.close();
}

}
