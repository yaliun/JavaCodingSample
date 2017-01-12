package chap2;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
public class CreateSeqFile extends Frame implements ActionListener
{
   private TextField account, name, balance;
   private Button enter, done; 
   private DataOutputStream output;  // 필터 스트림 객체
   public CreateSeqFile() {
      super( "고객파일을 생성" );
      try {
         output = new DataOutputStream(new FileOutputStream("D:\\Project\\Study\\2014_workspace\\JavaChat\\src\\chap2\\client.txt"));
      }catch ( IOException e ) {
         System.err.println(e.toString());
         System.exit(1);
      }
      setSize(250, 130);
      setLayout( new GridLayout( 4, 2 ));
      add( new Label("구좌번호"));
      account = new TextField(); // 구좌번호 입력 필드
      add(account);
      add(new Label("이름"));
      name = new TextField( 20 ); // 이름 입력 필드
      add(name);      
      add(new Label("잔고"));
      balance = new TextField( 20 ); // 잔고 입력 필드
      add(balance);
      enter = new Button("입력"); // 입력된 데이터를 저장하는 버튼.
      enter.addActionListener(this); // 이벤트와 연결
      add(enter);
      done = new Button("종료"); // 입력을 종료하는 버튼.
      done.addActionListener( this ); // 이벤트와 연결
      add(done);
      setVisible( true );  
   }
   public void addRecord() {
      int accountNo = 0;
      String d;
      if(!account.getText().equals("")){ // 구좌번호의 입력을 체크
         try{
            accountNo = Integer.parseInt(account.getText());
            if(accountNo > 0){
               output.writeInt(accountNo); // 구좌번호를 정수로 파일에 저장한다.
               output.writeUTF(name.getText() ); // 이름을 문자열을 저장한다.
               d=balance.getText(); // 잔고를 문자열로 읽음
               output.writeDouble(Double.valueOf(d)); // 잔고를 실수로 저장한다.
            }
            account.setText( "" ); // 텍스트 필드를 삭제
            name.setText( "" );
            balance.setText( "" );
         }catch (NumberFormatException nfe) {
            System.err.println("정수를 입력해야 합니다." );
         }catch (IOException io) {
            System.err.println(io.toString());
            System.exit( 1 );
         }
      }
   }
   public void actionPerformed(ActionEvent e) {
      addRecord(); // 입력된 데이터를 파일에 저장한다.
      if (e.getSource() == done) {
         try {
            output.close(); // 파일을 닫는다.
         }catch(IOException io) {
            System.err.println(io.toString());
         }
         System.exit( 0 ); // 프로그램을 종료한다.
      }
   }
   public static void main( String args[] ){
      new CreateSeqFile();
   }
}