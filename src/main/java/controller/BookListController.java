package controller;

import entity.Book;
import repository.BookDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
// http://localhost:8081/web-erp/bookList
//@WebServlet("/bookList")
public class BookListController extends HttpServlet {
     // GET --> doGet()  @GetMapping()
    // POST -->doPost() @PostMapping()
    // service
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        BookDAO dao = new BookDAO();
//        List<Book> list = dao.bookList();
//        req.setAttribute("list" , list );   // 객체바인딩

        // Database(DAO)에서 책목록을 가져오기 :  List -> ArrayList
//        List<Book> list=new ArrayList<Book>();
//        list.add(new Book(1,"자바1", 12000,"홍길동", 500));
//        list.add(new Book(2,"자바2", 13000,"박길동", 600));
//        list.add(new Book(3,"자바3", 14000,"이길동", 700));
        //  "list"---->list(번지값)

        // view의 논리적인 이름을 view의 물리적인 전체 경로를 변경해주는 객체 : viewResolver
//        RequestDispatcher rd =req.getRequestDispatcher("list");
        //  View(JSP)와 연동하기(forward, dispatcher)
        // 요청의뢰객체(RequestDispatcher)를 얻어오는 방법

//        2024.05.03 [ mod-hs ] 호출 방식 변경
        // view의 논리적인 이름(list)를 뷰의 물리적인 전체 경로( /WEB-INF/views.list.jsp )로 변경해주는 객체를 우리는 `ViewResolver'라고 한다.
        // RequestDispatcher rd =req.getRequestDispatcher("/WEB-INF/views/list.jsp");
        // ViewResolver는 나중에 spring에서 제공해준다.
//        RequestDispatcher rd = req.getRequestDispatcher("list");
//        rd.forward(req, resp);
//    }
}
