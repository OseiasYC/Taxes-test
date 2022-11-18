package br.ucsal.testequalidade.impostos.persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.testequalidade.impostos.domain.FichaFinanceira;
import br.ucsal.testequalidade.impostos.domain.Funcionario;
import br.ucsal.testequalidade.impostos.exception.ObjetoNaoEncontradoException;

public class FichaFinanceiraDAO {
	private static List<FichaFinanceira> fichaFinanceiras = new ArrayList<>();

	private FichaFinanceiraDAO() {
	}

	public static FichaFinanceira obterPorFuncionarioMesAnoReferencia(Funcionario funcionario, LocalDate mesAnoReferencia)
			throws ObjetoNaoEncontradoException {
		for (FichaFinanceira fichaFinanceira : fichaFinanceiras) {
			if (fichaFinanceira.getFuncionario().equals(funcionario) && fichaFinanceira.getMesAnoReferencia().equals(mesAnoReferencia)) {
				return fichaFinanceira;
			}
		}
		throw new ObjetoNaoEncontradoException();
	}

	public static void insert(FichaFinanceira fichaFinanceira) {
		fichaFinanceiras.add(fichaFinanceira);
	}
}
