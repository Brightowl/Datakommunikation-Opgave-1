import java.io.*;
import java.net.*;

class TCPServer
{
   public static void main(String argv[]) throws Exception
      {
	 // declares input and output strings for the serever
         String clientSentence;
         String capitalizedSentence;

	 // initialises the server, at port 6789
         ServerSocket welcomeSocket = new ServerSocket(6789);

         while(true)
         {
            // opens the socket with the client 
            Socket connectionSocket = welcomeSocket.accept(); 

            // opens a buffer with the socket, to read the clients input
            BufferedReader inFromClient =
               new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            
            // opens a buffer with the socket, to print from server to client
	    DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            
            // reads input from the client and save it as clientSentence
	    clientSentence = inFromClient.readLine();
            System.out.println("Received: " + clientSentence); 
	   
	    // writes the input back to the client char for char 
	    for (int i = 0; i < clientSentence.length(); i++)
	    {
	      char c = clientSentence.charAt(i);
	      outToClient.writeByte(c);
	    }


	    // writes the input back to the client ten times	    
	    for(int i = 0; i < 10; i++)
	    {
	      outToClient.writeBytes(clientSentence);
	    }
	 
	    outToClient.writeByte('\n');
	 }
      }
}
