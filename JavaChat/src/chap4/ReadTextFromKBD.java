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
         System.out.println(text); // ȭ�鿡 ����Ѵ�.
         bw.write(text+"\r\n"); // ���Ͽ� �����Ѵ�.
      }
      bw.flush(); // ������ ������ �����Ѵ�.
      bw.close();
   }
}