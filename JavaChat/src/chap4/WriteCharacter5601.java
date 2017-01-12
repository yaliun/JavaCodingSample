package chap4;

import java.io.*;
public class WriteCharacter5601
{
   public static void main(String args[]) throws IOException {
      String text = "행복한 시간 보내세요.";
      FileOutputStream fos = new FileOutputStream("example4_6.txt");
      OutputStreamWriter osw = new OutputStreamWriter(fos, "KSC5601");
      osw.write(text, 0, text.length());
      osw.flush(); // 버퍼의 내용을 전송한다.
      osw.close();
   }
}