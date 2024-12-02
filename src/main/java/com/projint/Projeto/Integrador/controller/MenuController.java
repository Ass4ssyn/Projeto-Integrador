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
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MenuController {

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

    @GetMapping("/cadastro")
    public String exibirFormulario(Model model) {
        try {
            List<Material> materiais = materialService.buscarTodos();
            List<Obra> obras = obraService.buscarTodas();

            model.addAttribute("materiais", materiais);
            model.addAttribute("obras", obras);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "cadastroEntrega";
    }

    @GetMapping("/listaEntrega")
    public String listaEntregas(Model model) {
        model.addAttribute("entregas", entregaRepository.findAll());
        return "listaEntrega";
    }
    
    @GetMapping("/obra/cadastro")
    public String cadastroObra(Model model) {
        return "cadastroObra";
    }
    
    @GetMapping("/material/cadastro")
    public String cadastroMaterial(Model model) {
        return "cadastroMaterial";
    }
    
    @GetMapping("/login")
    public String Login(Model model) {
        return "login";
    }
    
    @GetMapping("/cadastro-login")
    public String cadastroUser(Model model) {
        return "cadastroUsuario";
    }

    @GetMapping("/estoque")
public String consultarEstoque(
        @RequestParam(required = false) String filtro, // Para nome do proprietário ou rua
        Model model) {

    List<Estoque> estoques;

    if (filtro != null && !filtro.isEmpty()) {
        // Busca pelo nome do proprietário ou nome da rua da obra
        estoques = estoqueRepository.findByObra_NomeProprietarioContainingIgnoreCaseOrObra_NomeRuaObraContainingIgnoreCase(filtro, filtro);
    } else {
        // Retorna todos os estoques
        estoques = estoqueRepository.findAll();
    }

    model.addAttribute("estoques", estoques);
    model.addAttribute("obras", obraRepository.findAll()); // Para exibir todas as obras
    model.addAttribute("filtro", filtro); // Para manter o filtro no formulário
    return "listaEstoque";
}

    @GetMapping("/")
    public String menuPrincipal() {
        return "menuPrincipal";  // A página do menu principal
    }

    @GetMapping("/entrega/editar/{id}")
    public String exibirFormularioEdicaoEntrega(@PathVariable Integer id, Model model) {
        Entrega entrega = entregaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrega não encontrada"));

        // Busque as listas de materiais e obras
        List<Material> materiais = materialService.buscarTodos();
        List<Obra> obras = obraService.buscarTodas();

        // Adicione os dados ao modelo
        model.addAttribute("entrega", entrega);
        model.addAttribute("materiais", materiais);
        model.addAttribute("obras", obras);

        return "editarEntrega";
    }

    @GetMapping("/estoque/editar/{id}")
    public String exibirFormularioEdicaoEstoque(@PathVariable Integer id, Model model) {
        Estoque estoque = estoqueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estoque não encontrado"));

        // Busque as listas de materiais e obras
        List<Material> materiais = materialService.buscarTodos();
        List<Obra> obras = obraService.buscarTodas();

        // Adicione os dados ao modelo
        model.addAttribute("estoque", estoque);
        model.addAttribute("materiais", materiais);
        model.addAttribute("obras", obras);

        return "editarEstoque";
    }

    
}
