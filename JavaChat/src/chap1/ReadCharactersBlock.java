package chap1;

import java.awt.font.NumericShaper;
import java.io.*;
public class ReadCharactersBlock
{
   public static void main(String args[]) throws java.io.IOException {
      byte[] buffer = new byte[10];
      int numberRead; // �о �迭�� ������ ����Ʈ �����ͼ��� �����Ѵ�
      
      while((numberRead = System.in.read(buffer)) >= 0)
      {
  // Ű���忡�� enterŰ ���� �Է��� ���ڵ��� �о buffer �迭�� �����ϰ�
 // ���� ���� ������ ���� ��ȯ�Ͽ� numberRead ���������� �����Ѵ�.
    	  System.out.write(buffer, 0, numberRead);
    	  System.out.println("");
      }

 // buffer�� �ִ� �����͸� ó������ numberRead ���� ��ŭ ȭ�鿡 ����Ѵ�.
   }
}