package chap1;

import java.io.*;
public class ReadFromFile
{
   public static void main(String args[]){
      int bytesRead;
      byte[] buffer = new byte[256];
      FileInputStream fin = null;
      try{
         fin = new FileInputStream("D:\\Project\\Study\\2014_workspace\\JavaChat\\src\\chap1\\example1_9.txt");
         while((bytesRead = fin.read(buffer)) >= 0){ // 파일 -> 메모리
            System.out.write(buffer, 0, bytesRead); // 메모리 -> 화면출력
       // 파일의 데이터를 읽음 -> 메모리 저장 -> 화면에 출력 순서임
         }
      }catch(IOException e){
         System.err.println("스트림으로부터 데이터를 읽을 수 없습니다.");
      }finally{
         try{
            if(fin!=null) fin.close();
         }catch(IOException e){}
      }
   }
}