import java.io.InputStream;

public class InputStreamTest
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        
        System.out.println("**************");
        InputStream is = System.in;
        byte[] temp = new byte[5];
        int inputValue = 0;
        
        try
        {
            inputValue = is.read(temp);
        }
        catch(Exception e)
        {            
        }
        
        System.out.println("input : " + inputValue);
        
        for(int i = 0; i < inputValue; i++)
        {
            System.out.println((char)temp[i]);
        }
        
            System.out.println("string : " + new String(temp));
    }

}