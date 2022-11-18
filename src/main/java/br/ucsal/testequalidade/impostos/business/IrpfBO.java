package br.ucsal.testequalidade.impostos.business;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.ucsal.testequalidade.impostos.domain.FichaFinanceira;

public class IrpfBO {

	private static final BigDecimal ALIQUOTA_1 = new BigDecimal("0.075");
	private static final BigDecimal ALIQUOTA_2 = new BigDecimal("0.150");
	private static final BigDecimal ALIQUOTA_3 = new BigDecimal("0.225");
	private static final BigDecimal ALIQUOTA_4 = new BigDecimal("0.275");
	private static final BigDecimal FAIXA_1_TOPO = new BigDecimal("1903.98");
	private static final BigDecimal FAIXA_2_TOPO = new BigDecimal("2826.65");
	private static final BigDecimal FAIXA_3_TOPO = new BigDecimal("3751.05");
	private static final BigDecimal FAIXA_4_TOPO = new BigDecimal("4664.68");
	private static final Integer QTD_CASAS_DECIMAIS_ETAPAS_INTERMEDIARIAS = 4;
	private static final Integer QTD_CASAS_DECIMAIS_ETAPA_FINAL = 2;
	private static final RoundingMode ROUNDING_MODE_ETAPAS_INTERMEDIARIAS = RoundingMode.HALF_UP;
	private static final RoundingMode ROUNDING_MODE_ETAPA_FINAL = RoundingMode.DOWN;

	private IrpfBO() {
		
	}

	public static BigDecimal calcularIr(FichaFinanceira fichaFinanceira) {
		BigDecimal baseCalculo = fichaFinanceira.getSalarioBruto();
		BigDecimal baseCalculoFaixa;
		BigDecimal impostoFaixa;
		BigDecimal ir = BigDecimal.ZERO;
		if (baseCalculo.compareTo(FAIXA_4_TOPO) > 0) {
			baseCalculoFaixa = baseCalculo.subtract(FAIXA_4_TOPO);
			impostoFaixa = baseCalculoFaixa.multiply(ALIQUOTA_4).setScale(QTD_CASAS_DECIMAIS_ETAPAS_INTERMEDIARIAS, ROUNDING_MODE_ETAPAS_INTERMEDIARIAS);
			ir = ir.add(impostoFaixa);
			baseCalculo = FAIXA_4_TOPO;
		}
		if (baseCalculo.compareTo(FAIXA_3_TOPO) > 0) {
			baseCalculoFaixa = baseCalculo.subtract(FAIXA_3_TOPO);
			impostoFaixa =  baseCalculoFaixa.multiply(ALIQUOTA_3).setScale(QTD_CASAS_DECIMAIS_ETAPAS_INTERMEDIARIAS, ROUNDING_MODE_ETAPAS_INTERMEDIARIAS);
			ir = ir.add(impostoFaixa);
			baseCalculo = FAIXA_3_TOPO;
		}
		if (baseCalculo.compareTo(FAIXA_2_TOPO) > 0) {
			baseCalculoFaixa = baseCalculo.subtract(FAIXA_2_TOPO);
			impostoFaixa = baseCalculoFaixa.multiply(ALIQUOTA_2).setScale(QTD_CASAS_DECIMAIS_ETAPAS_INTERMEDIARIAS, ROUNDING_MODE_ETAPAS_INTERMEDIARIAS);
			ir = ir.add(impostoFaixa);
			baseCalculo = FAIXA_2_TOPO;
		}
		if (baseCalculo.compareTo(FAIXA_1_TOPO) > 0) {
			baseCalculoFaixa = baseCalculo.subtract(FAIXA_1_TOPO);
			impostoFaixa = baseCalculoFaixa.multiply(ALIQUOTA_1).setScale(QTD_CASAS_DECIMAIS_ETAPAS_INTERMEDIARIAS, ROUNDING_MODE_ETAPAS_INTERMEDIARIAS);
			ir = ir.add(impostoFaixa);
		}
		return ir.setScale(QTD_CASAS_DECIMAIS_ETAPA_FINAL, ROUNDING_MODE_ETAPA_FINAL);
	}

}
