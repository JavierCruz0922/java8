package domain;

public class Saludo {

	private String men;

	public Saludo(String men){
		this.men = men;
	}

	public String getMen(){
		return this.men;
	}

	public void setMen(String men){
		this.men = men;
	}

	@Override
	public String toString(){
		return men;
	}

}