public class Perfumaria extends Produto {

	public void venda(Cliente c, Produto p, int Qntd){	
		double total = p.getValor() * Qntd;
		if(c.getSaldo()<=100){
			if(p.getEstoque() >= Qntd) {
				if(c.getSaldo() > p.getValor()){
					System.out.println("Pagamento efetuado com sucesso");
					p.setEstoque(p.getEstoque()-Qntd);
					c.setSaldo(c.getSaldo()-total);	
					}else{
						System.out.println("Saldo Insuficiente");
				}
			}else{
				System.out.println("Estoque Insuficiente");
			}
		}else{
			System.out.println("Saldo superior há 100 reais");
		}
	}
}