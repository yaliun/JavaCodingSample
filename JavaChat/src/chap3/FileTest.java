package chap3;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class FileTest extends Frame implements ActionListener
{
   private TextField enter;
   private TextArea output;
   public FileTest() {
      super( "File Ŭ���� �׽�Ʈ" );
      enter = new TextField("���� �� ���丮���� �Է��ϼ���");
      enter.addActionListener( this );
      output = new TextArea();
      add(enter, BorderLayout.NORTH);
      add(output, BorderLayout.CENTER);
      addWindowListener(new WinListener());
      setSize( 400, 400 );
      setVisible( true );
   }
   public void actionPerformed(ActionEvent e) {
      File name = new File(e.getActionCommand()); // �ؽ�Ʈ �ʵ��� �����̸��� ����
      if (name.exists()) { // + ������ ���͸� �Է��ϸ� �ȵ�
         output.setText(name.getName() + "�� �����Ѵ�.\n" +
            (name.isFile() ? "�����̴�.\n" : "������ �ƴϴ�.\n" ) +
            (name.isDirectory() ? "���丮�̴�.\n" : "���丮�� �ƴϴ�.\n" ) +
            ( name.isAbsolute() ? "�������̴�.\n" : "�����ΰ� �ƴϴ�.\n" ) +
            "������ ������¥�� : " + name.lastModified() +
            "\n������ ���̴� : " + name.length() +
            "\n������ ��δ� : " + name.getPath() +
            "\n�����δ� : " + name.getAbsolutePath() +
            "\n���� ���丮�� : " + name.getParent() );
         if ( name.isFile() ) {
            try {
               RandomAccessFile r =  new RandomAccessFile(name, "r");
               StringBuffer buf = new StringBuffer();
               String text;
               output.append( "\n\n" );
               while( ( text = r.readLine() ) != null ) 
                  buf.append( text + "\n" );
               output.append( buf.toString() );
            } catch( IOException e2 ) {
            }
         }
         else if(name.isDirectory()) {
            String directory[] = name.list();
            output.append( "\n\n���丮�� ������ :\n");
            for (int i = 0; i < directory.length; i++ )
               output.append( directory[i] + "\n" );
         }
      }
      else {
         output.setText( e.getActionCommand() + " �� �������� �ʴ´�.\n");
      }       
   }
   public static void main( String args[] ) {
      FileTest f = new FileTest();
   }
   class WinListener extends WindowAdapter
   {
      public void windowClosing(WindowEvent we){
         System.exit(0);
      }
   }
}