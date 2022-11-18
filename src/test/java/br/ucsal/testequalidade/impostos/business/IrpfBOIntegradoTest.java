package br.ucsal.testequalidade.impostos.business;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;


import br.ucsal.testequalidade.impostos.builder.FuncionarioBuilder;
import br.ucsal.testequalidade.impostos.builder.FichaFinanceiraBuilder;
import br.ucsal.testequalidade.impostos.domain.Funcionario;
import br.ucsal.testequalidade.impostos.domain.FichaFinanceira;

@TestInstance(Lifecycle.PER_CLASS)
class IrpfBOIntegradoTest {    

    private Funcionario funcionario;
    private FichaFinanceira fichaFinanceira;
    
	@BeforeAll
    public void setupClass() {
        FuncionarioBuilder funcionarioBuilder = FuncionarioBuilder.umFuncionario();

        FichaFinanceiraBuilder fichaFinanceiraBuilder = FichaFinanceiraBuilder.umaFichaFinanceira();

        funcionario = funcionarioBuilder.comMatricula(1).comNome("Lucas").comEmail("lucas@gmail.com").comEndereco("Rua da Ribeira").comDataNascimento(LocalDate.of(2003, 6, 10)).build();
        fichaFinanceira = fichaFinanceiraBuilder.comFuncionario(funcionario).comMesAnoReferencia(LocalDate.now()).comDataPagamento(LocalDate.now()).comSalarioBruto(new BigDecimal("3598.64")).build();
    }

    @DisplayName("Testing taxes")
    @Test
    void testarIrpfBO() {
        assertEquals(184.99, IrpfBO.calcularIr(fichaFinanceira).doubleValue());
    }
}
