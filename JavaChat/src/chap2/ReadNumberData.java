package chap2;

import java.io.*;
public class ReadNumberData
{
   static FileInputStream fin;
   static DataInputStream dis;
   public static void main(String args[]){
      boolean bdata;
      double ddata;
      int number;
      try{
         fin = new FileInputStream("D:\\Project\\Study\\2014_workspace\\JavaChat\\src\\chap2\\numberdata.txt");
         dis = new DataInputStream(fin);
         bdata = dis.readBoolean(); // 부울 값을 읽는다.
         System.out.println(bdata);
         ddata = dis.readDouble(); // 실수 값을 읽는다.
         System.out.println(ddata);
         while(true){
            number = dis.readInt();
            System.out.print(number+" "); // 정수값을 읽고 화면에 출력한다.
         }
      }catch(EOFException e){
         System.out.println("데이터를 모두 읽었습니다."); // 정상종료
      }catch(IOException e){ // 비정상 종료
         System.err.println(e);
      }
   }
}