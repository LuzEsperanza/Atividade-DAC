package br.edu.ifpb.infra.persistence.memory;

import br.edu.ifpb.domain.Dependente;
import br.edu.ifpb.domain.Pessoa;
import br.edu.ifpb.domain.Pessoas;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 01/02/2021, 11:01:12
 */
public class PessoasEmMemoria implements Pessoas {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private final List<Pessoa> pessoas = new ArrayList<>();
    private final List<Dependente> dependentes = new ArrayList<>();

    public PessoasEmMemoria() {
        dependentes.add(new Dependente(22, "jose", LocalDate.of(2020, Month.MARCH, 2)));
        dependentes.add(new Dependente(32, "sssss", LocalDate.of(2002, Month.MARCH, 3)));
    }

    public void nova(Pessoa pessoa) {
        //TODO: implementar
        this.pessoas.add(pessoa);
    }

    public List<Pessoa> todas() {
        //TODO: implementar
        return Collections.unmodifiableList(pessoas);

    }

    public void excluir(Pessoa pessoa) {
        //TODO: implementar
        this.pessoas.remove(pessoa);
    }

    public void atualizar(Pessoa pessoa) {
        //TODO: implementar
        this.pessoas
                .removeIf(p -> p.getId() == pessoa.getId());
        this.pessoas.add(pessoa);

    }

    @Override
    public Pessoa localizarPessoaComId(long id) {
        return todas()
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(Pessoa.fake());
    }

    @Override
    public List<Dependente> todosOsDepentendes() {
        return Collections.unmodifiableList(dependentes);
    }

    @Override
    public Dependente localizarDependenteComId(long uuid) {
        //TODO: implementar
        List<Dependente> todosOsDepentendes = todosOsDepentendes();
        for (Dependente dep : todosOsDepentendes) {
            if (dep.getUuid() == uuid) {
                return dep;
            }
        }
        return Dependente.fake();
    }

    @Override
    public void novo(Dependente dependente) {

        this.dependentes.add(dependente);
    }

    @Override
    public List<Pessoa> localizarPessoaComCPF(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluirDependente(Dependente dependente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
