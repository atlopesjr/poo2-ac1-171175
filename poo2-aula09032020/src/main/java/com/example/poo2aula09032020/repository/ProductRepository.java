package com.example.poo2aula09032020.repository;

import java.util.HashMap;

import com.example.poo2aula09032020.model.Product;

import org.springframework.stereotype.Repository;

/**
 * ProductRepository
 */
@Repository
public class ProductRepository {
    public HashMap<Integer, Product> hm = new HashMap<Integer, Product>();
    
    public ProductRepository(){
        hm.put(1, new Product(1, "Camiseta Azul", 200.30, 1));
        hm.put(2, new Product(2, "Camiseta Branca", 10.30, 0));
        hm.put(3, new Product(3, "Camiseta Verde", 30.40, 3));
        hm.put(4, new Product(4, "Camiseta Rosa", 50.30, 2));
        hm.put(5, new Product(5, "Camiseta Preta", 70.20, 5));
        hm.put(6, new Product(6, "Camiseta Lilas", 200.10, 12));
        hm.put(7, new Product(7, "Camiseta Pink", 250.80, 17));
        hm.put(8, new Product(8, "Camiseta Vinho", 230.50, 16));
        hm.put(9, new Product(9, "Camiseta Marrom", 220.90, 15));
        hm.put(10, new Product(10, "Camiseta Dourada", 1000.30, 13));
    }

    public Product getProductById(int id){
        return hm.get(id);
    }

    public HashMap<Integer, Product> getProdutos(){
        return hm;    
    }
}