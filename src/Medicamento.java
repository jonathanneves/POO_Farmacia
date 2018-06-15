public class Medicamento extends Produto {
	
	public void venda(Cliente c, Produto p, int Qntd){	
		double total = p.getValor() * Qntd;
		if(c.getReceita()){
			if(c.getSaldo() > total){
				if(p.getEstoque() >= Qntd){
					System.out.println("Pagamento efetuado com sucesso");
					p.setEstoque(p.getEstoque()-Qntd);
					c.setSaldo(c.getSaldo()-total);	
						}else{
					System.out.println("Estoque Insuficiente");
						}
					}else{
				System.out.println("Dinheiro Insuficiente");
					}
				}else{
			System.out.println("Sem receita");
			}
	}	
}

