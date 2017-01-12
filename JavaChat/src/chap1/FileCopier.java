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
         while((bytesRead = fin.read(buffer)) >= 0){ // 소스파일 -> 메모리
            fout.write(buffer, 0, bytesRead); // 메모리 -> 목적지파일
         }
      }catch(IOException e){
         System.err.println("스트림으로부터 데이터를 읽을 수 없습니다.");
      }finally{
         try{
            if(fin != null) fin.close();
            if(fout != null) fout.close();
         }catch(IOException e){}
      }
   }
}