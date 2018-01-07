package br.com.modelo;

public enum Tipo {
	
	VERDADEIRO_FALSO,
	MULTIPLA_ESCOLHA_SIMPLES,
	MULTIPLA_ESCOLHA_COMPOSTA,
	DIGITACAO_LIVRE;
	
	@Override
	public String toString() {
		switch (this) {
		case VERDADEIRO_FALSO:
			return "Verdadeiro/Falso";
		case MULTIPLA_ESCOLHA_SIMPLES:
			return "Multipla Escolha Simples";
		case MULTIPLA_ESCOLHA_COMPOSTA:
			return "Multipla Escolha Composta";
		case DIGITACAO_LIVRE:
			return "Digitação Livre";

		default:
			return null;
		}
	};
	
}
