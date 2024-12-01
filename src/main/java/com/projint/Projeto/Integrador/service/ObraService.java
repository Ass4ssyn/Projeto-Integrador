/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projint.Projeto.Integrador.service;

import com.projint.Projeto.Integrador.model.Obra;
import com.projint.Projeto.Integrador.repository.ObraRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author cirol
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ObraService {

    @Autowired
    private ObraRepository obraRepository;

    @Autowired
    public ObraService(ObraRepository obraRepository) {
        this.obraRepository = obraRepository;
    }

    // Método para buscar todas as obras
    public List<Obra> buscarTodas() {
        return obraRepository.findAll();
    }

    // Outros métodos (salvar, deletar, buscar por ID, etc.)
    public Obra salvar(Obra obra) {
        return obraRepository.save(obra);
    }

    public void deletar(int id) {
        obraRepository.deleteById(id);
    }

    public Obra buscarPorId(int id) {
        return obraRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Obra não encontrada!"));
    }
}
