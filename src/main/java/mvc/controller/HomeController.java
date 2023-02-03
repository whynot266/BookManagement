package mvc.controller;

import mvc.entity.BookEntity;
import mvc.entity.CategoryEntity;
import mvc.repository.CategoryRepository;
import mvc.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import mvc.repository.BookRepository;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller

public class HomeController {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String listBooks(Model model){
        List<BookEntity> bookEntityList= (List<BookEntity>) bookRepository.findAll();
        model.addAttribute("list", bookEntityList);
        return "home";
    }
    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable int id){
        bookRepository.deleteById(id);
        return "redirect:/";
    }
    @RequestMapping(value="/update/{id}", method = RequestMethod.GET)
    public String updateBook(@PathVariable int id,

                             Model model){
        model.addAttribute("book", new BookEntity());
        setCategoryDropDownList(model);
        BookEntity bookEntity= bookRepository.findById(id).get();
        model.addAttribute("updatedBook",bookEntity);

        return "update";
    }
    @RequestMapping(value="/process-update", method = RequestMethod.POST)
    public String updateBook(@ModelAttribute("book") BookEntity book,
                             BindingResult bookResult){
        if (bookResult.hasErrors()){
            System.out.println("error");
            return "redirect:/process-update";
        }
        BookEntity bookEntity= bookRepository.findById(book.getId()).get();
        bookEntity.setName(book.getName());
        bookEntity.setAuthor(book.getAuthor());
        bookEntity.setBookDetails(book.getBookDetails());
        bookEntity.setCategory(book.getCategory());
        bookRepository.save(bookEntity);
        return "redirect:/";
    }
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@RequestParam(name = "searchInput") String searchInput, Model model){
        List<BookEntity> resultList;
        if(searchInput.isEmpty()){
            resultList= (List<BookEntity>) bookRepository.findAll();
        }else{
            resultList= bookRepository.findByNameOrAuthor(searchInput, searchInput);
        }
        model.addAttribute("list", resultList);
        return "home";
    }

    @GetMapping(path = "/add")
    public String showAddForm(Model model){
        if (!model.containsAttribute("book"))
            model.addAttribute("book", new BookEntity());
        setCategoryDropDownList(model);
        return "add";
    }
    @RequestMapping(value = "/process-add", method = RequestMethod.POST)
    public String addBook(@Valid @ModelAttribute("book") BookEntity book,
                          BindingResult bookResult
                          ){
        System.out.println(book.toString());
        if (bookResult.hasErrors()){
            System.out.println("error");
            return "redirect:/add";
        }
        bookRepository.save(book);
        return "redirect:/";
    }
    private void setCategoryDropDownList(Model model) {
        List<CategoryEntity> categoryEntityList = HomeService.findAllCategory();
        if (!categoryEntityList.isEmpty()) {
            Map<Integer, String> cateMap = new LinkedHashMap<>();
            for (CategoryEntity category : categoryEntityList)
                cateMap.put(category.getId(), category.getName());
            model.addAttribute("categoryList", cateMap);
        }
    }
}
