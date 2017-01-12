package chap4;

import java.io.*;
public class WriteCharacter
{
   public static void main(String args[]) throws IOException {
      String text = "한글 문서 파일입니다.";
      FileWriter fw = new FileWriter("D:\\Project\\Study\\2014_workspace\\JavaChat\\src\\chap4\\example4_1.txt"); 
       // 디폴트(유니코드) 인코딩 방식을 사용하여 저장한다.
      fw.write(text, 0, text.length()); // 파일에 문자열을 저장한다.
      fw.flush(); // 버퍼의 내용을 쓴다.
      fw.close();
   }
}