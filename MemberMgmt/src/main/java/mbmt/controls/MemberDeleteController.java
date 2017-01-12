package mbmt.controls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mbmt.dao.MemberDao;

//@RequestParam 적용
@Controller
public class MemberDeleteController {
  MemberDao memberDao;
  
  @Autowired
  public MemberDeleteController setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
    return this;
  }
  
  @RequestMapping("/delete.do")
  public String execute(int no) throws Exception {
    memberDao.delete(no);
    return "redirect:list.do";
  }
}
