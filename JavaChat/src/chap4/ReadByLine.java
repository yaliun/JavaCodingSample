package chap4;

import java.io.*;
public class ReadByLine
{
   public static void main(String args[]){
      String data;
      if(args.length != 1)
         System.err.println("입력 파일을 지정하십시오.");
      try{
         FileReader infile = new FileReader(args[0]); // 명령어 라인에서 읽음
         BufferedReader br = new BufferedReader(infile);
         while((data=br.readLine()) != null){ // 한 줄씩 읽는다.
            System.out.println(data);
         }
      }catch(IOException e){
         System.err.println(e);
      }
   }
}