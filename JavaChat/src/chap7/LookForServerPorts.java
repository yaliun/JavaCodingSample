package chap7;

import java.io.*;
import java.net.*;
public class LookForServerPorts
{
   public static void main(String args[]){
      ServerSocket theServer = null;
      for(int i=1024; i<65535; i++){
         try{
            theServer  = new ServerSocket(i); // ���� ���� ��ü�� �����Ѵ�.
            theServer.close();
         }catch(IOException e){
            System.out.println(i+" ��° ��Ʈ�� Ư�������� ����մϴ�.");
         }
      }
   }
}