package chap4;

import java.io.*;
public class BufferedWriteCharacter
{
   public static void main(String args[]) throws IOException {
      String text = "BufferedWriter Ŭ������ �̿��ؼ� ������ �����Դϴ�.";
      FileWriter fw = new FileWriter("example4_4.txt");
      BufferedWriter bw = new BufferedWriter(fw); // bw�� fw�� ����ȴ�. 
       // ����Ʈ(�����ڵ�) ���ڵ� ����� ����Ͽ� �����Ѵ�.
      bw.write(text, 0, text.length()); // ���Ͽ� ���ڿ��� �����Ѵ�.
       // bw.write(text); �� �̿��ص� ��.
      bw.flush(); // ������ ������ ����.
      bw.close();
   }
}