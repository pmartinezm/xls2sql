package modelo;

public enum Messages {
	InvalidFile("El fichero no cumple los requisitos o est� da�ado.");
	
	String msg;
	Messages(String msg){
		this.msg = msg;
	}
	
	@Override
	public String toString() {
		return this.msg;
	}
}
