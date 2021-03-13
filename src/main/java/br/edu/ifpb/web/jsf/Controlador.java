package br.edu.ifpb.web.jsf;

//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
import br.edu.ifpb.domain.Dependente;
import br.edu.ifpb.domain.Pessoa;
import br.edu.ifpb.domain.Pessoas;
import br.edu.ifpb.domain.service.PessoaServico;
import br.edu.ifpb.infra.persistence.memory.PessoasEmMemoria;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 01/02/2021, 10:01:33
 */
//@ManagedBean
@Named
//@RequestScoped
@SessionScoped
public class Controlador implements Serializable {

    private Pessoa pessoa = new Pessoa();
    private Dependente dependente = new Dependente();
    private String dataNsc;
    private PessoasEmMemoria servicoMemoria = new PessoasEmMemoria();
    private Pessoas servicoJDBC = new PessoaServico();
    private List<Pessoa> pessoas = Collections.EMPTY_LIST;
    private String CPF;

    public String redirecionar() {
        // executando a lógica de negócio

        servicoJDBC.nova(pessoa);
        servicoMemoria.nova(pessoa);
        pessoa = new Pessoa();
        return null; // fica na página original
//        return "home"; // encmainhar a requisição à página 
//        return "home.xhtml?faces-redirect=true"; // nova requisição
    }

    public String adicionar() {
        servicoJDBC.nova(pessoa);
        // deveríamos ter um objeto responsável por encapsular essa regra de negócio

        servicoMemoria.nova(pessoa);
        pessoa = new Pessoa();

        return "list";
    }

    public String excluir(Pessoa pessoa) {
        //servicoMemoria.excluir(pessoa);
        servicoJDBC.excluir(pessoa);
        this.pessoas = Collections.EMPTY_LIST;
        this.pessoa = new Pessoa();
        this.CPF="";
        return null;
    }

    public String excluirDependente(Dependente dependente) {
        //servicoMemoria.excluir(pessoa);
        servicoJDBC.excluirDependente(dependente);
        return "list";
    }

    public String editar(Pessoa pessoa) {
        this.pessoa = pessoa;
        this.CPF="";
        return "edit";
    }

    public String editarDependente(Dependente dependente) {
        this.dependente = dependente;
        dataNsc = dependente.getDataDeNascimento().toString();
        servicoJDBC.novo(dependente);
        //servicoMemoria.atualizar(pessoa);
        return "edit";
    }

    public String adicionarDependente() {
        LocalDate date = LocalDate.parse(dataNsc);
        dependente.setDataDeNascimento(date);
        dependente.setCPFAfiliado("99999999999");
        servicoJDBC.novo(dependente);
      
        this.dependente = new Dependente();
        return "list";
    }

    public List<Dependente> todosOsDependentes() {
        List<Dependente> r = servicoJDBC.todosOsDepentendes();
        for (Dependente dependente1 : r) {
            //System.err.println("deps " + dependente1);

        }
       // return servicoMemoria.todosOsDepentendes();
        return servicoJDBC.todosOsDepentendes();
    }

    public List<Pessoa> todasAsPessoas() {
        // return servicoMemoria.todas();
        return servicoJDBC.todas();

    }

    public String listCPF() {

        return "buscarCPF";
    }

    public String buscarCPF() {
        this.pessoas = servicoJDBC.localizarPessoaComCPF(CPF);

        return null;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Dependente getDependente() {
        return dependente;
    }

    public void setDependente(Dependente dependente) {
        this.dependente = dependente;
    }

    public String getDataNsc() {
        return dataNsc;
    }

    public void setDataNsc(String dataNsc) {
        this.dataNsc = dataNsc;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

}
