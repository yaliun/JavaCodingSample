import java.io.FileReader;


public class FileReaderTest
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        FileReader file = null;
        int inputValue = 0;
        
        try
        {
            file = new FileReader("E:/Project/Study/SWT_workspace/StreamTest/src/read.txt");
            
            while((inputValue = (file.read())) != -1)
            {
                System.out.println((char)inputValue);
            }
            file.close();
        }
        catch(Exception e)
        {}
    }

}
