public class Produto{
	private String nome;
	private int estoque;
	private double valor;
	private String tipo;
		
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome == ""){
			System.out.println("Nome inválido");
		}else{
		this.nome = nome;
		}
	}
	public int getEstoque() {
		return estoque;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
