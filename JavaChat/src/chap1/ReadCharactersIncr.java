package chap1;

import java.io.*;
public class ReadCharactersIncr
{
   static int size = 0;
   static int bufferSize = 80;
   static byte buffer[] = new byte[bufferSize];
   public static void main(String args[]){
      try{
         int dataRead;
         while((dataRead = System.in.read(buffer, size, bufferSize-size)) >= 0){
            size += dataRead;
            if(size == bufferSize)
               increaseBufferSize();
         }
         System.out.write(buffer,0, size);
      }catch(IOException e){
         System.err.println("��Ʈ�����κ��� �����͸� ���� �� �����ϴ�.");
      }
   }
   static void increaseBufferSize(){
      bufferSize += 80;
      byte[] newBuffer = new byte[bufferSize];
      System.arraycopy(buffer, 0, newBuffer, 0, size);
      buffer = newBuffer; // buffer �迭�� ũ�Ⱑ 80�� �þ��.
   }
}
