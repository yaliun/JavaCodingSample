package chap1;

import java.io.*;
public class DisplayCharacterBlock
{
   public static void main(String args[]) throws java.io.IOException{
      byte[] b = new byte[(127-31)*2]; // ����Ʈ �������� �Ҵ��Ѵ�.
      int index=0;
      for(int i=32; i<127; i++){ 
      // �迭�� 32���� 126���� ����Ʈ ������ �� '\t' �����͸� �����Ѵ�.
         b[index++] = (byte) i; // ������ ����Ʈ(0���� 255)������ ĳ��Ʈ�Ѵ�.
         if(i%8 ==7)
            b[index++] = (byte)'\n'; // 8���� ������ �������� newline�� �����Ѵ�.
         else
            b[index++] = (byte) '\t';
      }
      b[index++] = (byte) '\n';
      System.out.write(b); // b �迭�� ����� ��� �����͵��� �ѹ��� ����Ѵ�.
   }
}