package Models;

import java.util.ArrayList;

public class Piloto {
	public Piloto() {

	}
	private int id;
	private String nome;
	private ArrayList<Corrida> voltas = new ArrayList<>();//Todas as voltas com os dados delas
	
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
	public ArrayList<Corrida> getVoltas() {
		return voltas;
	}
	public void setVoltas(ArrayList<Corrida> voltas) {
		this.voltas = voltas;
	}
	
	public void adcionar (Corrida c) {
		this.voltas.add(c);
	}
	
}
