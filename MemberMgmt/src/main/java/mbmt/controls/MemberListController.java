package mbmt.controls;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mbmt.dao.MemberDao;

//@RequestParam 적용
@Controller
public class MemberListController {
  MemberDao memberDao;
  
  @Autowired
  public MemberListController setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
    return this;
  }
  
  @RequestMapping("/list.do")
  public String execute(String orderCond,Map<String, Object> model) throws Exception 
  {
  	HashMap<String,Object> paramMap = new HashMap<String,Object>();
  	paramMap.put("orderCond", orderCond);
  	
    model.put("members", memberDao.selectList(paramMap));
    model.put("orderCond", orderCond);
    return "member/MemberList";
  }
}
