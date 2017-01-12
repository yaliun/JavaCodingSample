import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class DataStreamTest {

	public static void main(String[] args) {
		
		FileInputStream fis = null;
		DataInputStream dis = null;
		
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		
		try{
			
			// "StreamFile.out" 파일을 출력하는 객체를 생성한다.
			// DataOutputStream Filter를 적용한다.
			fos = new FileOutputStream("StreamFile.out");
			dos = new DataOutputStream(fos);
			
			// "StreamFile.out" 파일에 각 기본형 데이터를 출력한다.
			dos.writeBoolean(false);
			dos.writeByte(Byte.MAX_VALUE);
			dos.writeChar('굿');
			dos.writeDouble(Double.MAX_VALUE);
			dos.writeFloat(Float.MIN_VALUE);
			dos.writeLong(Long.MAX_VALUE);
			dos.writeShort(Short.MAX_VALUE);
			dos.writeUTF("안녕하세요");
			
			// "StreamFile.out" 파일을 읽는 객체를 생성한다.
			// DataInputStream Filter를 적용한다.
			fis = new FileInputStream("StreamFile.out");
			dis = new DataInputStream(fis);
			
			// "StreamFile.out" 파일에서 각 기본형 데이터를 읽어온다.
			System.out.println(dis.readBoolean());
			System.out.println(dis.readByte());
			System.out.println(dis.readChar());
			System.out.println(dis.readDouble());
			System.out.println(dis.readFloat());
			System.out.println(dis.readLong());
			System.out.println(dis.readShort());
			System.out.println(dis.readUTF());
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			if(dis != null) try{dis.close();}catch(IOException e){}
			if(fis != null) try{fis.close();}catch(IOException e){}
			            
			if(dos != null) try{dos.close();}catch(IOException e){}
			if(fos != null) try{fos.close();}catch(IOException e){}
			          
		}
		

	}

}
