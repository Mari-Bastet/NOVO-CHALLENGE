package fiap.br.challenge;

public class FilialDTO {
	
	private Long quantidade;
	private String codFilial;
	
	public FilialDTO(Long quantidade, String codFilial) {
		super();
		this.quantidade = quantidade;
		this.codFilial = codFilial;
	}
	
	public Long getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
	public String getCodFilial() {
		return codFilial;
	}
	public void setCodFilial(String codFilial) {
		this.codFilial = codFilial;
	}

	

}
