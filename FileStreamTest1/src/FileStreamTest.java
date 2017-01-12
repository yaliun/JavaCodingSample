import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;


public class FileStreamTest {
	
	public static void main(String[] args){	
	
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		Date d = null;
		
		try{
			
			// "FileStream.txt" FileInputStream 객체를 생성한다.
			// "copyFile.txt" 파일에 FileOutputStream 객체를 생성한다.
			// 데이터 출력시 현재 데이터의 마지막에 추가된다.
			fis = new FileInputStream("FileStream.txt");
			fos = new FileOutputStream("copyFile.txt", true);
			
			// buf 배열의 크기를 1024 로 지정한다.
			byte[] buf = new byte[1024];
			int readCount = 0;
			
			d= new Date();
			long start = d.getTime();
			
			// "FileStream.txt" 에서 buf 크기(1024) 만큼 읽는 것을 반복한다.
			while((readCount = fis.read(buf)) != -1){
				
				// 읽어온 데이터(buf)를 "copyFile.txt"에 출력한다.
				fos.write(buf, 0, readCount);
				System.out.println("readCount : " + readCount);
				
			}
			
			d= new Date();
			long end = d.getTime();
			
			System.out.println("복사 시간 : " +(end-start));
			
		}catch(Exception e){
			e.printStackTrace();
		
		}finally{
			
			// 마지막에 FileInputStream과 FileOutputStream을 닫아준다.
			if(fis != null) try{fis.close();}catch(IOException e){}
			if(fos != null) try{fos.close();}catch(IOException e){}
			
		}
	}
}
