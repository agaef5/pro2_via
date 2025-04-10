package secondExercise.client;

import com.google.gson.Gson;
import secondExercise.model.Message;
import secondExercise.model.Student;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class StudentClient
{
  public static void main(String[] args) throws IOException
  {
    final int PORT = 4425;
    final String HOST = "localhost";
    Gson gson = new Gson();

//    create socket and streams
    Socket socket = new Socket(HOST, PORT);
    Scanner fromUser = new Scanner(System.in);
    BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    PrintWriter outToServer = new PrintWriter(socket.getOutputStream(), true);

    System.out.println("enter ur name:");
    String name = fromUser.nextLine();

    System.out.println("Enter student number");
    int number = fromUser.nextInt();
    fromUser.close();

//    create Student.class object
    Student student = new Student(name, number);
    System.out.println("Object created: " + student.toString());

    String json = gson.toJson(student);
//    send created json to server
    outToServer.println(json);

//    read reply from server
    String serverReply =   inFromServer.readLine();
    System.out.println("Server >> " + serverReply);

    Message reply = gson.fromJson(serverReply, Message.class);
    System.out.println("Message from Srver >> " + reply);
    System.out.println("Student only >> " + reply.getStudent());
  }
}
