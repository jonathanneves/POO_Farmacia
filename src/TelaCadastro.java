import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class TelaCadastro extends Shell {
	private Text text;
	private Text text_1;
	private Text txtnome;
	private Text txtsaldo;
	private Table tbcliente;
	private Text txtproduto;
	private Text txtestoque;
	private Table tbproduto;
	private Text txtpreco;

	ArrayList<Produto> produtos = new ArrayList<Produto>();
	ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	private Text txtqntd;
	private Table tablecliente;
	private Table tableproduto;
	public int x=0;

	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			TelaCadastro shell = new TelaCadastro(display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public TelaCadastro(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		CTabFolder tabFolder_1 = new CTabFolder(this, SWT.BORDER);
		tabFolder_1.setBounds(10, 10, 490, 464);
		tabFolder_1.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		Button button_1 = new Button(tabFolder_1, SWT.CHECK);
		button_1.setText("N\u00E3o");
		
		Button button_2 = new Button(tabFolder_1, SWT.CHECK);
		button_2.setText("Sim");
		
		Label label = new Label(tabFolder_1, SWT.NONE);
		label.setText("Receita:");
		label.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.BOLD));
		
		Label label_1 = new Label(tabFolder_1, SWT.NONE);
		label_1.setText("Saldo:");
		label_1.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.BOLD));
		
		text = new Text(tabFolder_1, SWT.BORDER);
		
		Label label_2 = new Label(tabFolder_1, SWT.NONE);
		label_2.setText("Nome:");
		label_2.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.BOLD));
		
		text_1 = new Text(tabFolder_1, SWT.BORDER);
		
		CTabItem tbtmComprar = new CTabItem(tabFolder_1, SWT.NONE);
		tbtmComprar.setText("Comprar");
		
		Composite composite = new Composite(tabFolder_1, SWT.NONE);
		tbtmComprar.setControl(composite);
		
		Group grpCliente = new Group(composite, SWT.NONE);
		grpCliente.setText("Cliente");
		grpCliente.setBounds(10, 10, 464, 167);
		
		tablecliente = new Table(grpCliente, SWT.BORDER | SWT.FULL_SELECTION);
		tablecliente.setBounds(10, 20, 444, 137);
		tablecliente.setHeaderVisible(true);
		tablecliente.setLinesVisible(true);
		
		TableColumn tblclmnNome_2 = new TableColumn(tablecliente, SWT.NONE);
		tblclmnNome_2.setWidth(230);
		tblclmnNome_2.setText("Nome");
		
		TableColumn tblclmnSaldo_1 = new TableColumn(tablecliente, SWT.NONE);
		tblclmnSaldo_1.setWidth(112);
		tblclmnSaldo_1.setText("Saldo");
		
		TableColumn tblclmnReceita_1 = new TableColumn(tablecliente, SWT.NONE);
		tblclmnReceita_1.setWidth(93);
		tblclmnReceita_1.setText("Receita");
		
		Group grpProduto = new Group(composite, SWT.NONE);
		grpProduto.setText("Produto");
		grpProduto.setBounds(10, 183, 464, 215);
		
		tableproduto = new Table(grpProduto, SWT.BORDER | SWT.FULL_SELECTION);
		tableproduto.setBounds(10, 22, 444, 183);
		tableproduto.setHeaderVisible(true);
		tableproduto.setLinesVisible(true);
		
		TableColumn tblclmnNome_3 = new TableColumn(tableproduto, SWT.NONE);
		tblclmnNome_3.setWidth(144);
		tblclmnNome_3.setText("Nome");
		
		TableColumn tblclmnPreo_1 = new TableColumn(tableproduto, SWT.NONE);
		tblclmnPreo_1.setWidth(89);
		tblclmnPreo_1.setText("Pre\u00E7o");
		
		TableColumn tblclmnSaldo_2 = new TableColumn(tableproduto, SWT.NONE);
		tblclmnSaldo_2.setWidth(82);
		tblclmnSaldo_2.setText("Estoque");
		
		TableColumn tblclmnTipo_1 = new TableColumn(tableproduto, SWT.NONE);
		tblclmnTipo_1.setWidth(117);
		tblclmnTipo_1.setText("Tipo");
		
		Label lblQuantidade = new Label(composite, SWT.NONE);
		lblQuantidade.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
		lblQuantidade.setBounds(10, 409, 90, 20);
		lblQuantidade.setText("Quantidade:");
		
		txtqntd = new Text(composite, SWT.BORDER);
		txtqntd.setBounds(106, 410, 189, 21);
		
		Button btnComprar = new Button(composite, SWT.NONE);
		btnComprar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int quantidade = Integer.parseInt(txtqntd.getText());
				int ClienteSelecionado = tablecliente.getSelectionIndex();
				int ProdutoSelecionado = tableproduto.getSelectionIndex();
								
				if(produtos.get(ProdutoSelecionado).getTipo().equals("Medicamentos")){
					Medicamento med = new Medicamento();
					med.venda(clientes.get(ClienteSelecionado), produtos.get(ProdutoSelecionado), quantidade);
				}
				if(produtos.get(ProdutoSelecionado).getTipo().equals("Perfumaria")){
					Perfumaria perf = new Perfumaria();
					perf.venda(clientes.get(ClienteSelecionado), produtos.get(ProdutoSelecionado), quantidade);
				}
				if(produtos.get(ProdutoSelecionado).getTipo().equals("Equipamento Médico")){
					Equipamento equipmed = new Equipamento();
					equipmed.venda(clientes.get(ClienteSelecionado), produtos.get(ProdutoSelecionado),  quantidade);
				}

				tbcliente.removeAll();
				tablecliente.removeAll();
				tbproduto.removeAll();
				tableproduto.removeAll();
				
				String receita;
				
				for(int x=0; x<clientes.size(); x++){
					
					if(clientes.get(x).getReceita()){
						receita = "Sim";
					}else{
						receita = "Não";
					}
					
					TableItem tb = new TableItem(tbcliente, SWT.NONE);
					TableItem tb2 = new TableItem(tablecliente, SWT.NONE);
					
						tb.setText(0, clientes.get(x).getNome());
						tb.setText(1, clientes.get(x).getSaldo()+"");
						tb.setText(2, receita);
						tb2.setText(0, clientes.get(x).getNome());
						tb2.setText(1, clientes.get(x).getSaldo()+"");
						tb2.setText(2, receita);
				}
				
				for(int y=0; y<produtos.size(); y++){
					TableItem tbp = new TableItem(tbproduto, SWT.NONE);
					TableItem tbp2 = new TableItem(tableproduto, SWT.NONE);

						tbp.setText(0, produtos.get(y).getNome());
						tbp.setText(1, produtos.get(y).getValor()+"");
						tbp.setText(2, produtos.get(y).getEstoque()+"");
						tbp.setText(3, produtos.get(y).getTipo());
						tbp2.setText(0, produtos.get(y).getNome());
						tbp2.setText(1, produtos.get(y).getValor()+"");
						tbp2.setText(2, produtos.get(y).getEstoque()+"");
						tbp2.setText(3, produtos.get(y).getTipo());
				}	
			}
		});
		btnComprar.setBounds(326, 404, 130, 25);
		btnComprar.setText("Comprar");
		
		CTabItem tbtmCliente = new CTabItem(tabFolder_1, SWT.NONE);
		tbtmCliente.setText("Cliente");
		
		Composite composite_1 = new Composite(tabFolder_1, SWT.NONE);
		tbtmCliente.setControl(composite_1);
		
		Label lblNewLabel = new Label(composite_1, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		lblNewLabel.setBounds(10, 10, 56, 21);
		lblNewLabel.setText("Nome:");
		
		Label lblSaldo = new Label(composite_1, SWT.NONE);
		lblSaldo.setText("Saldo:");
		lblSaldo.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		lblSaldo.setBounds(10, 45, 56, 21);
		
		Label lblReceita = new Label(composite_1, SWT.NONE);
		lblReceita.setText("Receita:");
		lblReceita.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		lblReceita.setBounds(10, 87, 67, 21);
		
		txtnome = new Text(composite_1, SWT.BORDER);
		txtnome.setBounds(72, 10, 327, 21);
		
		txtsaldo = new Text(composite_1, SWT.BORDER);
		txtsaldo.setBounds(72, 45, 156, 21);
		
		Combo combo = new Combo(composite_1, SWT.NONE);
		combo.setItems(new String[] {"Sim", "N\u00E3o"});
		combo.setBounds(83, 87, 145, 23);
		combo.setText("--SELECIONE--\r\n\r\n");
		
		Button btnNewButton = new Button(composite_1, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Cliente c = new Cliente();
				c.setNome(txtnome.getText());
				c.setSaldo(Double.parseDouble((txtsaldo.getText())));
				String receita = combo.getText();
				if(receita.equals("Sim"))
					c.setReceita(true);
				else
					c.setReceita(false);
				clientes.add(c);
				
				TableItem tb = new TableItem(tbcliente, SWT.NONE);
				TableItem tb2 = new TableItem(tablecliente, SWT.NONE);
					tb.setText(0, c.getNome());
					tb.setText(1, c.getSaldo()+"");
					tb.setText(2, receita);
					tb2.setText(0, c.getNome());
					tb2.setText(1, c.getSaldo()+"");
					tb2.setText(2, receita);
				
			}
		});
		btnNewButton.setBounds(268, 54, 111, 42);
		btnNewButton.setText("Cadastrar");
		
		tbcliente = new Table(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		tbcliente.setBounds(10, 127, 464, 302);
		tbcliente.setHeaderVisible(true);
		tbcliente.setLinesVisible(true);
		
		TableColumn tblclmnNome = new TableColumn(tbcliente, SWT.NONE);
		tblclmnNome.setWidth(200);
		tblclmnNome.setText("Nome");
		
		TableColumn tblclmnSaldo = new TableColumn(tbcliente, SWT.NONE);
		tblclmnSaldo.setWidth(148);
		tblclmnSaldo.setText("Saldo");
		
		TableColumn tblclmnReceita = new TableColumn(tbcliente, SWT.NONE);
		tblclmnReceita.setWidth(99);
		tblclmnReceita.setText("Receita");
		
		CTabItem tbtmProduto = new CTabItem(tabFolder_1, SWT.NONE);
		tbtmProduto.setText("Produto");
		
		Composite composite_5 = new Composite(tabFolder_1, SWT.NONE);
		tbtmProduto.setControl(composite_5);
		
		Label lblNome = new Label(composite_5, SWT.NONE);
		lblNome.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		lblNome.setBounds(10, 22, 59, 26);
		lblNome.setText("Nome:");
		
		txtproduto = new Text(composite_5, SWT.BORDER);
		txtproduto.setBounds(89, 24, 369, 21);
		
		Label lblEstoque = new Label(composite_5, SWT.NONE);
		lblEstoque.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		lblEstoque.setBounds(10, 62, 73, 26);
		lblEstoque.setText("Estoque:");
		
		txtestoque = new Text(composite_5, SWT.BORDER);
		txtestoque.setBounds(89, 64, 144, 21);
		
		Combo combotipo = new Combo(composite_5, SWT.NONE);
		combotipo.setItems(new String[] {"Medicamentos", "Perfumaria", "Equipamento M\u00E9dico"});
		combotipo.setBounds(89, 109, 202, 23);
		combotipo.setText("--SELECIONE--");
		
		Button btnAdicionarProduto = new Button(composite_5, SWT.NONE);
		btnAdicionarProduto.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				Produto prod = new Produto();
				prod.setTipo(combotipo.getText());
				TableItem it = new TableItem(tbproduto, SWT.NONE);
				TableItem it2 = new TableItem(tableproduto, SWT.NONE);
				
				if(prod.getTipo().equals("Medicamentos")){
					Medicamento m = new Medicamento();
					m.setNome(txtproduto.getText());
					m.setEstoque(Integer.parseInt(txtestoque.getText()));
					m.setValor(Double.parseDouble(txtpreco.getText()));		
					m.setTipo(prod.getTipo());
					produtos.add(m);
						it.setText(0, m.getNome());
						it.setText(1, m.getValor()+"");
						it.setText(2, m.getEstoque()+"");
						it.setText(3, m.getTipo());
						it2.setText(0, m.getNome());
						it2.setText(1, m.getValor()+"");
						it2.setText(2, m.getEstoque()+"");
						it2.setText(3, m.getTipo());
				}
				if(prod.getTipo().equals("Perfumaria")){
					Perfumaria p = new Perfumaria();
					p.setNome(txtproduto.getText());
					p.setEstoque(Integer.parseInt(txtestoque.getText()));
					p.setValor(Double.parseDouble(txtpreco.getText()));
					p.setTipo(prod.getTipo());
					produtos.add(p);
						it.setText(0, p.getNome());
						it.setText(1, p.getValor()+"");
						it.setText(2, p.getEstoque()+"");
						it.setText(3, p.getTipo());
						it2.setText(0, p.getNome());
						it2.setText(1, p.getValor()+"");
						it2.setText(2, p.getEstoque()+"");
						it2.setText(3, p.getTipo());
				}
				if(prod.getTipo().equals("Equipamento Médico")){
					Equipamento equip  = new Equipamento();
					equip.setNome(txtproduto.getText());
					equip.setEstoque(Integer.parseInt(txtestoque.getText()));
					equip.setValor(Double.parseDouble(txtpreco.getText()));
					equip.setTipo(prod.getTipo());
					produtos.add(equip);
						it.setText(0, equip.getNome());
						it.setText(1, equip.getValor()+"");
						it.setText(2, equip.getEstoque()+"");
						it.setText(3, equip.getTipo());
						it2.setText(0, equip.getNome());
						it2.setText(1, equip.getValor()+"");
						it2.setText(2, equip.getEstoque()+"");
						it2.setText(3, equip.getTipo());
				}		
				x++;
			}
		});
		btnAdicionarProduto.setBounds(314, 101, 144, 43);
		btnAdicionarProduto.setText("Adicionar Produto");
		
		tbproduto = new Table(composite_5, SWT.BORDER | SWT.FULL_SELECTION);
		tbproduto.setBounds(10, 158, 461, 271);
		tbproduto.setHeaderVisible(true);
		tbproduto.setLinesVisible(true);
		
		TableColumn tblclmnNome_1 = new TableColumn(tbproduto, SWT.NONE);
		tblclmnNome_1.setWidth(146);
		tblclmnNome_1.setText("Nome");
		
		TableColumn tblclmnEstoque = new TableColumn(tbproduto, SWT.NONE);
		tblclmnEstoque.setWidth(72);
		tblclmnEstoque.setText("Estoque");
		
		TableColumn tblclmnPreo = new TableColumn(tbproduto, SWT.NONE);
		tblclmnPreo.setWidth(96);
		tblclmnPreo.setText("Pre\u00E7o");
		
		TableColumn tblclmnTipo = new TableColumn(tbproduto, SWT.NONE);
		tblclmnTipo.setWidth(130);
		tblclmnTipo.setText("Tipo");
		
		Label lblPreo = new Label(composite_5, SWT.NONE);
		lblPreo.setText("Pre\u00E7o:");
		lblPreo.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		lblPreo.setBounds(260, 62, 59, 21);
		
		txtpreco = new Text(composite_5, SWT.BORDER);
		txtpreco.setBounds(330, 64, 127, 21);
			
		Label lblTipo = new Label(composite_5, SWT.NONE);
		lblTipo.setText("Tipo:");
		lblTipo.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		lblTipo.setBounds(10, 110, 73, 26);
		createContents();
	}

	protected void createContents() {
		setText("Cadastro Cliente");
		setSize(524, 524);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
