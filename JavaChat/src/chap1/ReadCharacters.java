package chap1;

import java.io.*;
public class ReadCharacters
{
   public static void main(String args[]) throws java.io.IOException {
      int data;
      while((data = System.in.read()) >= 0) // Ű����κ��� �ѹ��ھ� �д´�.
    	  System.out.println((char)data);
   }
}