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

            categoryService.deleteCategory(id);
            return  "redirect:/";
        } else {

            return "redirect:/listcase";
        }
    }



    @GetMapping("/editcate/{id}")
    public String showEditBookForm(@PathVariable("id") Long id, Model model) {
        Category category = categoryService.getCategoryById(id);


        model.addAttribute("category", category);


        return "category/editcategory";
    }
    @PostMapping("/editcate")
    public String update(@ModelAttribute("category") Category category, Model model){
        categoryService.updateCate(category);
        return "redirect:/listcate";
    }


}
