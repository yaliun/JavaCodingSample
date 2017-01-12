package chap2;

import java.io.*;
public class BufferedStreamCopier
{
   public static void main(String args[]){
      try{
         copy(System.in, System.out);
      }catch(IOException e){System.err.println(e);}
   }
   public static void copy(InputStream in, OutputStream out) throws IOException{
      synchronized(in){
         synchronized(out){
            BufferedInputStream bin = new BufferedInputStream(in);
            BufferedOutputStream bout = new BufferedOutputStream(out);
            while(true){
               int data = bin.read(); // 버퍼에 있는 데이터를 읽는다.
               if(data==-1) break; // CTRL-Z 입력은 -1를 반환한다.
               bout.write(data); // 버퍼에 데이터를 전송한다.
            }
            bout.flush(); // 버퍼에 있는 모든 데이터를 스트림으로 전송한다.
         }
      }
   }
}