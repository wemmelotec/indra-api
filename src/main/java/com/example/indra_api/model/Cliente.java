package com.example.indra_api.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Long agencia;

    @Column(nullable = false)
    private Long conta;

    @Column(nullable = false)
    private byte tipoDaConta;

    @Column(nullable = false)
    private Integer score;

    public Cliente() {
    }

    public Cliente(Long id, String nome, Long agencia, Long conta, byte tipoDaConta, Integer score) {
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

    public byte getTipoDaConta() {
        return tipoDaConta;
    }

    public void setTipoDaConta(byte tipoDaConta) {
        this.tipoDaConta = tipoDaConta;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
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
