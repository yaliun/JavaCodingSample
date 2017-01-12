package chap1;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
class WriteToFileEvent extends Frame implements ActionListener
{
   Label lfile, ldata;
   TextField tfile, tdata;
   Button save;
   String filename, data;
   byte buffer[] = new byte[80];

   public WriteToFileEvent(String str){
      super(str);
      setLayout(new FlowLayout());
      lfile = new Label("파일이름을 입력하세요");
      add(lfile);
      tfile = new TextField(20); // 파일이름을 입력하는 텍스트 필드
      add(tfile);
      ldata = new Label("저장할 데이터를 입력하세요");
      add(ldata);
      tdata = new TextField(20); // 저장할 데이터를 입력하는 텍스트 필드
      add(tdata);
      Button save = new Button("저장하기");
      save.addActionListener(this); // 이벤트 등록
      add(save);
      addWindowListener(new WinListener());
   }
   public static void main(String args[]){
      WriteToFileEvent text = new WriteToFileEvent("파일저장");
      text.setSize(270, 150);
      text.show();
   }
   public void actionPerformed(ActionEvent ae){ // Enter 키를 입력하면 실행
      filename=tfile.getText(); // 파일이름을 읽음
      data=tdata.getText(); // 저장할 데이터를 읽음
      buffer = data.getBytes(); // 바이트 데이터를 변환함
      try{
         FileOutputStream fout = new FileOutputStream(filename);
         fout.write(buffer); // 메모리의 내용을 파일에 저장 getBytes() 확인해볼것
      }catch(IOException e){
         System.out.println(e.toString());
      }
   }
   class WinListener extends WindowAdapter
   {
      public void windowClosing(WindowEvent we){
         System.exit(0);
      }
   }
}
