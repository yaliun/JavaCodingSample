package chap1;

import java.awt.font.NumericShaper;
import java.io.*;
public class ReadCharactersBlock
{
   public static void main(String args[]) throws java.io.IOException {
      byte[] buffer = new byte[10];
      int numberRead; // 읽어서 배열에 저장한 바이트 데이터수를 저장한다
      
      while((numberRead = System.in.read(buffer)) >= 0)
      {
  // 키보드에서 enter키 까지 입력한 문자들을 읽어서 buffer 배열에 저장하고
 // 읽은 문자 데이터 수를 반환하여 numberRead 정수변수에 저장한다.
    	  System.out.write(buffer, 0, numberRead);
    	  System.out.println("");
      }

 // buffer에 있는 데이터를 처음부터 numberRead 개수 만큼 화면에 출력한다.
   }
}