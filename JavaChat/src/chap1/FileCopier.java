package chap1;

import java.io.*;
public class FileCopier
{
   public static void main(String args[]){
      int bytesRead;
      byte[] buffer = new byte[256];
      FileInputStream fin = null;
      FileOutputStream fout = null;
      try{
         fin = new FileInputStream("example1_9.txt");
         fout = new FileOutputStream("example1_13.txt");
         while((bytesRead = fin.read(buffer)) >= 0){ // �ҽ����� -> �޸�
            fout.write(buffer, 0, bytesRead); // �޸� -> ����������
         }
      }catch(IOException e){
         System.err.println("��Ʈ�����κ��� �����͸� ���� �� �����ϴ�.");
      }finally{
         try{
            if(fin != null) fin.close();
            if(fout != null) fout.close();
         }catch(IOException e){}
      }
   }
}