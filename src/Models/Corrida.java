package Models;

import java.time.LocalTime;

public class Corrida {
	public Corrida() {
		super();
	}
	private LocalTime hora;
	private int idPiloto;
	private int volta;
	private LocalTime tempVolta;
	private double mediaVolta;
	
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	public int getIdPiloto() {
		return idPiloto;
	}
	public void setIdPiloto(int idPiloto) {
		this.idPiloto = idPiloto;
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
