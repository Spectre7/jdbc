package corso.ereditarieta;
public class Cubo extends Solido implements Colorabile {
		private double lato;
		private String colore;
		public void setColore(String colore){
			this.colore=colore;
		}
	public Cubo(double lato,double pesoSpecifico){
		super(pesoSpecifico);
		this.lato=lato;
	}
	public double volume(){
		return Math.pow(lato,3);
	}
	public double superfice(){
		return 6*lato*lato;
	}
	public String toString(){
		return "Cubo:"+super.toString()+"lato="+lato;
	}
}