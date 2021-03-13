package br.edu.ifpb.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.UUID;

    public class Dependente implements Serializable {

    private long uuid;
    private String nome;
    private String CPFAfiliado;
    private LocalDate dataDeNascimento;

    public Dependente() {
        this("");
    }

    private Dependente(long uuid, String nome, String CPFAfiliado, LocalDate dataDeNascimento) {
        this.uuid = uuid;
        this.nome = nome;
        this.CPFAfiliado = CPFAfiliado;
        this.dataDeNascimento = dataDeNascimento;
    }

    public static Dependente
            of(long uuid, String nome, String CPFAfiliado, String dataDeNascimento) {
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return new Dependente(uuid,
                nome, CPFAfiliado,
                LocalDate.parse(dataDeNascimento));
    }

    public Dependente(String nome) {
        this.nome = nome;
    }

    public Dependente(long uuid, String nome) {
        this(
                uuid, nome, LocalDate.now()
        );
    }

    public Dependente(long uuid, String nome, LocalDate dataDeNascimento) {
        this.uuid = uuid;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
    }

    public static Dependente fake() {
        return new Dependente(-1, "-1");
    }

    public long getUuid() {
        return uuid;
    }

    public void setUuid(long uuid) {
        this.uuid = uuid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getCPFAfiliado() {
        return CPFAfiliado;
    }

    public void setCPFAfiliado(String CPFAfiliado) {
        this.CPFAfiliado = CPFAfiliado;
    }

    public boolean naoValido() {
        return nomeVazio() || nascimentoAnterior();
    }

    public boolean nomeVazio() {
        return this.nome == null || this.nome.trim().equals("");
    }

    public boolean nascimentoAnterior() {
        return this.dataDeNascimento == null
                || this.dataDeNascimento.isEqual(LocalDate.now())
                || this.dataDeNascimento.isAfter(LocalDate.now());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.uuid);
        hash = 89 * hash + Objects.hashCode(this.nome);
        hash = 89 * hash + Objects.hashCode(this.dataDeNascimento);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dependente other = (Dependente) obj;
        if (!Objects.equals(this.uuid, other.uuid)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.dataDeNascimento, other.dataDeNascimento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dependente{" + "uuid=" + uuid + ", nome=" + nome + ", CPFAfiliado=" + CPFAfiliado + ", dataDeNascimento=" + dataDeNascimento + '}';
    }
    
}
