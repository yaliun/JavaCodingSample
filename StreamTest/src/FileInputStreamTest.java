import java.io.FileInputStream;
import java.io.InputStreamReader;


public class FileInputStreamTest
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

        System.out.println("**************");
        int inputValue = 0;
        
        FileInputStream fis = null;        
        InputStreamReader isr =null;
        
        try
        {
            fis = new FileInputStream("E:/Project/Study/SWT_workspace/StreamTest/src/read.txt");
            isr = new InputStreamReader(fis);
            
            while((inputValue = isr.read( )) != -1)
            {
                System.out.println((char)inputValue);
            }
        }
        catch(Exception e)
        {}
        finally
        {
            try
            {
                fis.close();                
            }
            catch(Exception e)
            {}
        }
    }
}
