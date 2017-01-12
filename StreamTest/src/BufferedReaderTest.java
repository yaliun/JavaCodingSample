import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;


public class BufferedReaderTest
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
        
        try
        {
            FileReader fr = new FileReader("E:/Project/Study/SWT_workspace/StreamTest/src/read.txt");
            BufferedReader br = new BufferedReader(fr); 

            String inputString = br.readLine();
            while (inputString != null)
            {
                System.out.println(inputString);
                inputString = br.readLine();
            }

            br.close();
            fr.close();
        }
        catch(Exception e)
        {}
    }
}

