package br.ucsal.testequalidade.impostos.builder;

import java.time.LocalDate;

import br.ucsal.testequalidade.impostos.domain.Funcionario;

public class FuncionarioBuilder {  
    
    private static final Integer DEFAULT_MATRICULA = 0;
    private static final String DEFAULT_NOME = null; 
    private static final String DEFAULT_ENDERECO = null; 
    private static final String DEFAULT_EMAIL = null;
    private static final LocalDate DEFAULT_DATA = LocalDate.now();
    
    private Integer matricula = DEFAULT_MATRICULA;
    private String nome = DEFAULT_NOME;
    private String endereco = DEFAULT_ENDERECO;
    private String email = DEFAULT_EMAIL;
    private LocalDate data = DEFAULT_DATA;

    private FuncionarioBuilder() {
    }

    public static FuncionarioBuilder umFuncionario() {
        return new FuncionarioBuilder();
    }

    public FuncionarioBuilder comMatricula(Integer matricula) {
        this.matricula = matricula;
        return this;
    }

    public FuncionarioBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public FuncionarioBuilder comEndereco(String endereco) {
        this.endereco = endereco;
        return this;
    }

    public FuncionarioBuilder comEmail(String email) {
        this.email = email;
        return this;
    }

    public FuncionarioBuilder comDataNascimento(LocalDate data) {
        this.data = data;
        return this;
    }

	public Funcionario build(){
        Funcionario funcionario = new Funcionario();
        funcionario.setMatricula(matricula);
		funcionario.setNome(nome);
        funcionario.setEndereco(endereco);
		funcionario.setEmail(email);
        funcionario.setDataNascimento(data);
		return funcionario;
    }
}