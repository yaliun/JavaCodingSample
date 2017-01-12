package torrent.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.*;
import org.apache.ibatis.session.SqlSessionFactory;

import torrent.util.SqlSessionFactoryManager;

public class TorrentManageDao
{
	static Logger log = Logger.getLogger(TorrentManageDao.class);
	
	SqlSessionFactory sqlMapper = SqlSessionFactoryManager.getSqlSessionFactory();
		
	public TorrentManageDao()
	{
		// TODO Auto-generated constructor stub
	}
		
	/**
	 * Member getId()
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public int selectConfirmTarget()
	{
		int cnt = 0;
		cnt = sqlMapper.openSession().selectOne("torrent.query.TorrentManage.selectConfirmTarget");
		log.debug("cnt : " + cnt);
		return cnt;
	}
	
	public void insertDownLoadTarget()
	{
		sqlMapper.openSession().selectOne("torrent.query.TorrentManage.insertDownLoadTarget");
	}
	
	public List selectNotDownloadList()
	{
		List list = null;
		list = sqlMapper.openSession().selectList("torrent.query.TorrentManage.selectNotDownloadList");
		return list;
	}

	/**
	 * Member �� ��� ��ȯ��
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
	 * Member �� ��� ��ȯ��
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