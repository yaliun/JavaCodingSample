package chap1;

import java.io.*;
public class WriteToFile
{
   static FileOutputStream fout;
   public static void main(String args[]){
      try{
         int bytesRead;
         byte[] buffer = new byte[256];
         fout = new FileOutputStream("D:\\Project\\Study\\2014_workspace\\JavaChat\\src\\chap1\\example1_9.txt");
         while((bytesRead = System.in.read(buffer)) >= 0){ 
            fout.write(buffer, 0, bytesRead); 
       // Ű����κ��� ������ �Է� -> �޸� ���� -> ���Ϸ� ����
          }
      }catch(IOException e){
         System.err.println("��Ʈ�����κ��� �����͸� ���� �� �����ϴ�.");
      }finally{
         try{
            if(fout!=null) fout.close();
         }catch(IOException e){}
      }
   }
}
