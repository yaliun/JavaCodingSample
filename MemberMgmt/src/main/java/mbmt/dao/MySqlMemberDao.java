package mbmt.dao;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mbmt.vo.Member;

//@Repository 애노테이션으로 변경
@Repository
public class MySqlMemberDao implements MemberDao {
  SqlSessionFactory sqlSessionFactory;

  @Autowired
  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  public List<Member> selectList(HashMap<String,Object> paramMap) 
  		throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      return sqlSession.selectList("mbmt.dao.MemberDao.selectList", paramMap);
    } finally {
      sqlSession.close();
    }
  }

  public int insert(Member member) throws Exception  {
  	SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      int count = sqlSession.insert("mbmt.dao.MemberDao.insert", member);
      sqlSession.commit();
      return count;
    } finally {
      sqlSession.close();
    }
  }

  public Member selectOne(int no) throws Exception { 
  	SqlSession sqlSession = sqlSessionFactory.openSession();
  	try {
  		return sqlSession.selectOne("mbmt.dao.MemberDao.selectOne", no);
  	} finally {
  		sqlSession.close();
  	}
  }

  public int update(Member member) throws Exception { 
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
    	Member original = sqlSession.selectOne("mbmt.dao.MemberDao.selectOne", member.getNo());
    	
    	Hashtable<String,Object> paramMap = new Hashtable<String,Object>();
    	if (!member.getName().equals(original.getName())) {
    		paramMap.put("name", member.getName());
    	}
    	if (!member.getEmail().equals(original.getEmail())) {
    		paramMap.put("email", member.getEmail());
    	}
    	
    	if (paramMap.size() > 0) {
    		paramMap.put("no", member.getNo());
    		int count = sqlSession.update("mbmt.dao.MemberDao.update", paramMap);
    		sqlSession.commit();
    		return count;
    	} else {
    		return 0;
    	}
    } finally {
      sqlSession.close();
    }
  }
  
  public int delete(int no) throws Exception {  
  	SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      int count = sqlSession.delete("mbmt.dao.MemberDao.delete", no);
      sqlSession.commit();
      return count;
    } finally {
      sqlSession.close();
    }
  }
  
  public Member exist(String email, String password) throws Exception {
  	HashMap<String,String> paramMap = new HashMap<String,String>();
  	paramMap.put("email", email);
  	paramMap.put("password", password);
  	
  	SqlSession sqlSession = sqlSessionFactory.openSession();
  	try {
  		return sqlSession.selectOne("mbmt.dao.MemberDao.exist", paramMap);
  	} finally {
  		sqlSession.close();
  	}
  }
}
