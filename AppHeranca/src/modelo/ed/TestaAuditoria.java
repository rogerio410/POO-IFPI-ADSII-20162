package modelo.ed;

public class TestaAuditoria {
	
	public static void main(String[] args) {
		
		Pilha p = new Pilha();
		
		
		Auditoria audi = new Auditoria();
		audi.gravarEmDisco(p);
		
		
	}

}
