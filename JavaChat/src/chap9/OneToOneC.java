package chap9;

// Step 1
// ����-Ŭ���̾�Ʈ �������� ������ Ŭ���̾�Ʈ�� 1:1�� ��ȭ�ϴ� ���α׷�
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
      super("Ŭ���̾�Ʈ");
      display=new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
      display.setEditable(false);
      add(display, BorderLayout.CENTER);

      Panel pword = new Panel(new BorderLayout());
      lword = new Label("��ȭ��");
      text = new TextField(30); //������ �����͸� �Է��ϴ� �ʵ�
      text.addActionListener(this); //�Էµ� �����͸� �۽��ϱ� ���� �̺�Ʈ ����
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
               display.append("\n�������� ������ �ߴܵǾ����ϴ�.");
               output.flush();
               break;
            } else {
               display.append("\n���� �޽��� : " + serverdata);
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
         display.append("\nŬ���̾�Ʈ : "+clientdata);
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