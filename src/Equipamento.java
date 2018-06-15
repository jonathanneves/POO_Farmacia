public class Equipamento extends Produto {
	
	public void venda(Cliente c, Produto p, int Qntd){	
		double total = p.getValor() * Qntd;
				if(c.getSaldo() >= p.getValor()){
					System.out.println("Pagamento efetuado com sucesso");
					setEstoque(p.getEstoque()-Qntd);
					c.setSaldo(c.getSaldo()-total);	
						}else{
						System.out.println("Saldo Insuficiente");
					}

			}
	}