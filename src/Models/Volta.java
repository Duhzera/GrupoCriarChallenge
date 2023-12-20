package Models;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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
	public String toString() {
		return " Horário da Corrida: " + this.hora + 
				" Tempo da Volta: " + this.tempVolta + 
				" Tempo Médio da volta: " + this.mediaVolta;
	}
	public static Duration convertDuration(LocalTime d) {
		return Duration.between(LocalTime.MIDNIGHT, d);
	}
	 public static LocalTime formatDurationToLocalTime(Duration duracao) {
	        long totalMillis = duracao.toMillis();
	        int horas = (int) (totalMillis / 3600000);
	        int minutos = (int) ((totalMillis % 3600000) / 60000);
	        int segundos = (int) ((totalMillis % 60000) / 1000);
	        int milissegundos = (int) (totalMillis % 1000);

	        return LocalTime.of(horas, minutos, segundos, milissegundos * 1_000_000);
	    }
	public static LocalTime somaVoltas(Piloto p) {
		ArrayList<Volta> voltas = p.getVoltas();
		Duration somaTodasVoltas = Duration.ZERO;
		p.getVoltas();
		for (Volta volta : voltas) {
            LocalTime tempoVolta = volta.getTempVolta();
            Duration duracaoVolta = convertDuration(tempoVolta);

            somaTodasVoltas = somaTodasVoltas.plus(duracaoVolta);
        }
		
		return formatDurationToLocalTime(somaTodasVoltas);
	}
	public int posicao() {
		
		return posicao();
	}
}
