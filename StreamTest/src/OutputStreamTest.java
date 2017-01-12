import java.io.InputStream;
import java.io.OutputStream;


public class OutputStreamTest
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        
        InputStream is = System.in;
        OutputStream out = System.out;
        
        System.out.println("***************");
        
        try
        {
            int input = is.read();
            System.out.println("input : " + input);
            
            out.write(input);
            //out.write((char)input);
            out.close();
        }
        catch(Exception e)
        {
        }
       

    }

}
