import java.io.InputStream;
import java.io.InputStreamReader;


public class InputStreamReaderTest
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        
        System.out.println("**************");
        InputStream is = System.in;
        InputStreamReader isr = new InputStreamReader(is);
        char[] temp = new char[5];
        
        int inputValue = 0;
        
        try
        {
            inputValue = isr.read(temp);
        }
        catch(Exception e)
        {}
        
        System.out.println("inputValue : " + inputValue);
        
        for(int i = 0; i < inputValue; i++)
        {
            System.out.println(temp[i]);
        }
        
        System.out.println("char --> String : " + new String(temp));

    }

}
