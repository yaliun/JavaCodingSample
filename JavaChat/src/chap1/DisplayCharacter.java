package chap1;

import java.io.*;
public class DisplayCharacter
{
   public static void main(String args[]) throws java.io.IOException {
      for(int i=32; i<127; i++){
         System.out.write(i); // 32부터 127까지의 정수값을 프린터로 출력한다.
         if(i%8 == 7)
            System.out.write('\n'); // 8개의 문자를 출력하고 줄을 이동한다.
         else
            System.out.write('\t'); // 하나의 문자를 출력하고 탭을 출력한다.
      }
      System.out.write('\n');
   }
}