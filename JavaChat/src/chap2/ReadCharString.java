package chap2;

import java.io.*;
public class ReadCharString
{
   static FileInputStream fin;
   static DataInputStream dis;
   public static void main(String args[]){
      char ch;
      String sdata1, sdata2;
      try{
         fin = new FileInputStream("D:\\Project\\Study\\2014_workspace\\JavaChat\\src\\chap2\\chardata.txt");
         dis = new DataInputStream(fin);
         ch = dis.readChar(); // writeChar()의 대응메소드
         sdata1 = dis.readUTF(); // writeUTF()의 대응메소드
         sdata2 = dis.readUTF();  
         System.out.println(ch); // 문자 'A'를 출력
         System.out.println(sdata1); // "반갑습니다"를 출력
         System.out.println(sdata2); // "자바 채팅 프로그래밍 교재"를 출력
      }catch(EOFException e){
         System.out.println(e);
      }catch(IOException e){ 
         System.err.println(e);
      }
   }
}