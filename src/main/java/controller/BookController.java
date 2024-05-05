package controller;

import entity.Book;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import repository.BookDAO;
import repository.BookMapper;

import java.util.List;

// Spring Container( 객체가 관리되는 메모리 공간 )
// 모든 controller의 역할을 수행한다.
@Controller
public class BookController {
    // 책과 관련된 일을 하는 controller
    // bookList( 요청, 핸들 ) --> HandlerMapping : POJO 연결
    // web.xml DisparcherServlet에 선언된 ?
    // Spring은 RequestMapping 이용
    // interface
    @Autowired  // DI(의존성 주입) -> root-context.xml의 SqlSessionFactoryBean > BookMapper.xml의 내용을 가져오겠다는 의미
    private BookMapper mapper;

    // select
    @RequestMapping("/bookList")
    public String list(Model model) {
        // 책 리스트 가져오기
        // View : list
        List<Book> list = mapper.bookList();
        model.addAttribute("list", list);
//        BookDAO dao = new BookDAO();
//        List<Book> list = dao.bookList();
//        model.addAttribute("list", list);
        return "list";  // view의 논리적인 이름
    }

    @RequestMapping("/bookJson")
    public @ResponseBody List<Book> list(){     // Json -> List로 convert
        List<Book> list = mapper.bookList();
        return list;  // list -> [ { } , { } ] ----> 응답
    }

    // insert
    @RequestMapping("/register")  // GET - 등록화면
    public String registerGET() {
        return "register";      // register.jsp : forward
    }

    @PostMapping("/register")  // POST - 등록
    public String registerPOST(Book book) {
        mapper.bookRegister(book);

//        BookDAO dao = new BookDAO();
//        dao.bookRegister(book);
        // 등록이 성공 다시 리스트로 가기 -> redirect
        // ( 중요! ) book 등록 후 바로 return redirect로 가면 안됨 ( ex. return "list" )
        //  ㄴ 왜?
        //      DB에 있는 내역을 다시 불러와서 `객체 바인딩` 해줘야 하기 때문에
        return "redirect:bookList";     // web-erp/bookList
    }

//    @GetMapping("/remove")
//    public String remove(int num) {   // @RequestParam("num") 생략 됨
//    Path variable을 여러개 받을 경우 -> @GetMapping("/remove/{num1}/{num2}")
    /*
    Rest Full Service
    1. GET : @GetMapping
    2. POST : @PutMapping
    3. PUT : @PutMapping
    4. DELETE : @DeleteMapping
     */
    @GetMapping("/remove/{num}")
    public String remove(@PathVariable int num ){
        mapper.bookDelete(num);
        return "redirect:/bookList";
    }
}
