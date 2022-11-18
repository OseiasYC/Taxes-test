package br.ucsal.testequalidade.impostos.builder;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.ucsal.testequalidade.impostos.domain.Funcionario;
import br.ucsal.testequalidade.impostos.domain.FichaFinanceira;


public class FichaFinanceiraBuilder {
    
	private final Funcionario DEFAULT_FUNCIONARIO = FuncionarioBuilder.umFuncionario().build();
	private final LocalDate DEFAULT_DATA = LocalDate.now();
	private final LocalDate DEFAULT_DATAPAGAMENTO = LocalDate.now();
	private final BigDecimal DEFAULT_SALARIOBRUTO = null;

    private Funcionario funcionario = DEFAULT_FUNCIONARIO;
	private LocalDate mesAnoReferencia = DEFAULT_DATA;
	private LocalDate dataPagamento = DEFAULT_DATAPAGAMENTO;
	private BigDecimal salarioBruto = DEFAULT_SALARIOBRUTO;
    
    private FichaFinanceiraBuilder() {
    }

	public static FichaFinanceiraBuilder umaFichaFinanceira() {
		return new FichaFinanceiraBuilder();
	}
    
    public FichaFinanceiraBuilder comFuncionario(Funcionario funcionario){
		this.funcionario = funcionario;
		return this;
	}

	public FichaFinanceiraBuilder comMesAnoReferencia(LocalDate mesAnoReferencia) {
		this.mesAnoReferencia = mesAnoReferencia;
		return this;
	}

	public FichaFinanceiraBuilder comDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
		return this;
	}

	public FichaFinanceiraBuilder comSalarioBruto(BigDecimal salarioBruto) {
		this.salarioBruto = salarioBruto;
		return this;
	}

	public FichaFinanceira build() {
		FichaFinanceira fichaFinanceira = new FichaFinanceira();
		fichaFinanceira.setFuncionario(funcionario);
		fichaFinanceira.setMesAnoReferencia(mesAnoReferencia);
		fichaFinanceira.setDataPagamento(dataPagamento);
		fichaFinanceira.setSalarioBruto(salarioBruto);
		return fichaFinanceira;
	}
}