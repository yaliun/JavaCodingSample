package chap4;

import java.io.*;
public class AttachLineNumber
{
   public static void main(String args[]){
      String buf;
      FileInputStream fin=null;
      FileOutputStream fout=null;
      if(args.length != 2){ // �μ��� �ҽ����ϸ� �� ������ϸ��� �Է��ؾ� �Ѵ�.
         System.out.println("�ҽ����� �� ��������� �����Ͻʽÿ�.");
         System.exit(1);
      }
      try{
         fin = new FileInputStream(args[0]); // �ҽ� ���ϰ� ����� �Է� ���� ��Ʈ��
         fout = new FileOutputStream(args[1]); // ��� ���ϰ� ����� �Է� ���� ��Ʈ��
      }catch(Exception e){
         System.out.println(e);
         System.exit(1);
      }
      BufferedReader read = new BufferedReader(new InputStreamReader(fin));
      PrintStream write = new PrintStream(fout); // �⺻ fout ��½�Ʈ���� ����
      int num=1;
      while(true){
         try{
            buf=read.readLine(); // �� ���� �����͸� �д´�.
            if(buf==null) break;
         }catch(IOException e){
            System.out.println(e);
            break;
         }
         buf = num + " : " + buf; // [��ȣ : ���α׷� ����] �������� ����
         write.println(buf); // ������ ������ ���Ͽ� ����Ѵ�.
         num++;
      }
      try{
         fin.close();
         fout.close();
      }catch(IOException e){
         System.out.println(e);
      }
   }
}