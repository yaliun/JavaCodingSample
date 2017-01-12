package chap7;

import java.io.*;
import java.net.*;
public class CreateServerSocket
{
   public static void main(String args[]){
      ServerSocket theServer = null;
      int port;
      if(args.length == 1){
         port = Integer.parseInt(args[0]); // ���ڹ��ڸ� ������ ��ȯ�Ѵ�.
      }else{
         System.out.println("��ɾ� ���ο��� ������ ��Ʈ��ȣ�� �Է��ϼ���!");
         return;
      }
      try{
         theServer  = new ServerSocket(port); // ���� ���� ��ü�� �����Ѵ�.
         System.out.println(port+"�� ���ε�� ���� ���� ��ü�� �����Ͽ����ϴ�.");

         // �� �κп��� Ŭ���̾�Ʈ�� ������ ��ٸ���, ����� �����Ѵ�.

         theServer.close();
      }catch(IOException e){
         System.out.println(e);
      }
   }
}