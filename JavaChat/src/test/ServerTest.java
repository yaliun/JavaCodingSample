package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ServerSocket theServer = null;
		Socket connection = null;

		BufferedReader br;
		BufferedReader input;
		BufferedWriter output;
		
		String message = "";
		String temp = "";

		try
		{
			System.out.println("1");
			theServer = new ServerSocket(8989,1);
			
			while(true)
			{
				System.out.println("2");
				connection = theServer.accept();

				System.out.println(connection);
				
				System.out.println("3");
				
				ChatThread chatT = new ChatThread(connection);
				chatT.start();
				
/*				
				br = new BufferedReader(new InputStreamReader(System.in));
				
				if ((message = br.readLine()) != null)
				{
					output = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
					
					output.write(message +"\n");
					output.flush();
				}
				
				System.out.println("4");

				input = new BufferedReader(new InputStreamReader(connection.getInputStream()));

				if ((temp = input.readLine()) != null)
				{
					System.out.println("클라이언트 : " + temp);					
				}

				System.out.println("5");
*/
			}
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		finally
		{
			try
			{
				if (connection != null) connection.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
