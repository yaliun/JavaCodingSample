package chap9;

// Step 1
// 서버-클라이언트 구조에서 서버와 클라이언트가 1:1로 대화하는 프로그램
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;

public class OneToOneC extends Frame implements ActionListener {
	
   TextArea display;
   TextField text;
   Label lword;
   BufferedWriter output;
   BufferedReader input;
   Socket client;
   String clientdata = "";
   String serverdata = "";
   public OneToOneC() {
      super("클라이언트");
      display=new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
      display.setEditable(false);
      add(display, BorderLayout.CENTER);

      Panel pword = new Panel(new BorderLayout());
      lword = new Label("대화말");
      text = new TextField(30); //전송할 데이터를 입력하는 필드
      text.addActionListener(this); //입력된 데이터를 송신하기 위한 이벤트 연결
      pword.add(lword, BorderLayout.WEST);
      pword.add(text, BorderLayout.EAST);
      add(pword, BorderLayout.SOUTH);

      addWindowListener(new WinListener());
      setSize(300, 200);
      setVisible(true);
   }
	
   public void runClient() {
      try {
         client = new Socket(InetAddress.getLocalHost(), 5000);
         input = new BufferedReader(new InputStreamReader(client.getInputStream()));
         output = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
         while(true) {
            String serverdata = input.readLine();
            if(serverdata.equals("quit")) {
               display.append("\n서버와의 접속이 중단되었습니다.");
               output.flush();
               break;
            } else {
               display.append("\n서버 메시지 : " + serverdata);
               output.flush();
            }
         }
         client.close();
      } catch(IOException e ) {
         e.printStackTrace();
      }
   }
		
   public void actionPerformed(ActionEvent ae){
      clientdata = text.getText();
      try{
         display.append("\n클라이언트 : "+clientdata);
         output.write(clientdata+"\r\n");
         output.flush();
         text.setText("");
         if(clientdata.equals("quit")){
            client.close();
         }
      } catch(IOException e){
         e.printStackTrace();
      }
   }
		
   public static void main(String args[]) {
      OneToOneC c = new OneToOneC();
      c.runClient();
   }
		
   class WinListener extends WindowAdapter {
      public void windowClosing(WindowEvent e){
         System.exit(0);
      }
   }			
}