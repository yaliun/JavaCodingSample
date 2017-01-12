package chap4;

import java.io.*;
public class BufferedFileCopy
{
   public static void main(String args[]){
      String data;   
      try{
         FileInputStream fin = new FileInputStream("example4_9.txt");
         InputStreamReader isr = new InputStreamReader(fin, "KSC5601");
         BufferedReader br = new BufferedReader(isr);
         FileOutputStream fout = new FileOutputStream("example4_10.txt");
         OutputStreamWriter osw = new OutputStreamWriter(fout, "KSC5601");
         BufferedWriter bw = new BufferedWriter(osw);
         while((data=br.readLine()) != null){
            bw.write(data+"\r\n"); // readLine()은 라인분리자를 포함하지 않는다.
            bw.flush();
         }
      }catch(IOException e){
         System.out.println(e);
      }
   }
}