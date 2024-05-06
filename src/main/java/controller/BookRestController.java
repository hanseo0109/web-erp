package controller;

import entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.BookMapper;

import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/api") // -> http://localhost:8081/web-erp/api/books
public class BookRestController {       // JSON -> databind( Object -> JSON )
    @Autowired
    private BookMapper mapper;

    // select
    // GET : http://localhost:8081/web-erp/books
    // list -> JSON , XML방식으로 불러오기
    @GetMapping("/books")
    public ResponseEntity<?> list() {
        List<Book> list = mapper.bookList();
        return new ResponseEntity<>(list, HttpStatus.OK); // 200, Dtaa{JSON)과 응답상태코드를 함께 리턴하는 객체
    }
//    2024.05.06 [ mod-hs ] ResponseEntity generic type으로 변경
//    public @ResponseBody
//    List<Book> list() {     // Json -> List로 convert
//        List<Book> list = mapper.bookList();
//        return list;  // list -> [ { } , { } ] ----> 응답
//    }

    // delete
    @DeleteMapping("/books/{num}")
    public ResponseEntity<?> delete(@PathVariable int num) {
        mapper.bookDelete(num);
        // response 한글 깨짐 방지
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("text", "plain", StandardCharsets.UTF_8));
        return new ResponseEntity<>("성공", headers, HttpStatus.OK);
    }

    // register
    // POST : http://localhost:8081/weberp/api/books
    // postman으로 테스트
    @PostMapping("/books")
    public ResponseEntity<?> register(@RequestBody Book book) {
        int cnt = mapper.bookRegister(book);
//        return new ResponseEntity<>( cnt , HttpStatus.OK);
        return new ResponseEntity<>(cnt == 1 ? "success" : "failed", HttpStatus.OK);
    }

    // 상세보기
    // GET : http://localhost:8081/web-erp/
    @GetMapping("/books/{num}")
    public ResponseEntity<?> getByNum(@PathVariable int num) {
        Book book = mapper.getByNum(num);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PutMapping("/books/{num}")
    public ResponseEntity<?> update(@PathVariable int num, @RequestBody Book book ){
//        2024.05.06 [ mod-hs ] parameter 다건으로 변경되도록
//        book.setNum(num);
        mapper.bookUpdate( num , book);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("text", "plain" , StandardCharsets.UTF_8));
        return new ResponseEntity<>("성공" , headers,  HttpStatus.OK );
    }
}
