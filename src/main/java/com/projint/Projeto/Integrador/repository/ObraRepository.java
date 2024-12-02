/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.projint.Projeto.Integrador.repository;

/**
 *
 * @author cirol
 */
import com.projint.Projeto.Integrador.model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projint.Projeto.Integrador.model.Obra;
import java.util.List;

@Repository
public interface ObraRepository extends JpaRepository<Obra, Integer> {

}
