/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projint.Projeto.Integrador.controller;

/*   
<<<<<<< HEAD

=======
 
>>>>>>> 42f385a1c8f00ce0f5a723f248a5f14c6d14e280
 * @author cirol
 */
import com.projint.Projeto.Integrador.model.Estoque;
import com.projint.Projeto.Integrador.model.Material;
import com.projint.Projeto.Integrador.model.Obra;
import com.projint.Projeto.Integrador.repository.EstoqueRepository;
import com.projint.Projeto.Integrador.repository.MaterialRepository;
import com.projint.Projeto.Integrador.repository.ObraRepository;
import com.projint.Projeto.Integrador.service.MaterialService;
import com.projint.Projeto.Integrador.service.ObraService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EstoqueController {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private ObraRepository obraRepository;

    @Autowired
    private ObraService obraService;

    @Autowired
    private MaterialService materialService;

    @PostMapping("/estoque/atualizar")
    public String atualizarEstoque(
            @RequestParam Integer id,
            @RequestParam Integer materialId,
            @RequestParam Double quantidadeEstoque,
            @RequestParam Integer obraId,
            RedirectAttributes redirectAttributes) {

        Estoque estoque = estoqueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estoque não encontrado"));

        Material material = materialRepository.findById(materialId)
                .orElseThrow(() -> new RuntimeException("Material não encontrado"));

        Obra obra = obraRepository.findById(obraId)
                .orElseThrow(() -> new RuntimeException("Obra não encontrada"));

        estoque.setMaterial(material);
        estoque.setQuantidadeEstoque(quantidadeEstoque);
        estoque.setObra(obra);

        estoqueRepository.save(estoque);
        redirectAttributes.addFlashAttribute("sucesso", "Estoque atualizado com sucesso!");

        return "redirect:/estoque";
    }

    @GetMapping("/estoque/deletar/{id}")
    public String deletarEstoque(@PathVariable Integer id) {
        estoqueRepository.deleteById(id);
        return "redirect:/estoque"; // Redireciona para a lista de estoques
    }

}
