package br.ucsal.testequalidade.impostos.persistence;

import java.util.ArrayList;
import java.util.List;

import br.ucsal.testequalidade.impostos.domain.Funcionario;
import br.ucsal.testequalidade.impostos.exception.ObjetoNaoEncontradoException;

public class FuncionarioDAO {

	private static List<Funcionario> funcionarios = new ArrayList<>();

	private FuncionarioDAO() {
	}

	public static Funcionario obterPorMatricula(Integer matricula) throws ObjetoNaoEncontradoException {
		for (Funcionario funcionario : funcionarios) {
			if (funcionario.getMatricula().equals(matricula)) {
				return funcionario;
			}
		}
		throw new ObjetoNaoEncontradoException();
	}

	public static void insert(Funcionario funcionario) {
		funcionarios.add(funcionario);
	}
}
