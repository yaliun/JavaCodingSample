package chap8;

import java.io.*;
import java.net.*;
public class LookForPorts
{
   public static void main(String args[]){
      Socket theSocket;
      String host="localhost"; // ȣ��Ʈ�� �������� ������ ���
      if(args.length == 1){
         host=args[0]; // ��ɾ� ���ο��� �Էµ� ���� ȣ��Ʈ
      }
      for(int i=1; i<1024; i++){
         try{
            theSocket  = new Socket(InetAddress.getByName(host), i);
            System.out.println(host+"�� "+i+"�� ��Ʈ�� Ư���� ������ ����մϴ�.");
         }catch(UnknownHostException e){
            System.err.println(e);
            break;
         }catch(IOException e){
         }
      }
   }
}