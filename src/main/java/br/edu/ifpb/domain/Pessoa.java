package br.edu.ifpb.domain;

import java.io.Serializable;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 01/02/2021, 09:43:10
 */
public class Pessoa implements Serializable{

    private String nome;
    private long id;
    private CPF cpf;
    private Dependente dependente;

    public Pessoa(String nome) {
        this(nome, "11111111111");
    }
    public Pessoa() {
      //  this.id = 3;
        
    }

    private Pessoa(String nome, long id, String cpf) {
        this.nome = nome;
        this.id = id;
        this.cpf = new CPF(cpf);
       
    }
    
    public static Pessoa of(int id, String nome, String cpf){
       Pessoa p = new Pessoa(nome, id, cpf);
       return p;
       
    }
    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.id = System.currentTimeMillis();
        this.cpf = new CPF(cpf);
    }
    public void alterarNome() {
        this.nome = this.nome.toUpperCase();
    }
    public void alterarNomeMinusculo() {
        this.nome = this.nome.toLowerCase();
    }

    public static Pessoa fake(){
        return new Pessoa("fake");
    }

    public Dependente getDependente() {
        return dependente;
    }
    public void setDependente(Dependente dependente) {
        this.dependente = dependente;
    }
    public CPF getCpf() {
        return cpf;
    }
    public void setCpf(CPF cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public long getId() {
        return id;
    }

}
