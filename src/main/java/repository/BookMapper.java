package repository;

import entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * JDBC -> MyBatis( mybatis-.org ) -> Spring Mybatis -> | Hibernate(ORM) -> JPA
 * JDBC -> Java source code + SQL : 유지보수가 어렵고 생산성이 떨어짐
 */

// @Mapper 애노테이션을 사용하여 Spring에게 이것이 Mapper 인터페이스임을 알린다
public interface BookMapper{    // BookDAO dao = new BookDAO(); 는 이제 사용 안함
    // CRUD Method
    public List<Book> bookList();
    public List<Book> bookList(@Param("order") String order);
    public int bookRegister(Book book);
    public void bookDelete(int num);   // #{num}
    public Book getByNum(int num);     // #{num}

    public void bookUpdate(@Param("num") int num, @Param("book") Book book);
    // 2024.05.06 [ mod-hs ] parameter가 다건이면 @Param이용
//    public void bookUpdate(int num , Book book);
}
