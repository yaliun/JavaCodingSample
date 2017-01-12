package chap2;

import java.io.*;
public class WriteNumberData
{
   static FileOutputStream fout;;
   static DataOutputStream dos;
   public static void main(String args[]){
      try{
         fout = new FileOutputStream("D:\\Project\\Study\\2014_workspace\\JavaChat\\src\\chap2\\numberdata.txt");
         dos = new DataOutputStream(fout); // ���ϰ� ����� ���� ��Ʈ�� ����
         //dos.writeBoolean(true); // 1���� ���Ͽ� �����Ѵ�.
         //dos.writeDouble(989.27); // �Ǽ��� ���Ͽ� ����ȴ�.
         for(int i=1; i<=500; i++){
            dos.writeInt(i); // 1 ���� 500������ ������ ���Ͽ� �����Ѵ�.
         }
         }catch(IOException e){
         System.err.println(e);
      }finally{
         try{
            if(dos != null) dos.close();
         }catch(IOException e){}
      }
   }
}