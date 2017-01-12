package chap4;

import java.io.*;
public class FileCopyEncoding
{
   public static void main(String args[]) throws IOException{
      int numberRead;
      char[] buffer = new char[16];
      if(args.length != 4){
         System.out.println("�Է����ڵ� �Է������̸� ������ڵ� ��������̸��� �����ϼ���!!");
         return;
      }
      FileInputStream fileIn = new FileInputStream(args[1]);
      FileOutputStream fileOut = new FileOutputStream(args[3]);
      InputStreamReader isr = new InputStreamReader(fileIn, args[0]);
      OutputStreamWriter osr = new OutputStreamWriter(fileOut, args[2]);
      while((numberRead = isr.read(buffer)) > -1)
         osr.write(buffer, 0, numberRead);
      osr.close();
      isr.close();
   }
}