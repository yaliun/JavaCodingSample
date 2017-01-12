package mbmt.controls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mbmt.dao.MemberDao;
import mbmt.vo.Member;

//@RequestParam 적용
@Controller
public class MemberAddController {
  MemberDao memberDao;
  
  @Autowired
  public MemberAddController setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
    return this;
  }
  
  @RequestMapping(value="/add.do", method=RequestMethod.GET)
  public String addForm() throws Exception {
     return "/member/MemberForm";
  }
  
  @RequestMapping(value="/add.do", method=RequestMethod.POST)
  public String add(Member member) throws Exception {
    memberDao.insert(member);
    return "redirect:list.do";
  }
}
