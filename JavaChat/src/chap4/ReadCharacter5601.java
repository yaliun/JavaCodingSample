package chap4;

import java.io.*;
public class ReadCharacter5601
{
   public static void main(String args[]) throws IOException {
      int bytesRead;
      char[] buffer = new char[128];
      FileInputStream fis = new FileInputStream("example4_6.txt");
      InputStreamReader isr = new InputStreamReader(fis, "KSC5601");
   // ����� ������ ���ڵ� ��İ� ��ġ�ؾ� �Ѵ�.
      while((bytesRead = isr.read(buffer, 0, buffer.length)) != -1)
         System.out.println(buffer);
   }
}
