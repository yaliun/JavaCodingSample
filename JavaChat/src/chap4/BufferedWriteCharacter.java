package chap4;

import java.io.*;
public class BufferedWriteCharacter
{
   public static void main(String args[]) throws IOException {
      String text = "BufferedWriter 클래스를 이용해서 저장한 파일입니다.";
      FileWriter fw = new FileWriter("example4_4.txt");
      BufferedWriter bw = new BufferedWriter(fw); // bw는 fw에 연결된다. 
       // 디폴트(유니코드) 인코딩 방식을 사용하여 저장한다.
      bw.write(text, 0, text.length()); // 파일에 문자열을 저장한다.
       // bw.write(text); 를 이용해도 됨.
      bw.flush(); // 버퍼의 내용을 쓴다.
      bw.close();
   }
}