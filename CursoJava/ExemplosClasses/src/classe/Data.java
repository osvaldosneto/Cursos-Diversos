package classe;

public class Data {
	
	int dia, mes, ano;
	
	public Data() {
		//this.dia = 1;
		//this.ano = 1970;
		//this.mes = 1;
		this(1, 1, 1970);
	}

	public Data(int dia, int mes, int ano) {
		this.dia = dia;
		this.ano = ano;
		this.mes = mes;
	}
	
	public String obterDataFormatada() {
		return dia+"/"+mes+"/"+ano;
	}
	
	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
	

}
