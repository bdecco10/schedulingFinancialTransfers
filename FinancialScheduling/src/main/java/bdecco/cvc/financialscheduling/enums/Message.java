package bdecco.cvc.financialscheduling.enums;

public enum Message {
		
	ERRO_VALIDATE_OBJECT("Erro ao validar o objeto SchendulingTransferTO"),
	ERRO_VALIDATE_FILD("O valor do objeto"),
	ERRO_VALIDATE_ISEMPTY("Não existe cadastros para a counta: "),
	ERRO_VALIDATE_NOT_FOUND("Counta nao encontrada"),
	ERRO_VALIDATE_INFORMATION("Favor informar data de agendamento, valor da trasnferencia, operação e conta de origem, seguir a documentação"),
	ERRO_VALIDATE_PARAMETERES_NOT_FOUND("Parametros não informados/ou inseridos de forma errada"),
	ERRO_VALIDATE_OPERATION("Favor informar operação"),
	ERRO_VALIDATE_OPERATION_NOT_FOUND("Operação não informada"),
	ERRO_VALIDATE_FILE_NOT_FOUND("Arquivo não encontrado");
	
	private final String value;

	private Message(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}	

}
