package chap4;

import java.io.*;
public class WriteCharacter
{
   public static void main(String args[]) throws IOException {
      String text = "�ѱ� ���� �����Դϴ�.";
      FileWriter fw = new FileWriter("D:\\Project\\Study\\2014_workspace\\JavaChat\\src\\chap4\\example4_1.txt"); 
       // ����Ʈ(�����ڵ�) ���ڵ� ����� ����Ͽ� �����Ѵ�.
      fw.write(text, 0, text.length()); // ���Ͽ� ���ڿ��� �����Ѵ�.
      fw.flush(); // ������ ������ ����.
      fw.close();
   }
}