package chap4;

import java.io.*;
public class FileCopy
{
   public static void main(String args[]) throws IOException{
      int numberRead;
      char[] buffer = new char[80];
      FileWriter fw = new FileWriter("example4_3.txt");
      FileReader fr = new FileReader("example4_1.txt");
      while((numberRead = fr.read(buffer)) > -1){
         fw.write(buffer, 0, numberRead);
      }
      fw.close();
      fr.close();
   }
}