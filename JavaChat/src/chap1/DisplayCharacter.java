package chap1;

import java.io.*;
public class DisplayCharacter
{
   public static void main(String args[]) throws java.io.IOException {
      for(int i=32; i<127; i++){
         System.out.write(i); // 32���� 127������ �������� �����ͷ� ����Ѵ�.
         if(i%8 == 7)
            System.out.write('\n'); // 8���� ���ڸ� ����ϰ� ���� �̵��Ѵ�.
         else
            System.out.write('\t'); // �ϳ��� ���ڸ� ����ϰ� ���� ����Ѵ�.
      }
      System.out.write('\n');
   }
}