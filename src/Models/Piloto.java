package Models;

import java.util.ArrayList;

public class Piloto {
	
	
	private String id;
	private String nome;
	private ArrayList<Volta> voltas = new ArrayList<Volta>();//Todas as voltas com os dados delas
	
	public Piloto(String id, String nome, ArrayList<Volta> voltas) {
		super();
		this.id = id;
		this.nome = nome;
		this.voltas = voltas;
	}
	
	public Piloto() {
		super();
	}
	public int getMelhorVolta() {
		int aux = getTempoTotalCorrida();
		for(Volta v : voltas) {
			if(v.getTempVolta() < aux) {
				aux = v.getTempVolta();
			}
		}
		return aux;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getTempoTotalCorrida() {
		int tempoTotalCorrida = 0;
		for (Volta v: voltas) {
			tempoTotalCorrida += v.getTempVolta();
		}
		return tempoTotalCorrida;
	}

	public double getMediaVelocidadeCorrida(){
		double mediaVelocidadeCorrida = 0;
		for (Volta v : voltas) {
			mediaVelocidadeCorrida += v.getMediaVolta(); 
		}
		mediaVelocidadeCorrida = mediaVelocidadeCorrida / getNumeroVoltas();
		
		return mediaVelocidadeCorrida;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNumeroVoltas() {
		return this.voltas.size();
	}
	public void setNumeroVoltas(int numeroVoltas) {
		this.voltas.clear();
	}
	public void setVoltas(ArrayList<Volta> voltas) {
		this.voltas = voltas;
	}
	public ArrayList<Volta>getVoltas(){
		return this.voltas;
	}
	public int adicionarVolta (Volta volta) {
		this.voltas.add(volta);
		return getNumeroVoltas();
	}
	
	public String toString() {
        return "Piloto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", voltas=" + voltas.toString() +
                '}';
    }
	
}
