package com.example.poo2aula09032020.service;

import java.util.HashMap;

import com.example.poo2aula09032020.model.Product;
import com.example.poo2aula09032020.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ProductService
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository pr;

    public HashMap<Integer, Product> getProducts(){
    
        HashMap<Integer, Product> products = pr.getProdutos();

        if(products != null){
            return products;
        }

        return null;
    }

    public Product getProductById(int id){
        Product product = pr.getProductById(id);

        if(product == null){
            throw new RuntimeException("ID invalido!");
        }
        return product;
    }

    public HashMap<Integer, Product> getProductInStock(){
        HashMap<Integer, Product> prodinstock = new HashMap<>();
        HashMap<Integer, Product> products = pr.getProdutos();
        
        for(int i = 1; i <= products.size(); i++){
            if(products.get(i).getEstoque() > 0){
                prodinstock.put(i, products.get(i));
            }
        }
        return prodinstock;
    }

    public HashMap<Integer, Product> getProductByValueAbove(double value){
        HashMap<Integer, Product> prodabv = new HashMap<>();
        HashMap<Integer, Product> products = pr.getProdutos();
        if(value < 0){
            throw new RuntimeException("Valor deve ser maior que zero!");
        }

        for(int i = 1; i <= products.size(); i++){
            if(products.get(i).getValor() > value){
                prodabv.put(i, products.get(i));
            }
        }
        return prodabv;
    }

    public HashMap<Integer, Product> getProductByValueBelow(double value){
        HashMap<Integer, Product> prodblw = new HashMap<>();
        HashMap<Integer, Product> products = pr.getProdutos();
        if(value < 0){
            throw new RuntimeException("Valor deve ser maior que zero!");
        }

        for(int i = 1; i <= products.size(); i++){
            if(products.get(i).getValor() < value){
                prodblw.put(i, products.get(i));
            }
        }
        return prodblw;
    }

}