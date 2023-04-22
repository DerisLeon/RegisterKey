package com.registerkey.register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.registerkey.register.model.registermodel;
import com.registerkey.register.model.responsemodel;
import com.registerkey.register.service.registerservice;

@RestController
@CrossOrigin(origins = "*")
public class registercontroller {
    
    @Autowired registerservice rs;

 
    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody registermodel rm){
        return rs.cadastrar(rm);
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody registermodel rm){
        return rs.cadastrar(rm);
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<responsemodel> remover(@PathVariable long id){
        return rs.remover(id);
    }

    @GetMapping("/listar")
    public Iterable<registermodel> listar(){
        return rs.listar();
    }

    @GetMapping("/")
    public String rota(){
        return "Está funcionando";
    }


    


}
