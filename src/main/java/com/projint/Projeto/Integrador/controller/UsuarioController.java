/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projint.Projeto.Integrador.controller;

import com.projint.Projeto.Integrador.model.Usuario;
import com.projint.Projeto.Integrador.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UsuarioRepository usuarioRepository;

    /*@GetMapping("/cadastro")
    public String exibirFormulario() {
    return "cadastro"; // Nome do template HTML
    }
     */
    @PostMapping("/cadastroLogin")
    public String processarFormulario(@ModelAttribute Usuario usuario) {
        // Define o tipo como "Técnico"
        usuario.setTipo("Técnico");

        // Lógica para salvar o usuário no banco de dados (usando JPA/Hibernate ou JDBC)
        usuarioRepository.save(usuario); // Certifique-se de ter o repositório configurado

        // Redireciona para uma página de sucesso
        return "redirect:/login";
    }
}
