package Models;

import java.time.LocalTime;

public class Volta {
	
	private LocalTime hora;
	private LocalTime tempVolta;
	private double mediaVolta;
	
	public Volta(LocalTime hora, int volta, LocalTime tempVolta, double mediaVolta) {
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
