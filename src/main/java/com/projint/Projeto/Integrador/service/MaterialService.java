/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projint.Projeto.Integrador.service;

/**
 *
 * @author cirol
 */
import com.projint.Projeto.Integrador.model.Material;
import com.projint.Projeto.Integrador.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    public MaterialService(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    // Método para buscar todos os materiais
    public List<Material> buscarTodos() {
        return materialRepository.findAll();
    }

    // Outros métodos (salvar, deletar, buscar por ID, etc.)
    public Material salvar(Material material) {
        return materialRepository.save(material);
    }

    public void deletar(int id) {
        materialRepository.deleteById(id);
    }

    public Material buscarPorId(int id) {
        return materialRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Material não encontrado!"));
    }
}
