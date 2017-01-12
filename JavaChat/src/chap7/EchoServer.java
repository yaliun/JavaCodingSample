package chap7;

import java.io.*;
import java.net.*;
public class EchoServer
{
   public static void main(String args[]){
      ServerSocket theServer;
      Socket theSocket = null;
      InputStream is;
      BufferedReader reader;
      OutputStream os;
      BufferedWriter writer;
      String theLine;
      try{
         theServer = new ServerSocket(7);
 // 7�� ��Ʈ���� Ŭ���̾�Ʈ�� ���� ��û�� ��ٸ��� �������� ��ü�� �����Ѵ�.
         theSocket = theServer.accept(); // Ŭ���̾�Ʈ�� ���ӿ�û��
 // ��ٸ��� Ŭ���̾�Ʈ�� ���ϰ� ����� ���� ���� ����(theSocket)�� �����Ѵ�.
         is = theSocket.getInputStream();
 // Ŭ���̾�Ʈ�� ������ �����͸� ���� InputStream ��ü�� �����Ѵ�.
         reader = new BufferedReader(new InputStreamReader(is));
 // Ŭ���̾�Ʈ�� ������ �����͸� ���� BufferedReader ��ü�� �����Ѵ�.
         os = theSocket.getOutputStream();
 // Ŭ���̾�Ʈ�� �����͸� ������ OutputStream ��ü�� �����Ѵ�.
         writer = new BufferedWriter(new OutputStreamWriter(os));
 // Ŭ���̾�Ʈ�� �����͸� �����ϴ� BufferedWriter ��ü�� �����Ѵ�.
         while((theLine = reader.readLine()) != null ){ // Ŭ���̾�Ʈ�� �����͸� ����
            System.out.println(theLine); // ���� �����͸� ȭ�鿡 ����Ѵ�.
            writer.write(theLine+'\r'+'\n');  // Ŭ���̾�Ʈ�� �����͸� ������ 
            writer.flush(); // Ŭ���̾�Ʈ�� �����͸� ������ 
         }
      }catch(UnknownHostException e){
         System.err.println(e);
      }catch(IOException e){
         System.err.println(e);
      }finally{
         if(theSocket != null){
            try{
               theSocket.close();
            }catch(IOException e){
               System.out.println(e);
            }
         }
      }
   }
}