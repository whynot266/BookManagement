package mvc.repository;

import mvc.entity.BookDetailsEntity;
import mvc.entity.BookEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Integer> {
    List<BookEntity> findByAuthor(String author);
    List<BookEntity> findByNameAndAuthor(String name, String author);
    @Modifying
    @Transactional(rollbackOn = Exception.class)
    @Query(value = "ALTER TABLE book AUTO_INCREMENT = 1;", nativeQuery = true)
    void removeRedundancyBookId();
    @Modifying
    @Transactional(rollbackOn = Exception.class)
    @Query(value = "ALTER TABLE bookdetails AUTO_INCREMENT = 1;", nativeQuery = true)
    void removeRedundancyBookDetailsId();
    @Query(value = "select * from book where name like %?1% or author like %?2%", nativeQuery = true)
    List<BookEntity> findByNameOrAuthor(String name, String author);
    @Modifying
    @Transactional(rollbackOn = Exception.class)
    @Query(value = "delete from bookdetails where id = ?1", nativeQuery = true)
    void removeBookDetailById(int id);
    @Modifying
    @Transactional(rollbackOn = Exception.class)
    @Query(value = "insert into book(name,author, categoryId) value(?1,?2,?3)", nativeQuery = true)
    void addBook(String name, String author, int categoryId);
    @Modifying
    @Transactional(rollbackOn = Exception.class)
    @Query(value = "insert into bookdetails(isbn, numberOfPage, price, publishDate) value(?1,?2,?3,?4)", nativeQuery = true)
    void addBookDetails(String isbn, int numberOfPage, double price, LocalDate publishDate);

    @Modifying
    @Transactional(rollbackOn = Exception.class)
    @Query(value = "update bookdetails set isbn=?2, numberOfPage=?3, price=?4, publishDate=?5 where id=?1", nativeQuery = true)
    void updateBookDetails(int id, String isbn, int numberOfPage, double price, LocalDate publishDate);
}
