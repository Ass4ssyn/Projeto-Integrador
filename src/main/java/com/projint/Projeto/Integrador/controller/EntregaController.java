/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projint.Projeto.Integrador.controller;

/**
 *
 * @author cirol
 */
import com.projint.Projeto.Integrador.model.Entrega;
import com.projint.Projeto.Integrador.model.Estoque;
import com.projint.Projeto.Integrador.model.Material;
import com.projint.Projeto.Integrador.model.Obra;
import com.projint.Projeto.Integrador.repository.EntregaRepository;
import com.projint.Projeto.Integrador.repository.EstoqueRepository;
import com.projint.Projeto.Integrador.repository.MaterialRepository;
import com.projint.Projeto.Integrador.repository.ObraRepository;
import com.projint.Projeto.Integrador.service.MaterialService;
import com.projint.Projeto.Integrador.service.ObraService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/entrega")
public class EntregaController {

    @Autowired
    private EntregaRepository entregaRepository;

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private ObraRepository obraRepository;

    @Autowired
    private MaterialService materialService;

    @Autowired
    private ObraService obraService;

    /**
     * Exibe o formulário para cadastro de entregas.
     *
     * @param model
     * @return
     */
    /**
     * Processa o formulário de cadastro de entregas.
     *
     * @param materialId
     * @param quantidade
     * @param dataRecebimento
     * @param obraId
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/cadastrar")
    public String cadastrarEntrega(
            @RequestParam Integer materialId,
            @RequestParam Double quantidade,
            @RequestParam String dataRecebimento, // Recebe como String para facilitar o parsing
            @RequestParam Integer obraId,
            RedirectAttributes redirectAttributes) {

        try {
            // Buscar material e obra
            Material material = materialRepository.findById(materialId)
                    .orElseThrow(() -> new RuntimeException("Material não encontrado"));
            Obra obra = obraRepository.findById(obraId)
                    .orElseThrow(() -> new RuntimeException("Obra não encontrada"));

            // Criar entrega
            Entrega entrega = new Entrega();
            entrega.setMaterial(material);
            entrega.setQuantidadeEntrega(quantidade);
            entrega.setDataRecebimento(LocalDate.parse(dataRecebimento)); // Converter data
            entrega.setObra(obra);

            entregaRepository.save(entrega);
            redirectAttributes.addFlashAttribute("sucesso", "Entrega cadastrada com sucesso!");

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Erro ao cadastrar entrega: " + e.getMessage());
        }

        return "redirect:/cadastro";
    }

    /**
     * Lista todas as entregas.
     *
     * @param model
     * @return
     */
    /*@GetMapping("/listar")
    public String listarEntregas(Model model) {
    List<Entrega> entregas = entregaRepository.findAll();
    model.addAttribute("entregas", entregas);
    return "listaEntrega"; // Página para listar as entregas
    }*/
    /**
     * Confirma a entrega e adiciona ao estoque.
     *
     * @param id
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/confirmarEntrega/{id}")
    public String confirmarEntrega(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        try {
            // Buscar a entrega pelo ID
            Entrega entrega = entregaRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Entrega não encontrada"));

            // Verificar se o material já existe no estoque para a mesma obra
            Estoque estoque = estoqueRepository.findByMaterialIdAndObraId(
                    entrega.getMaterial().getId(),
                    entrega.getObra().getId()
            ).orElse(null);

            if (estoque != null) {
                // Atualizar quantidade do estoque existente
                estoque.setQuantidadeEstoque(estoque.getQuantidadeEstoque() + entrega.getQuantidadeEntrega());
            } else {
                // Criar novo registro no estoque
                estoque = new Estoque();
                estoque.setMaterial(entrega.getMaterial());
                estoque.setQuantidadeEstoque(entrega.getQuantidadeEntrega());
                estoque.setObra(entrega.getObra());
            }

            // Salvar as alterações no estoque
            estoqueRepository.save(estoque);

            // Excluir a entrega
            entregaRepository.delete(entrega);

            redirectAttributes.addFlashAttribute("sucesso", "Entrega confirmada e adicionada ao estoque!");

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Erro ao confirmar entrega: " + e.getMessage());
        }

        return "redirect:/cadastro";
    }

    @PostMapping("/atualizar")
    public String atualizarEntrega(
            @RequestParam Integer id,
            @RequestParam Integer materialId,
            @RequestParam Double quantidade,
            @RequestParam String dataRecebimento,
            @RequestParam Integer obraId,
            RedirectAttributes redirectAttributes) {

        Entrega entrega = entregaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrega não encontrada"));

        Material material = materialRepository.findById(materialId)
                .orElseThrow(() -> new RuntimeException("Material não encontrado"));

        Obra obra = obraRepository.findById(obraId)
                .orElseThrow(() -> new RuntimeException("Obra não encontrada"));

        entrega.setMaterial(material);
        entrega.setQuantidadeEntrega(quantidade);
        entrega.setDataRecebimento(LocalDate.parse(dataRecebimento));
        entrega.setObra(obra);

        entregaRepository.save(entrega);
        redirectAttributes.addFlashAttribute("sucesso", "Entrega atualizada com sucesso!");

        return "redirect:/listaEntrega";
    }

    @GetMapping("/deletar/{id}")
    public String deletarEntrega(@PathVariable Integer id) {
        entregaRepository.deleteById(id);
        return "redirect:/listaEntrega"; // Redireciona para a lista de entregas
    }
}
