import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;


public class OutputStreamWriterTest
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        InputStream is = System.in;
        OutputStream out = System.out;
        char[] store = new char[10];
        
        InputStreamReader isr = new InputStreamReader(is);
        OutputStreamWriter osw = new OutputStreamWriter(out);
        System.out.println("***************");
        
        try
        {
            int input = isr.read(store);
            System.out.println("Input Value Count : " + input);
            
            System.out.println("String value = " + new String(store));
            
            System.out.println("OutputStreamWriter : ");
            osw.write(store);
            
            
            osw.close();
        }
        catch(Exception e)
        {}
        
    }

}
