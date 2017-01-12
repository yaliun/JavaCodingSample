package test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ChatThread extends Thread
{

	Socket connection = null;
	BufferedWriter output;
	
	public ChatThread(Socket connection) throws IOException
	{
		this.connection = connection;
		output = new BufferedWriter(new OutputStreamWriter(this.connection.getOutputStream()));
	}
	
	@Override
	public void run()
	{
		try
		{
			output.write("환영합니다. Client\n");
			output.flush();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		finally
		{
			try
			{
				System.out.println("Thread End");
				if(connection != null) connection.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
