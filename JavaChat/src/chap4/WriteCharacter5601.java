package chap4;

import java.io.*;
public class WriteCharacter5601
{
   public static void main(String args[]) throws IOException {
      String text = "�ູ�� �ð� ��������.";
      FileOutputStream fos = new FileOutputStream("example4_6.txt");
      OutputStreamWriter osw = new OutputStreamWriter(fos, "KSC5601");
      osw.write(text, 0, text.length());
      osw.flush(); // ������ ������ �����Ѵ�.
      osw.close();
   }
}