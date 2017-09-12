package bdecco.cvc.financialscheduling.enums;

public enum Code {

	SCHENDULING_001("CVC-001"),
	SCHENDULING_002("CVC-002"),
	SCHENDULING_003("CVC-003"),
	SCHENDULING_004("CVC-004"),
	SCHENDULING_005("CVC-005");
	
	private final String value;

	private Code(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
