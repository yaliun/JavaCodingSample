package chap4;

import java.io.*;
public class ReadCharacter
{
   public static void main(String args[]) throws IOException {
      int numberRead;
      String data;
      char[] buffer = new char[80];    
      FileReader fr = new FileReader("D:\\Project\\Study\\2014_workspace\\JavaChat\\src\\chap4\\example4_1.txt");
      while((numberRead = fr.read(buffer)) > -1){
         System.out.println(buffer);
      }
      fr.close();
   }
}