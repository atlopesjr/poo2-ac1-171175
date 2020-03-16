package com.example.poo2aula09032020.controller;

import java.util.HashMap;

import com.example.poo2aula09032020.model.Product;
import com.example.poo2aula09032020.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;


/**
 * ProductController
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService ps;

    @GetMapping("")
    public ModelAndView getProducts() {
        HashMap <Integer, Product> products = ps.getProducts();
        ModelAndView mv = new ModelAndView("products");

        mv.addObject("products", products);
        return mv;
    }

    @GetMapping("/{productId}")
    public ModelAndView getById(@PathVariable("productId") int productId){
        Product product = ps.getProductById(productId);
        ModelAndView mv = new ModelAndView("product_byid");

        mv.addObject("product", product);
        return mv;
    }

    @GetMapping("/instock")
    public ModelAndView getInStock(){
        HashMap<Integer, Product> products = ps.getProductInStock();
        ModelAndView mv = new ModelAndView("products_instock");

        mv.addObject("products", products);
        return mv;
    }

    @GetMapping("/above/{value}")
    public ModelAndView getAboveValue(@PathVariable("value") double value){
        HashMap<Integer, Product> products = ps.getProductByValueAbove(value);
        ModelAndView mv = new ModelAndView("products_above_value");

        mv.addObject("products", products);
        return mv;
    }

    @GetMapping("/below/{value}")
    public ModelAndView getBelowValue(@PathVariable("value") double value){
        HashMap<Integer, Product> products = ps.getProductByValueBelow(value);
        ModelAndView mv = new ModelAndView("products_below_value");

        mv.addObject("products", products);
        return mv;
    }
}