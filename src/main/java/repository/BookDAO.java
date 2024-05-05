package repository;

import entity.Book;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

// JDBC -> MyBatis(mybatis.org)-> Spring Mybatis-> | Hibernate(ORM) -> JPA(?)
// JDBC -> Java 소스코드 + SQL :  유지보수어렵다, 생산성이 떨어진다(?).
// DAO -> Mapper로 변경
public class BookDAO {
    /*private static SqlSessionFactory sqlSessionFactory;
    이쪽은 spring이 처리
    static {
        try {
            String resource = "mybatis-config/config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Book> bookList(){
        SqlSession session = sqlSessionFactory.openSession();
        List<Book> list = session.selectList("bookList");
        session.close();
        return list;
    }

    public int bookRegister(Book book) {
        SqlSession session = sqlSessionFactory.openSession();
        int cnt = session.insert("bookRegister", book);
        session.commit();
        session.close();
        return cnt;
    }*/
}