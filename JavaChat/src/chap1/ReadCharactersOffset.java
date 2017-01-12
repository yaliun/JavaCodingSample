package chap1;

import java.io.*;
public class ReadCharactersOffset
{
   public static void main(String args[]){
      try{
         int bufferSize = 10;
         int size=0; // 버퍼에 저장된 데이터의 수를 저장함
         int dataRead;
         byte buffer[] = new byte[bufferSize];
         while((dataRead = System.in.read(buffer, size, bufferSize-size)) >= 0){
   // buffer 배열에 enter 키까지 입력된 데이터를 차례로 저장함
            size += dataRead;
         }
         System.out.write(buffer,0, size); // buffer의 내용을 출력함
      }catch(IOException e){
         System.err.println("스트림으로부터 데이터를 읽을 수 없습니다.");
      }
      catch(Exception e)
      {
    	  e.printStackTrace();
      }
   }
}