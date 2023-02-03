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
    static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    static BookRepository bookRepository = (BookRepository) context.getBean("bookRepository");
    @Autowired
    static CategoryRepository categoryRepository = (CategoryRepository) context.getBean("categoryRepository");
    public static List<CategoryEntity> findAllCategory(){
        List<CategoryEntity> categoryEntityList = (List<CategoryEntity>) categoryRepository.findAll();
        return categoryEntityList;
    }

}
