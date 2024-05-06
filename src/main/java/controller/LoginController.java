package controller;

import entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import repository.BookMapper;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private BookMapper mapper;

    @PostMapping("/login")
    public String login(Member member, HttpSession session) {
        if (member.getUsername().equals("admin")
                && member.getPassword().equals("admin")     // 인증에 성공한 경우
        ) {
            Member mem = new Member();
            mem.setUsername(mem.getUsername());
            mem.setName("관리자");
            mem.setEmail("h@naver.com");
            session.setAttribute("dbMem", mem);
        }
        return "redirect:/bookList";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();   // session 끊기
        return "redirect:/bookList";
    }
}
