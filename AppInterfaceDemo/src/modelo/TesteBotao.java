package modelo;

public class TesteBotao {
	
	public static void main(String[] args) {
		
		Button button = new Button();
		button.setLabel("Clique aqui.");
		
		button.setEscutador(new MeuEscutador());
		
		Button btnK = new Button("Vamos lanchar Ka...");
		
		//Dedinho na tela
		button.clicar();
		
		btnK.setEscutador(new Escutador() {
			
			@Override
			public void onClick() {
				System.out.println("Vamos...");
			}
		});
		//btnK.clicar();
		
		Button btnP = new Button(){
			@Override
			public void setLabel(String label) {
				super.setLabel("Clica Paulo.");
			}
			
			public void setEscutador(Escutador escutador) {
				super.setEscutador(new Escutador() {
					
					@Override
					public void onClick() {
						System.out.println("Clicou no BtnP");
					}
				});
			}
		};
		btnP.setEscutador(null);
		btnP.clicar();
		
		
	}

}
