package chap7;

import java.io.*;
import java.net.*;
import java.util.Date;
public class DayTimeServer
{
   public final static int daytimeport=13;
   public static void main(String args[]){
      ServerSocket theServer;
      Socket theSocket = null;
      BufferedWriter writer;
      try{
         theServer = new ServerSocket(daytimeport); 
 // 13�� ��Ʈ���� Ŭ���̾�Ʈ�� ���� ��û�� ��ٸ��� �������� ��ü�� �����Ѵ�.
         while(true){
            try{           
               theSocket = theServer.accept();  // Ŭ���̾�Ʈ�� ���ӿ�û��
 // ��ٸ��� Ŭ���̾�Ʈ�� ���ϰ� ����� ���� ���� ����(theSocket)�� �����Ѵ�.
               OutputStream os = theSocket.getOutputStream();
 // Ŭ���̾�Ʈ�� �����͸� ������ OutputStream ��ü�� �����Ѵ�.
               writer = new BufferedWriter(new OutputStreamWriter(os));
 // Ŭ���̾�Ʈ�� �����͸� �����ϴ� BufferedWriter ��ü�� �����Ѵ�.
               Date now = new Date(); // ��¥�� ���Ѵ�.                
               writer.write(now.toString()+"\r\n"); // ��¥�� �����Ѵ�.
               writer.flush();
               theSocket.close();
            }catch(IOException e){
               System.out.println(e);
            }finally{
               try{
                  if(theSocket != null) theSocket.close();
               }catch(IOException e){
                  System.out.println(e);
               }
            }
         }
      }catch(IOException e){
         System.out.println(e);
      }
   }
}