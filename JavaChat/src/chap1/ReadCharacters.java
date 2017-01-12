package chap1;

import java.io.*;
public class ReadCharacters
{
   public static void main(String args[]) throws java.io.IOException {
      int data;
      while((data = System.in.read()) >= 0) // 키보드로부터 한문자씩 읽는다.
    	  System.out.println((char)data);
   }
}