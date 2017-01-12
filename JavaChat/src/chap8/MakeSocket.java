package chap8;

import java.io.*;
import java.net.*;
public class MakeSocket
{
   public static void main(String args[]){
      Socket theSocket;
      String host = "www.ssc.ac.kr";
      int port = 7;
      try{
         System.out.println(host+" ȣ��Ʈ�� ��Ʈ��ȣ "+port+"�� �����ϰ� �ֽ��ϴ�.");
         theSocket = new Socket(host, port);
         System.out.println("������ �Ϸ�Ǿ����ϴ�.");

         // �� �κп��� ������ ����� ������ �� �ִ�.

         theSocket.close(); // ������ �ݴ´�.
      }catch(UnknownHostException e){
         System.err.println("������ ȣ��Ʈ�� �����ϴ�.");
      }catch(IOException e){
         System.err.println("������ ������ �ʴ´�.");
      }
   }
}