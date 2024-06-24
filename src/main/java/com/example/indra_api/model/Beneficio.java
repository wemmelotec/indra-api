package com.example.indra_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

/**
 * <h1>Esta é a classe que vai instanciar o objeto Benefício.</h1>
 */
@Entity
@Table(name = "beneficios")
public class Beneficio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    @JsonIgnore
    private Cliente cliente_id;

    private String nome;

    private String descricao;

    private LocalDate dataInicio;

    private LocalDate dataFim;

    public Beneficio() {
    }

    public Beneficio(Long id, Cliente idcliente, String nome, String descricao, LocalDate dataInicio, LocalDate dataFim) {
        this.id = id;
        this.cliente_id = idcliente;
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getIdcliente() {
        return cliente_id;
    }

    public void setIdcliente(Cliente idcliente) {
        this.cliente_id = idcliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beneficio beneficio = (Beneficio) o;
        return Objects.equals(id, beneficio.id) && Objects.equals(cliente_id, beneficio.cliente_id) && Objects.equals(nome, beneficio.nome) && Objects.equals(descricao, beneficio.descricao) && Objects.equals(dataInicio, beneficio.dataInicio) && Objects.equals(dataFim, beneficio.dataFim);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cliente_id, nome, descricao, dataInicio, dataFim);
    }

    @Override
    public String toString() {
        return "Beneficio{" +
                "id=" + id +
                ", cliente_id=" + cliente_id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                '}';
    }
}
