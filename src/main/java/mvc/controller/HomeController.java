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

    @Autowired
    HomeService homeService;
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String listBooks(Model model){
        List<BookEntity> bookEntityList=  homeService.findAll();
        model.addAttribute("list", bookEntityList);
        return "home";
    }
    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable int id){
        homeService.deleteBookById(id);
        return "redirect:/";
    }
    @RequestMapping(value="/update/{id}", method = RequestMethod.GET)
    public String updateBook(@PathVariable int id,
                             Model model){
        setCategoryDropDownList(model);
        if (model.containsAttribute("book"))

            return "update";

        BookEntity bookEntity= homeService.findById(id);
        model.addAttribute("book",bookEntity);
        return "update";
    }
    @RequestMapping(value="update/process-update", method = RequestMethod.POST)
    public String updateBook(@Valid @ModelAttribute("book") BookEntity book,
                             BindingResult bookResult,
                             RedirectAttributes redirectAttributes){
        if (bookResult.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.book", bookResult);
            redirectAttributes.addFlashAttribute("book", book);
            return "redirect:/update/"+book.getId();
        }
        System.out.println(book.toString());
        homeService.updateBook(book);

        return "redirect:/";
    }
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@RequestParam(name = "searchInput") String searchInput, Model model){
        List<BookEntity> resultList;
        if(searchInput.isEmpty()){
            resultList= (List<BookEntity>) homeService.findAll();
        }else{
            resultList= homeService.findByNameOrAuthor(searchInput, searchInput);
        }
        model.addAttribute("list", resultList);
        return "home";
    }

    @GetMapping(path = "/add")
    public String showAddForm(Model model){

        model.addAttribute("book", new BookEntity());
        setCategoryDropDownList(model);
        return "add";
    }
    @RequestMapping(value = "/process-add", method = RequestMethod.POST)
    public String addBook(@Valid @ModelAttribute("book") BookEntity book,
                          BindingResult bookResult,
                          RedirectAttributes redirectAttributes,
                          Model model){
        System.out.println(book.toString());
        if (bookResult.hasErrors()){
            setCategoryDropDownList(model);

            return "add";
        }
        homeService.addBook(book, book.getBookDetails());
        return "redirect:/";
    }
    private void setCategoryDropDownList(Model model) {
        List<CategoryEntity> categoryEntityList = homeService.findAllCategory();
        if (!categoryEntityList.isEmpty()) {
            Map<Integer, String> cateMap = new LinkedHashMap<>();
            for (CategoryEntity category : categoryEntityList)
                cateMap.put(category.getId(), category.getName());
            model.addAttribute("categoryList", cateMap);
        }
    }
}
