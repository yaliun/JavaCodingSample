import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class ReaderWriter {

	public static void main(String[] args) {
		
		// InputStreamReader//OutputStreamWriter를 선언
		InputStreamReader isr = null;
		OutputStreamWriter osw = null;
		

		try {
			
			// System.in 으로 콘솔에서 입력하는 문자를 문자 스트림으로 변환하는 객체 생성
			// System.out 으로 콘솔에 출력하는 OutputStreamWriter 객체 생성
			isr = new InputStreamReader(System.in);	
			osw = new OutputStreamWriter(System.out);
			
			int i = 0;
			
			// InputStreamReader에서 한문자씩 읽으면서 Loop를 돈다.
			while((i=isr.read()) != -1){
				
				// OutputStreamWriter에 읽은 문자 하나를 쓴다.
				//osw.write((char)i);
				osw.write(i);
				
			}
		
					
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}finally{
			
			// InputStreamReader/OutputStreamWriter 를 닫아준다.
			if(isr != null) try{isr.close();}catch(IOException e){}
			if(osw != null) try{osw.close();}catch(IOException e){}
			
		}

	}

}
