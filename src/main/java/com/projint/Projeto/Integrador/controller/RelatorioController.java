/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projint.Projeto.Integrador.controller;

/**
 *
 * @author cirol
 */
import com.projint.Projeto.Integrador.model.Estoque;
import com.projint.Projeto.Integrador.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RelatorioController {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @GetMapping("/relatorioUso/{id}")
    public String exibirRelatorioUso(@PathVariable Integer id, Model model) {
        // Obter o estoque com base no ID
        Estoque estoque = estoqueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estoque não encontrado"));

        // Adicionar o estoque ao modelo para exibir no relatório
        model.addAttribute("estoque", estoque);

        // Retornar a página de relatório
        return "relatorioUso";
    }

    @PostMapping("/relatorioUso")
    public String emitirRelatorioUso(@RequestParam Integer id, @RequestParam Double quantidadeUsada, RedirectAttributes redirectAttributes) {
        // Buscar o estoque pelo ID
        Estoque estoque = estoqueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estoque não encontrado"));

        // Verificar se há quantidade suficiente no estoque
        if (quantidadeUsada > estoque.getQuantidadeEstoque()) {
            redirectAttributes.addFlashAttribute("erro", "Quantidade usada excede o estoque disponível.");
            return "redirect:/relatorioUso/" + id;
        }

        // Atualizar a quantidade no estoque
        estoque.setQuantidadeEstoque(estoque.getQuantidadeEstoque() - quantidadeUsada);
        estoqueRepository.save(estoque);

        // Redirecionar para a página de estoque com uma mensagem de sucesso
        redirectAttributes.addFlashAttribute("sucesso", "Relatório emitido com sucesso!");
        return "redirect:/estoque";
    }
}
