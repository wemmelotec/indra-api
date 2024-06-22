package com.example.indra_api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    //@Column(nullable = false)
    private String nome;

    @NotNull
    //@Column(nullable = false)
    private Long agencia;

    @NotNull
    //@Column(nullable = false)
    private Long conta;

    @NotNull
    //@Column(nullable = false)
    private Long tipoDaConta;

    private Integer score;

    @JsonBackReference
    @OneToMany (mappedBy = "cliente_id", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Beneficio> beneficios;


    public Cliente() {
    }

    public Cliente(Long id, String nome, Long agencia, Long conta, Long tipoDaConta, Integer score) {
        this.id = id;
        this.nome = nome;
        this.agencia = agencia;
        this.conta = conta;
        this.tipoDaConta = tipoDaConta;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getAgencia() {
        return agencia;
    }

    public void setAgencia(Long agencia) {
        this.agencia = agencia;
    }

    public Long getConta() {
        return conta;
    }

    public void setConta(Long conta) {
        this.conta = conta;
    }

    public Long getTipoDaConta() {
        return tipoDaConta;
    }

    public void setTipoDaConta(Long tipoDaConta) {
        this.tipoDaConta = tipoDaConta;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public List<Beneficio> getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(List<Beneficio> beneficios) {
        this.beneficios = beneficios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return tipoDaConta == cliente.tipoDaConta && Objects.equals(id, cliente.id) && Objects.equals(nome, cliente.nome) && Objects.equals(agencia, cliente.agencia) && Objects.equals(conta, cliente.conta) && Objects.equals(score, cliente.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, agencia, conta, tipoDaConta, score);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", agencia=" + agencia +
                ", conta=" + conta +
                ", tipoDaConta=" + tipoDaConta +
                ", score=" + score +
                '}';
    }
}