/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projint.Projeto.Integrador.controller;

import com.projint.Projeto.Integrador.model.Material;
import com.projint.Projeto.Integrador.repository.EntregaRepository;
import com.projint.Projeto.Integrador.repository.EstoqueRepository;
import com.projint.Projeto.Integrador.repository.MaterialRepository;
import com.projint.Projeto.Integrador.repository.ObraRepository;
import com.projint.Projeto.Integrador.service.MaterialService;
import com.projint.Projeto.Integrador.service.ObraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author cirol
 */
@Controller
@RequestMapping("/material") 
public class MaterialController {
    @Autowired
    private EntregaRepository entregaRepository;

    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private ObraRepository obraRepository;

    @Autowired
    private ObraService obraService;

    @Autowired
    private MaterialService materialService;
    
    @PostMapping("/salvar")
public String salvarMaterial(@ModelAttribute Material material) {
    materialRepository.save(material);
    return "redirect:/listaEntrega";
}

}
