package com.pedro.contadordecommits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.contadordecommits.entity.Commit;
import com.pedro.contadordecommits.repository.CommitRepository;

@Service
public class CommitService {
    
    @Autowired
    private CommitRepository commitRepository;

    public List<Commit> listarTodos() {
        return commitRepository.findAll();
    }

    public Commit salvar(Commit commit) {
        return commitRepository.saveAndFlush(commit);
    }

    public Commit atualizar(Commit commit) {
        return commitRepository.saveAndFlush(commit);
    }

    public void exlcuir(Long id) {
        Commit commit = commitRepository.findById(id).get();
        commitRepository.delete(commit);
    }

}
