package torrent.dao;

import java.util.ArrayList;
import java.util.HashMap;
import org.apache.log4j.*;

import org.apache.ibatis.session.SqlSessionFactory;
import torrent.util.SqlSessionFactoryManager;

public class MemberDao
{
	static Logger log = Logger.getLogger(MemberDao.class);
	
	SqlSessionFactory sqlMapper = SqlSessionFactoryManager.getSqlSessionFactory();
		
	public MemberDao()
	{
		// TODO Auto-generated constructor stub
	}
		
	/**
	 * Member getId()
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String getChannel()
	{
		String channel;
		channel = sqlMapper.openSession().selectOne("torrent.query.Member.getChannel");
		log.debug("channel : " + channel);
		return channel;
	}

	/**
	 * Member 를 모두 반환함
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public HashMap<String, String> getMemberInfo(String id)
	{
		HashMap<String, String> infoMap = null;
		infoMap = (HashMap) sqlMapper.openSession().selectOne("query.sample.Member.getMemberInfo",id);
		log.debug("infoMap : " + infoMap);
		return infoMap;
	}	
	
	/**
	 * Member 를 모두 반환함
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList<HashMap<String, String>> getList()
	{
		ArrayList<HashMap<String, String>> list = null;
		list = (ArrayList) sqlMapper.openSession().selectList("query.sample.Member.getList");
		log.debug("list : " + list);
		return list;
	}
	
	
}