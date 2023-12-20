package Models;

import java.util.ArrayList;


public class Piloto {
	private int id;
	private String nome;
	private ArrayList<Volta> voltas = new ArrayList<>();//Todas as voltas com os dados delas
	
	public Piloto() {
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
