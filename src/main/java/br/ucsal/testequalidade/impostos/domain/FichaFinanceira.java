package br.ucsal.testequalidade.impostos.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FichaFinanceira {

	private Funcionario funcionario;

	private LocalDate mesAnoReferencia;

	private LocalDate dataPagamento;

	private BigDecimal salarioBruto;

	private BigDecimal irpf;

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public LocalDate getMesAnoReferencia() {
		return mesAnoReferencia;
	}

	public void setMesAnoReferencia(LocalDate mesAnoReferencia) {
		this.mesAnoReferencia = mesAnoReferencia;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public BigDecimal getSalarioBruto() {
		return salarioBruto;
	}

	public void setSalarioBruto(BigDecimal salarioBruto) {
		this.salarioBruto = salarioBruto;
	}

	public BigDecimal getIrpf() {
		return irpf;
	}

	public void setIrpf(BigDecimal irpf) {
		this.irpf = irpf;
	}

	@Override
	public String toString() {
		return "FichaFinanceira [funcionario=" + funcionario + ", mesAnoReferencia=" + mesAnoReferencia + ", dataPagamento=" + dataPagamento
				+ ", salarioBruto=" + salarioBruto + ", irpf=" + irpf + "]";
	}

}
