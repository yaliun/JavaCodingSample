package chap1;

import java.io.*;
public class ReadCharactersOffset
{
   public static void main(String args[]){
      try{
         int bufferSize = 10;
         int size=0; // ���ۿ� ����� �������� ���� ������
         int dataRead;
         byte buffer[] = new byte[bufferSize];
         while((dataRead = System.in.read(buffer, size, bufferSize-size)) >= 0){
   // buffer �迭�� enter Ű���� �Էµ� �����͸� ���ʷ� ������
            size += dataRead;
         }
         System.out.write(buffer,0, size); // buffer�� ������ �����
      }catch(IOException e){
         System.err.println("��Ʈ�����κ��� �����͸� ���� �� �����ϴ�.");
      }
      catch(Exception e)
      {
    	  e.printStackTrace();
      }
   }
}