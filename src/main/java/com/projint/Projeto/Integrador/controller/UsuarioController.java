/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projint.Projeto.Integrador.controller;

import com.projint.Projeto.Integrador.model.Usuario;
import com.projint.Projeto.Integrador.repository.UsuarioRepository;
import java.security.NoSuchAlgorithmException;
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
    try {
        // Criptografa a senha com MD5
        String senhaCriptografada = PasswordUtil.gerarMD5(usuario.getSenha());
        usuario.setSenha(senhaCriptografada); // A senha criptografada será salva no banco
        
        // Define o tipo como "Técnico"
        usuario.setTipo("Técnico");

        // Salva o usuário no banco de dados
        usuarioRepository.save(usuario);

    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
        // Em caso de erro, trate a exceção apropriadamente
    }

    // Redireciona para uma página de sucesso
    return "redirect:/login";
}
}
