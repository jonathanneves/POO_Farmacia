public class Cliente {
	private String nome;
	private double saldo;
	private boolean receita = false;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome == ""){
			System.out.println("Nome Inválido");
		}else{
		this.nome = nome;
		}
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
}
	public boolean getReceita() {
		return receita;
	}
	public void setReceita(boolean receita) {
		this.receita = receita;
	}
	
	
}
