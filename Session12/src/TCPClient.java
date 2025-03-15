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
//    create keyboard in

    Scanner input = new Scanner(System.in);
//    create client socket
    Socket clientSocket = new Socket(HOST, PORT);

//    create the streams
    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

    System.out.println("Write a line for the server: "  );
    String request = input.nextLine(); // read line from keyboard
    System.out.println("Client>> " + request);

//    send to server
    out.println(request);

//    read from server
    String reply = in.readLine();
    System.out.println("Server's reply>> " + reply);

//    close client's sockets
    in.close();
    out.close();
    clientSocket.close();
  }
}
