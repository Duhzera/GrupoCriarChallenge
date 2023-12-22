package Models;

import java.time.LocalTime;


public class Volta {
	
	private LocalTime hora;
	private int tempVolta;
	private double mediaVolta;
	
	public Volta(LocalTime hora, int tempVolta, double mediaVolta) {
		super();
		this.hora = hora;
		this.tempVolta = tempVolta;
		this.mediaVolta = mediaVolta;
	}
	
	public Volta() {
		super();
	}
	
	
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public int getTempVolta() {
		return tempVolta;
	}
	public void setTempVolta(int tempVolta) {
		this.tempVolta = tempVolta;
	}
	public double getMediaVolta() {
		return mediaVolta;
	}
	public void setMediaVolta(double mediaVolta) {
		this.mediaVolta = mediaVolta;
	}
	public String toString() {
		return " Horário da Corrida: " + this.hora + 
				" Tempo da Volta: " + this.tempVolta + 
				" Tempo Médio da volta: " + this.mediaVolta;
	}
	
	
}
