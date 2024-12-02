/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projint.Projeto.Integrador.model;

/**
 *
 * @author cirol
 */
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Material_Id", nullable = false)
    private Material material;

    @Column(name = "Quantidade_Entrega", nullable = false)
    private double quantidadeEntrega;

    @Column(name = "Data_Recebimento", nullable = false)
    private LocalDate dataRecebimento;

    @ManyToOne
    @JoinColumn(name = "Obra_Id", nullable = false)
    private Obra obra;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public double getQuantidadeEntrega() {
        return quantidadeEntrega;
    }

    public void setQuantidadeEntrega(double quantidadeEntrega) {
        this.quantidadeEntrega = quantidadeEntrega;
    }

    public LocalDate getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(LocalDate dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public Obra getObra() {
        return obra;
    }

    public void setObra(Obra obra) {
        this.obra = obra;
    }
}
