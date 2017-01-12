import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;


public class BufferedInputStreamTest
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        
        System.out.println("**************");
        try
        {
            FileInputStream fis = new FileInputStream("E:/Project/Study/SWT_workspace/StreamTest/src/read.txt");
            
            BufferedInputStream bis = new BufferedInputStream(fis);
            
            byte[] b = new byte[20];

            int inputValue = bis.read(b);
          
          System.out.println("inputvalue : " + inputValue);
          
          for(int i = 0; i < inputValue; i++)
          {
              System.out.println((char)b[i]);
          }
          
          System.out.println("String : " + new String(b));
          bis.close();
        }
        catch(Exception e)
        {}

    }

}
