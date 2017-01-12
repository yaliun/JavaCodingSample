import java.io.File;
import java.io.IOException;


public class FileTest {

	public static void main(String[] args) {
		
		// FileTest project 폴더에서 filefolder\test.txt  파일을 객체로 생성한다.
		// \ 는 이스케이프 문자로 인식되므로 \\ -> \ 로 사용한다.
		File file = new File("filefolder\\test.txt");

		// 경로에 파일이 존재하면
		if(file.exists()){
			
			try{
				
				System.out.println("getName: " + file.getName());  // 파일 이름 출력
				System.out.println("getPath: " + file.getPath());    // 파일 경로 출력 
				System.out.println("getAbsolutePath : "+ file.getAbsolutePath());  // 파일 절대 경로 출력
				System.out.println("getCanonicalPath : "+ file.getCanonicalPath()); // 파일 정규 경로 출력
				System.out.println("getParent : " + file.getParent());   // 상위 폴더 출력
				
				// 파일의 쓰기/읽기 권한 체크
				if(file.canWrite()) System.out.println(file.getName() + "은 쓸 수 있습니다.");
				if(file.canRead()) System.out.println(file.getName()+ "은 읽을 수 있습니다.");
				
				// 객체의 파일, 폴더 여부 체크
				if(file.isFile()){
					System.out.println(file.getName() + "은 파일입니다.");
				}else if(file.isDirectory()){
					System.out.println(file.getName() + "은 폴더입니다.");
				}else{
					System.out.println(file.getName() + "은 파일도 폴더도 아닙니다.");
				}
				
				// 파일 내용 길이 출력
				System.out.println(file.getName() + "의 길이는 "+ file.length() + " 입니다.");
			
			}catch(IOException e){
				System.err.println(e);
			}
		
		}else{
			System.out.println("파일을 찾을 수 없습니다. ");
		}

	}

}
