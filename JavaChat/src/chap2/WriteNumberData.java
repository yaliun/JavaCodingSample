package chap2;

import java.io.*;
public class WriteNumberData
{
   static FileOutputStream fout;;
   static DataOutputStream dos;
   public static void main(String args[]){
      try{
         fout = new FileOutputStream("D:\\Project\\Study\\2014_workspace\\JavaChat\\src\\chap2\\numberdata.txt");
         dos = new DataOutputStream(fout); // 파일과 연결된 필터 스트림 생성
         //dos.writeBoolean(true); // 1값을 파일에 저장한다.
         //dos.writeDouble(989.27); // 실수를 파일에 저장된다.
         for(int i=1; i<=500; i++){
            dos.writeInt(i); // 1 부터 500까지의 정수를 파일에 저장한다.
         }
         }catch(IOException e){
         System.err.println(e);
      }finally{
         try{
            if(dos != null) dos.close();
         }catch(IOException e){}
      }
   }
}