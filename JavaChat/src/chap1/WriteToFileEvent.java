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
      lfile = new Label("�����̸��� �Է��ϼ���");
      add(lfile);
      tfile = new TextField(20); // �����̸��� �Է��ϴ� �ؽ�Ʈ �ʵ�
      add(tfile);
      ldata = new Label("������ �����͸� �Է��ϼ���");
      add(ldata);
      tdata = new TextField(20); // ������ �����͸� �Է��ϴ� �ؽ�Ʈ �ʵ�
      add(tdata);
      Button save = new Button("�����ϱ�");
      save.addActionListener(this); // �̺�Ʈ ���
      add(save);
      addWindowListener(new WinListener());
   }
   public static void main(String args[]){
      WriteToFileEvent text = new WriteToFileEvent("��������");
      text.setSize(270, 150);
      text.show();
   }
   public void actionPerformed(ActionEvent ae){ // Enter Ű�� �Է��ϸ� ����
      filename=tfile.getText(); // �����̸��� ����
      data=tdata.getText(); // ������ �����͸� ����
      buffer = data.getBytes(); // ����Ʈ �����͸� ��ȯ��
      try{
         FileOutputStream fout = new FileOutputStream(filename);
         fout.write(buffer); // �޸��� ������ ���Ͽ� ���� getBytes() Ȯ���غ���
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
