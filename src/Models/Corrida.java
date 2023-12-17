package Models;

import java.time.LocalTime;

public class Corrida {
	
	public Corrida(LocalTime hora, int volta, LocalTime tempVolta, double mediaVolta) {
		super();
		this.hora = hora;
		this.volta = volta;
		this.tempVolta = tempVolta;
		this.mediaVolta = mediaVolta;
	}

	public Corrida(LocalTime hora, Piloto piloto, int volta, LocalTime tempVolta, double mediaVolta) {
		super();
		this.hora = hora;
		this.piloto = piloto;
		this.volta = volta;
		this.tempVolta = tempVolta;
		this.mediaVolta = mediaVolta;
	}
	
	public Corrida() {
		super();
	}
	
	private LocalTime hora;
	private Piloto piloto;
	private int volta;
	private LocalTime tempVolta;
	private double mediaVolta;
	
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	public Piloto getPiloto() {
		return piloto;
	}
	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}
	public int getVolta() {
		return volta;
	}
	public void setVolta(int volta) {
		this.volta = volta;
	}
	public LocalTime getTempVolta() {
		return tempVolta;
	}
	public void setTempVolta(LocalTime tempVolta) {
		this.tempVolta = tempVolta;
	}
	public double getMediaVolta() {
		return mediaVolta;
	}
	public void setMediaVolta(double mediaVolta) {
		this.mediaVolta = mediaVolta;
	}
	
}
