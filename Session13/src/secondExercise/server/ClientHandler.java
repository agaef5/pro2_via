package secondExercise.server;

import com.google.gson.Gson;
import secondExercise.model.Message;
import secondExercise.model.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable
{
  private BufferedReader in;
  private PrintWriter out;
  private Scanner scanner;
  private Socket socket;

  public ClientHandler(Socket socket) throws IOException
  {
    this.socket = socket;
    scanner = new Scanner(System.in);
    in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
    out = new PrintWriter(this.socket.getOutputStream(), true);

  }

  @Override public void run()
  {
      Gson gson = new Gson();
      try{
//        read line from the client
        String clientLIne = in.readLine();
        System.out.println("Client >> " + clientLIne);
//        convert from JSON
        Student student = gson.fromJson(clientLIne, Student.class);
//        create server reply
        Message reply = new Message(student, "Welcome");
//        convert to JSON
        String replyString = gson.toJson(reply);
//        send to client
        System.out.println("Server >> " + replyString);
        out.println(replyString);

      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
  }
}
