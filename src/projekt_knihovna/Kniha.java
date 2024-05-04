package projekt_knihovna;

public class Kniha {

	private String jmeno;
	private String autor;
	private int rok;
	private boolean dostupna;
	private String zanr;
	private int vhodnost;
	
	public Kniha(String jmeno, String autor, int rok, boolean dostupna, String zanr, int vhodnost)
	{
		this.jmeno = jmeno;
		this.autor = autor;
		this.rok = rok;
		this.dostupna = dostupna;
		this.zanr = zanr;
		this.vhodnost = vhodnost;
		
	}
	
	public String getJmeno() {
		return jmeno;
	}
	
	public void setJmeno(String jmeno) {
		this.jmeno = jmeno;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public int getRok() {
		return rok;
	}
	
	public void setRok(int rok) {
		this.rok = rok;
	}
	
	public boolean getDostupna() {
		return dostupna;
	}
	
	public void setDostupna(boolean dostupna) {
		this.dostupna = dostupna;
	}
	
	public String getZanr() {
		return zanr;
	}
	
	public void setZanr(String zanr) {
		this.zanr = zanr;
	}
	
	public int getVhodnost() {
		return vhodnost;
	}
	
	public void setVhodnost(int vhodnost) {
		this.vhodnost = vhodnost;
	}
	
}
