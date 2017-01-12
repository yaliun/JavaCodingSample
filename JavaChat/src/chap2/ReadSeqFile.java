package chap2;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
public class ReadSeqFile extends Frame implements ActionListener
{
   private TextField account, name, balance;
   private Button next, done; 
   private DataInputStream input;  // 필터 입력 스트림 객체
   public ReadSeqFile() {
      super( "고객파일을 읽음");
      try {
         input = new DataInputStream(new FileInputStream("D:\\Project\\Study\\2014_workspace\\JavaChat\\src\\chap2\\client.txt"));
      }catch ( IOException e ) {
         System.err.println(e.toString());
         System.exit(1);
      }      
      setSize(250, 130);
      setLayout( new GridLayout( 4, 2 ));
      add( new Label("구좌번호"));
      account = new TextField(); // 구좌번호를 읽는 필드.
      account.setEditable(false); // 데이터 입력을 금지시킨다.
      add(account);
      add(new Label("이름"));
      name = new TextField( 20 ); // 이름을 읽는 필드.
      name.setEditable(false); // 데이터의 입력을 금지시키다.
      add(name);
      add(new Label("잔고"));
      balance = new TextField( 20 ); // 잔고를 읽는 필드.
      balance.setEditable(false); // 데이터의 입력을 금지시킨다.
      add(balance);
      next = new Button("출력"); // 파일로부터 데이터를 읽는 버튼
      next.addActionListener(this);
      add(next);      
      done = new Button("종료"); // 프로그램을 종료하는 버튼
      done.addActionListener( this );
      add(done);       
      setVisible(true);  
   }
   public void actionPerformed(ActionEvent e){
      if (e.getSource() == next)
         readRecord(); // 데이터를 한 레코드씩 읽는 메소드
      else
         closeFile();
   }
   public void readRecord(){
      int accountNo;
      double d;
      String namedata;
      try{
         accountNo = input.readInt(); // 정수값인 구좌번호를 읽는다.
         namedata = input.readUTF(); // 문자열인 이름을 읽는다.
         d = input.readDouble(); // 실수값인 잔고를 읽는다.
// 읽어드린 데이터를 관련된 텍스트 필드에 출력한다.
         account.setText(String.valueOf(accountNo));
         name.setText(namedata);
         balance.setText(String.valueOf(d));
      }catch(EOFException eof){
         closeFile();
      }catch (IOException io) {
         System.err.println(io.toString());
         System.exit(1);
      }
   }
   private void closeFile(){ // 스트림을 닫고 프로그램을 종료한다.
      try{
         input.close();
         System.exit(0);
      }catch(IOException io){
         System.err.println(io.toString());
         System.exit(1);
      }
   }
   public static void main( String args[] ){
      new ReadSeqFile();
   }
}