package firstExercise.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client
{
  final static int PORT = 4425;
  final static String HOST = "10.154.192.54";

  public static void main(String[] args) throws IOException
  {
    System.out.println("Starting client");
    final InetAddress host = InetAddress.getLocalHost();

//    create socket, scanner input output
    Scanner scanner = new Scanner(System.in);
    Socket clientSocket = new Socket(HOST, PORT);
    BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

    String request = scanner.nextLine();
    System.out.println("Client>> " + request);
    output.println(request);

    String serverReply = input.readLine();

    while (!serverReply.equals("disconnected")){
      System.out.println("Server>>" + serverReply);
      request = scanner.nextLine();
      System.out.println("Client >>" + request);
      output.println(request);
      serverReply = input.readLine();
    }
  }
}
