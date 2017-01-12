import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;


public class BufferedStreamTest {

	public static void main(String[] args) {
		 
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		Date d= null;
		
		try{
			
			// FileInputStream 으로 "StreamFile.txt" 파일의 객체를 생성 후
			// BufferedInputStream 객체를 생성한다.
			fis = new FileInputStream("StreamFile.txt");
			bis = new BufferedInputStream(fis);
			
			// FileOutputStream 으로 출력할 파일 "copyFile.txt" 객체 생성 후
			// BufferedOutputStream 객체를 생성한다.
			fos = new FileOutputStream("copyFile.txt");
			bos = new BufferedOutputStream(fos);
			
			int i =0;
			d= new Date();
			long start = d.getTime();
			
			
			// "StreamFile.txt" 에서 1바이트씩 읽어서 버퍼에 담는다.
			while((i=bis.read())!=-1){
				
				// 1바이트씩 출력버퍼에 담는다.
				bos.write(i);
			}
			
			d= new Date();
			long end = d.getTime();
			System.out.println("복사 시간 : " + (end-start));
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			// 마지막에 FileInputStream / FileOutputStream을 닫아준다.
			// BufferedInputStream / BufferedOutputStream 도 닫아준다.
			if(bis != null) try{bis.close();}catch(IOException e){}
            if(fis != null) try{fis.close();}catch(IOException e){}
            
            // BufferedOutputStream 이 close() 되면서 버퍼의 내용을 출력한다.
            if(bos != null) try{bos.close();}catch(IOException e){}
            if(fos != null) try{fos.close();}catch(IOException e){}
			
		}

	}

}
