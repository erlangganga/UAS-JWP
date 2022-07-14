package com.example.libr.controllers;

import com.example.libr.entities.category;
import com.example.libr.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings({"unused", "SpringJavaAutowiredFieldsWarningInspection"})
@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("title", "Master Category");
        model.addAttribute("category", categoryRepository.findAll());


        return "category/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        category category = categoryRepository.findById(id).orElseThrow(() ->
            new IllegalArgumentException("Invalid Category Id" + id)
	        );

        model.addAttribute("title", "Edit Category");
        model.addAttribute("category", category);

        return "category/form";
    }

    @PostMapping("/Save")
    public String save(category category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "category/form";
        }

        CategoryRepository.Save(category);

        return "redirect:/category";
    }

    @GetMapping("/add")
    public String add(category category, Model model) {
        model.addAttribute("title", "add Category");


        return "category/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model) {
        category category = categoryRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Invalid Category Id" + id)
        );

        categoryRepository.delete(category);


        return "redirect:/categories";
    }

}