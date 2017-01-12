import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AutoTvDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			StringBuffer cookie = new StringBuffer();
			StringBuffer sbuf = new StringBuffer();
			String str;
			
			InputStream is;
			InputStreamReader isr;
			BufferedReader br;
						
			URL cookieUrl = new URL("http://torrentman.net/index.php");
			URLConnection urlConn = cookieUrl.openConnection();
			urlConn.setRequestProperty("User-Agent", "Mozilla/4.0");
			
			Map map = urlConn.getHeaderFields();

			if(map.containsKey("Set-Cookie")) {
			        Collection c =(Collection)map.get("Set-Cookie");
			        for(Iterator i = c.iterator(); i.hasNext(); )
			        {
			        	cookie.append(i.next());
			        }
			}
			
			//System.out.println(cookie);
			
			URL searchUrl = new URL("http://torrentman.net/bbs/s.php?k=빅리그");
			//URL searchUrl = new URL("http://torrentman.net/bbs/bbc.php?bo_table=torrent_variety&page=1");
			urlConn = searchUrl.openConnection();
			
			is = urlConn.getInputStream();
			isr = new InputStreamReader(is, "utf-8");
			br = new BufferedReader(isr);
			
			while((str = br.readLine()) != null)
			{
				sbuf.append(str + "\r\n");
			}
			
			//System.out.println(sbuf);
			

			
			/*
			URL varietyUrl = new URL("http://torrentman.net/bbs/bbc.php?bo_table=torrent_variety&page=1");
			urlConn = varietyUrl.openConnection();
			urlConn.setRequestProperty("User-Agent", "Mozilla/4.0");
			urlConn.setRequestProperty("Cookie", cookie.toString());
			
			
			
			is = urlConn.getInputStream();
			isr = new InputStreamReader(is, "utf-8");
			br = new BufferedReader(isr);
			
			
			
			while((str = br.readLine()) != null)
			{
				sbuf.append(str + "\r\n");
			}
			*/
			
			
			//System.out.println(sbuf.toString());
			
			//String makeRepExp = "<a href='../bbs/bbc.php\\?bo_table=torrent_variety&wr_id=.+'>무한도전.+150301.+720.+></a>";
			//String makeRepExp = "<a href='s.php.+>\n+.+\n+.+150228.+720.+>";

			String makeRepExp = "<a href='s.php.+>\r?\n+.+\r?\n+.+150301.+720.+>";
			
			Pattern p = Pattern.compile(makeRepExp);
			Matcher m = p.matcher(sbuf);
			String findStr = "";
			
			if (m.find())
			{
				findStr = m.group();				
			}
			
			String reg ="bo_table=.+&wr_id=[\\d]*";
			
			p = Pattern.compile(reg);
			m = p.matcher(findStr);
			
			if (m.find())
			{
				findStr = m.group();
				System.out.println(findStr);
			}
			
			
			URL downUrl = new URL("http://torrentman.net/bbs/download.php?"+findStr);
			
			URLConnection downConn = downUrl.openConnection();
			downConn.setRequestProperty("User-Agent", "Mozilla/4.0");
			downConn.setRequestProperty("Cookie", cookie.toString());
			downConn.setRequestProperty("Referer", "http://torrentman.net/bbs/bbc.php?"+findStr);
			
			
			str = "";
			
			is = downConn.getInputStream();
			
			File file = new File("D:\\Study\\2014_workspace\\AutoTvDown\\src\\abc.torrent");
			FileOutputStream out = new FileOutputStream(file);
			int ch;
			
			
			while((ch = is.read()) != -1)
			{
				out.write(ch);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
