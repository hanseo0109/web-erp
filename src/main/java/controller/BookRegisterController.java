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

//@WebServlet("/register")
public class BookRegisterController extends HttpServlet {
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
//
//        Book dto = new Book();
//        dto.setTitle(req.getParameter("title"));
//        dto.setPrice(Integer.parseInt(req.getParameter("price")));
//        dto.setAuthor(req.getParameter("author"));
//        dto.setPage(Integer.parseInt(req.getParameter("page")));
//
//        BookDAO dao = new BookDAO();
//        int cnt = dao.bookRegister(dto);
//        // 성공 -> 다시 리스트페이지로 가기
//        if (cnt > 0) {
//            req.setAttribute("title" ,"등록 완료");
//            req.setAttribute("message" ,"책 등록이 완료되었습니다.");
//            req.setAttribute("movePage" ,"bookList");
//
//            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/message.jsp");
//            rd.forward(req, resp);
////            resp.sendRedirect("/web-erp/bookList");
//        }
//        else{
//            throw new ServletException("error");
//        }
//        // 실패 -> 예외 발생
//
//    }
}
