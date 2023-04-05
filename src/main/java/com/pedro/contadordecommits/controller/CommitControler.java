package com.pedro.contadordecommits.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedro.contadordecommits.entity.Commit;
import com.pedro.contadordecommits.service.CommitService;

@RestController
@RequestMapping("/commit")
@CrossOrigin
public class CommitControler {
    
    @Autowired
    private CommitService commitService;

    @GetMapping
    public List<Commit> listarTodos() {
        return commitService.listarTodos();
    }

    @DeleteMapping
    public void excluir(@PathVariable("id") Long id) {
        commitService.exlcuir(id);
    }
}
