
public class InTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int bt;
		int cnt = 0;
		
		try
		{
			while((bt = System.in.read())!=-1)
			{
				cnt++;
				
				//System.out.write(bt);
				
				System.out.printf("%h", bt);
			}
			
		}
		catch(Exception e)
		{
			System.err.println(e);
		}
		
		System.out.println();
		System.out.println("total bytes : " + cnt);
	}
}