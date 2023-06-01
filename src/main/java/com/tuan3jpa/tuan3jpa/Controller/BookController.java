package com.tuan3jpa.tuan3jpa.Controller;



//import ch.qos.logback.core.model.Model;
import com.tuan3jpa.tuan3jpa.entity.Book;
import com.tuan3jpa.tuan3jpa.entity.Category;
import com.tuan3jpa.tuan3jpa.services.BookService;
import com.tuan3jpa.tuan3jpa.services.CategoryService;
import jakarta.validation.Valid;
import org.hibernate.dialect.function.SybaseTruncFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;
//@RequestMapping("/books")
@Controller
public class BookController {
    @Autowired
        private BookService bookService;
    @Autowired
    private CategoryService categoryService;
//        @Autowired
//        private   BookService bookService;
    @GetMapping("/books")
    public String showAllBooks(Model model){
        List<Book> books= bookService.getALLBooks();
          model.addAttribute("books",books);
          return "book/list";
        }

    @GetMapping("/add")
    public String addBookForm(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("categories",categoryService.getAllCaterories());
        return "book/add";
    }


    @PostMapping("/add")
    public String addBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult, Model model){
//        bookService.addBook(book);
        if(bindingResult.hasErrors()){
            model.addAttribute("categories",categoryService.getAllCaterories());
            return "book/add";
        }
        bookService.addBook(book);
        return "redirect:/books";
    }


    @GetMapping("/delete/{id}")
    public  String deleteBook(@PathVariable("id") Long id) {
        Book book = bookService.getBookById(id);
        if (book != null) {
            bookService.deleteBook(id);
            return  "redirect:/";
        } else {
            return "redirect:/";
        }
    }
    @GetMapping("/edit/{id}")
    public String showEditBookForm(@PathVariable("id") Long id, Model model) {
        Book book = bookService.getBookById(id);
        List<Category> categories = categoryService.getAllCaterories();

        model.addAttribute("book", book);
        model.addAttribute("categories", categories);

        return "book/edit";
    }
//    @PostMapping("/edit/{id}")
//    public String updateBook(@PathVariable("id") Long id, @ModelAttribute("book") Book book) {
//
//        bookService.updateBook(id, book);
//
//        return "redirect:/";
//    }

        @PostMapping("edit")
        public String update(@ModelAttribute("book") Book book, Model model){
            bookService.updateBook(book);
            return "redirect:/";
        }
}
