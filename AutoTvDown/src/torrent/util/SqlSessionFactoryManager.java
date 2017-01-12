package torrent.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;


/**
 * SqlSessionFactory �ν��Ͻ��� �̱������� ��ȯ��
 * @author hanjoong
 *
 */
public class SqlSessionFactoryManager {

	private static Logger log = Logger.getLogger(SqlSessionFactoryManager.class);
	private static final SqlSessionFactory sqlMapper;
	
	static
	{
		String resource = "torrent/config/SqlMapConfig.xml";
		Reader reader = null;
		try
		{
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		sqlMapper = new SqlSessionFactoryBuilder().build(reader);
	}
	
	
//	SqlSession session = sqlMapper.openSession();
//	session.selectList("org.mybatis.example.BlogMapper.selectBlog", null);
	
	/**
	 * @return SqlSessionFactory �ν��Ͻ��� ��ȯ
	 */
	public static SqlSessionFactory getSqlSessionFactory()
	{
		return sqlMapper;
	}
	
}