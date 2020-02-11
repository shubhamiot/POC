package com.cg.pizza.delivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.pizza.delivery.model.Pizza;
import com.cg.pizza.delivery.repository.PizzaRepository;
 
@Service
@Transactional
public class PizzaService {
 
    @Autowired
    private PizzaRepository prepo;
     
    public List<Pizza> listAll() {
        return prepo.findAll();
    }
     
    public void save(Pizza pizza) {
        prepo.save(pizza);
    }
     
    public Pizza get(long id) {
        return prepo.findOne(id);
    }
     
    public void delete(long id) {
       prepo.delete(id);
    }
}