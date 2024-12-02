/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projint.Projeto.Integrador.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author cirol
 */
@Entity
@Table(name = "Obra")
public class Obra {

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the nomeProprietario
     */
    public String getNomeProprietario() {
        return nomeProprietario;
    }

    /**
     * @param nomeProprietario the nomeProprietario to set
     */
    public void setNomeProprietario(String nomeProprietario) {
        this.nomeProprietario = nomeProprietario;
    }

    /**
     * @return the nomeRuaObra
     */
    public String getNomeRuaObra() {
        return nomeRuaObra;
    }

    /**
     * @param nomeRuaObra the nomeRuaObra to set
     */
    public void setNomeRuaObra(String nomeRuaObra) {
        this.nomeRuaObra = nomeRuaObra;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nome_Proprietario", nullable = false)
    private String nomeProprietario;

    @Column(name = "Nome_Rua_Obra", nullable = false)
    private String nomeRuaObra;

    // Getters, Setters, e Construtores
}
