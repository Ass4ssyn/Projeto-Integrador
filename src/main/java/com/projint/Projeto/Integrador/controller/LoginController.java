/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projint.Projeto.Integrador.controller;

/**
 *
 * @author cirol
 */
import com.projint.Projeto.Integrador.model.Usuario;
import com.projint.Projeto.Integrador.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Controller
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @PostMapping("/login")
    public String processarLogin(
            @RequestParam String login,
            @RequestParam String senha,
            Model model) {

        // Converte a senha para MD5
        String senhaHash = hashMD5(senha);

        // Verifica se o login e senha são válidos
        Usuario usuario = usuarioRepository.findByLoginAndSenha(login, senhaHash);

        if (usuario != null) {
            // Login bem-sucedido
            return "redirect:/listaEntrega";
        } else {
            // Login falhou
            model.addAttribute("erro", "Login ou senha inválidos!");
            return "login";
        }
    }

    private String hashMD5(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(senha.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao gerar hash MD5", e);
        }
    }

}

