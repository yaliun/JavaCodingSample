package chap1;

import java.io.*;
public class StreamCopier
{
   public static void main(String args[]){
      try{
         copy(System.in, System.out); 
  // System.in은 키보드, System.out은 모니터를 의미함
      }catch(IOException e){
         System.err.println("스트림으로부터 데이터를 읽을 수 없습니다.");
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
