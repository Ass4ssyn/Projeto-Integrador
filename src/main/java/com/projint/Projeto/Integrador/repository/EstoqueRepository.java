/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projint.Projeto.Integrador.repository;

/**
 *
 * @author cirol
 */
import com.projint.Projeto.Integrador.model.Estoque;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Integer> {
    List<Estoque> findByObra_Id(Integer obraId);
    
    Optional<Estoque> findByMaterialIdAndObraId(Long materialId, Long obraId);
    List<Estoque> findByObra_NomeProprietarioContainingIgnoreCaseOrObra_NomeRuaObraContainingIgnoreCase(String nomeProprietario, String nomeRuaObra);


}
