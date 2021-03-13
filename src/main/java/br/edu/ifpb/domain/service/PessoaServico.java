package br.edu.ifpb.domain.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import br.edu.ifpb.domain.Dependente;
import br.edu.ifpb.domain.Pessoa;
import br.edu.ifpb.domain.Pessoas;
import br.edu.ifpb.infra.persistence.jdbc.PessoasJDBC;
@RequestScoped
public class PessoaServico implements Pessoas {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    Pessoas PessoasJDBC;

    public PessoaServico() {
        this.PessoasJDBC = new PessoasJDBC();

    }

    @Override
    public void nova(Pessoa pessoa) {
        Pessoa retorno = this.PessoasJDBC.localizarPessoaComId(pessoa.getId());
        if (null == retorno || Pessoa.fake().equals(retorno)) {
            PessoasJDBC.nova(pessoa);

        } else {
            PessoasJDBC.atualizar(pessoa);
        }

    }

    @Override
    public List<Pessoa> todas() {
        // TODO Auto-generated method stub
        return this.PessoasJDBC.todas();
    }

    @Override
    public void excluir(Pessoa pessoa) {
        // TODO Auto-generated method stub
        this.PessoasJDBC.excluir(pessoa);
    }

    @Override
    public void excluirDependente(Dependente dependente) {
        this.PessoasJDBC.excluirDependente(dependente);
    }

    @Override
    public void atualizar(Pessoa pessoa) {
        // TODO Auto-generated method stub
        this.PessoasJDBC.atualizar(pessoa);
        //this.PessoasJDBC.atualizar(pessoa);

    }

    @Override
    public Pessoa localizarPessoaComId(long id) {
        // TODO Auto-generated method stub
        return PessoasJDBC.localizarPessoaComId(id);

    }

    @Override
    public List<Dependente> todosOsDepentendes() {
        return this.PessoasJDBC.todosOsDepentendes();
    }

    @Override
    public Dependente localizarDependenteComId(long uuid) {
        // TODO Auto-generated method stub
        return this.PessoasJDBC.localizarDependenteComId(uuid);
    }

    @Override
    public void novo(Dependente dependente) {
        this.PessoasJDBC.novo(dependente);

    }

    @Override
    public List<Pessoa> localizarPessoaComCPF(String cpf) {
        List<Pessoa> ps = this.PessoasJDBC.localizarPessoaComCPF(cpf);
        for (Pessoa p : ps) {
        }
        return ps;
    }
}
