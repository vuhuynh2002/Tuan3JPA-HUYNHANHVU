package com.tuan3jpa.tuan3jpa.Controller;


import com.tuan3jpa.tuan3jpa.entity.Book;
import com.tuan3jpa.tuan3jpa.entity.Category;
import com.tuan3jpa.tuan3jpa.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/listcate")
    public String showcate(Model model){
        List<Category> categoryList =categoryService.getAllCaterories();
        model.addAttribute("categoryList",categoryList);
        return "category/listcategory";
    }

    @GetMapping("/addcate")
    public String addCategoryForm(Model model){
        model.addAttribute("category", new Category());
//        model.addAttribute("categories",categoryService.getAllCaterories());
        return "category/addcategory";
    }

    @PostMapping("/addcate")
    public String addBook(@Valid @ModelAttribute("category") Category category, BindingResult bindingResult, Model model){
        categoryService.addcategory(category);

        categoryService.addcategory(category);
        return "redirect:/books";
    }

    @GetMapping("/deletecate/{id}")
    public  String deleteCategory(@PathVariable("id") Long id) {
        Category category=categoryService.getCategoryById(id);

        if (category != null) {
            // Nếu tìm thấy Book với Id tương ứng, xoá Book này
            categoryService.deleteCategory(id);
            return  "redirect:/";
        } else {
            // Nếu không tìm thấy Book nào với Id tương ứng, trả về HTTP Status 404 Not Found
            return "redirect:/";
        }




    }
}
