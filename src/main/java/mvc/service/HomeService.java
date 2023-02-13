package mvc.service;

import mvc.config.SpringConfig;
import mvc.entity.BookDetailsEntity;
import mvc.entity.BookEntity;
import mvc.entity.CategoryEntity;
import mvc.repository.BookRepository;
import mvc.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    CategoryRepository categoryRepository;


    public  List<CategoryEntity> findAllCategory(){
        List<CategoryEntity> categoryEntityList = (List<CategoryEntity>) categoryRepository.findAll();
        return categoryEntityList;
    }
    public  void updateBook(BookEntity book){
        bookRepository.save(book);
    }
    public  BookEntity findById(int id) {

        return bookRepository.findById(id).get();
    }

    public  void deleteById(int id) {
        bookRepository.deleteById(id);
    }
    public  void updateBookDetails(int id, BookDetailsEntity bookDetails){
        bookRepository.updateBookDetails(id,bookDetails.getIsbn(),bookDetails.getNumberOfPage(),bookDetails.getPrice(),bookDetails.getPublishDate());
    }

    public  List<BookEntity> findAll() {
        return (List<BookEntity>) bookRepository.findAll();
    }

    public  void addBook(BookEntity book, BookDetailsEntity bookDetails) {

        bookRepository.addBook(book.getName(),book.getAuthor(),book.getCategory().getId());
        bookRepository.addBookDetails(bookDetails.getIsbn(), bookDetails.getNumberOfPage(), bookDetails.getPrice(), bookDetails.getPublishDate());
    }

    public  List<BookEntity> findByNameOrAuthor(String searchInput, String searchInput1) {
        return bookRepository.findByNameOrAuthor(searchInput,searchInput1);
    }
    public  void deleteBookById(int id){
        bookRepository.removeBookDetailById(id);
        bookRepository.deleteById(id);
        bookRepository.removeRedundancyBookId();;
        bookRepository.removeRedundancyBookDetailsId();
    }
}
