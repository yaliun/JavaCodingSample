package chap1;

import java.io.*;
public class DisplayString
{
   public static void main(String args[]) throws java.io.IOException {
      byte[] buffer;

      for(int i=0; i<args.length; i++){
         buffer = args[i].getBytes(); // ���ڿ��� ����Ʈ �����ͷ� ��ȯ�Ѵ�. 
         System.out.write(buffer);
         System.out.write('\n'); // ���� ���ڿ��� ���ο� �ٿ� ����Ѵ�.
      }
   }
}