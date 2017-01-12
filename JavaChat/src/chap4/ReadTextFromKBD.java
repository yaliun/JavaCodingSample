package chap4;

import java.io.*;
public class ReadTextFromKBD
{
   public static void main(String args[]) throws IOException {
      String text;
      InputStreamReader isr;
      BufferedReader br;
      FileOutputStream fos;
      OutputStreamWriter osw;
      BufferedWriter bw;
      isr = new InputStreamReader(System.in);
      br = new BufferedReader(isr);
      fos = new FileOutputStream("example4_9.txt");
      osw = new OutputStreamWriter(fos, "KSC5601");
      bw = new BufferedWriter(osw);
      while((text=br.readLine()) != null){
         System.out.println(text); // 화면에 출력한다.
         bw.write(text+"\r\n"); // 파일에 저장한다.
      }
      bw.flush(); // 버퍼의 내용을 전송한다.
      bw.close();
   }
}