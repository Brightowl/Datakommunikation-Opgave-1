import java.io.*;
import java.net.*;

class TCPClient
{
  public static void main(String argv[]) throws Exception
  {
    // initialises strings
    String sentence;
    String modifiedSentence;
 
    // initialises input stream from user
    BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in));
  
    // opens the socket with local host at port 6789
    Socket clientSocket = new Socket("localhost", 6789);
   
    // initialises the IOstreams for the server 
    DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
    BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
  
    // reads input from user
    sentence = inFromUser.readLine();

    // writes the input from user to server
    outToServer.writeBytes(sentence + '\n');

    // reads input from server
    modifiedSentence = inFromServer.readLine();
    System.out.println("FROM SERVER: " + modifiedSentence);
    clientSocket.close();
  }
}
