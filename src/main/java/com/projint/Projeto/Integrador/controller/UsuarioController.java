/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projint.Projeto.Integrador.controller;

import com.projint.Projeto.Integrador.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author cirol
 */
@Controller
public class UsuarioController {

    /*@GetMapping("/cadastro")
    public String exibirFormulario() {
    return "cadastro"; // Nome do template HTML
    }
    
    @PostMapping("/cadastro")
    public String processarFormulario(@ModelAttribute Usuario usuario) {
    // Lógica de processamento
    return "redirect:/sucesso"; // Redireciona para uma página de sucesso
    }*/
}
