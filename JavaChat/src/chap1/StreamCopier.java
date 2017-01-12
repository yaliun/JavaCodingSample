package chap1;

import java.io.*;
public class StreamCopier
{
   public static void main(String args[]){
      try{
         copy(System.in, System.out); 
  // System.in�� Ű����, System.out�� ����͸� �ǹ���
      }catch(IOException e){
         System.err.println("��Ʈ�����κ��� �����͸� ���� �� �����ϴ�.");
      }
   }
   public static void copy(InputStream in, OutputStream out) throws IOException{
      int bytesRead;
      byte[] buffer = new byte[256];
      synchronized(in){
         synchronized(out){
            while((bytesRead = in.read(buffer)) >= 0){
               out.write(buffer, 0, bytesRead);
            }
         }
      }
   }
}
