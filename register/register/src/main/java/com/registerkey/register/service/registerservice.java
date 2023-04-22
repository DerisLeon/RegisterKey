package com.registerkey.register.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.registerkey.register.model.registermodel;
import com.registerkey.register.model.responsemodel;
import com.registerkey.register.repository.registerrepository;

@Service
public class registerservice{
    
    @Autowired
    private registerrepository rr;

    @Autowired
    private responsemodel rpm;


    //Listar Todos os Registros
    public Iterable<registermodel> listar(){
        return rr.findAll();
    }

    //Inserir Registros
    public ResponseEntity<?> cadastrar(registermodel rm){

        if(rm.getMatricula().equals("")){
            rpm.setMensagem("A matrícula é obrigatória!");
            return new ResponseEntity<responsemodel>(rpm, HttpStatus.BAD_REQUEST);

        }else if(rm.getSolicitante().equals("")){
            rpm.setMensagem("Seu nome é obrigatório!");
            return new ResponseEntity<responsemodel>(rpm, HttpStatus.BAD_REQUEST);

        }else{
            return new ResponseEntity<registermodel>(rr.save(rm), HttpStatus.CREATED);
        }

    }

    //Remover Registros
    public ResponseEntity<responsemodel> remover(long id){
        rr.deleteById(id);
        rpm.setMensagem("O registro foi removido com sucesso!");
        return new ResponseEntity<responsemodel>(rpm, HttpStatus.OK);
    }
}
