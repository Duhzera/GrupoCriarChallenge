package com.grupocriar.corrida;
import Models.Volta;
import Models.Piloto;
import java.time.LocalTime;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;


public class FileReader {
	int tempoTotalCorrida = 0;
	List<Piloto> listaPiloto = new ArrayList<Piloto>();
	Piloto vencedor;
	List<Piloto> posicaoPilotos = new ArrayList<Piloto>();
	

	public List<Piloto> getPosicaoPilotos() {
		return posicaoPilotos;
	}

	public void setPosicaoPilotos(List<Piloto> posicaoPilotos) {
		this.posicaoPilotos = posicaoPilotos;
	}

	public int getTempoTotalCorrida() {
		return tempoTotalCorrida;
	}
	
	public void setTempoTotalCorrida(int tempoTotalCorrida) {
		this.tempoTotalCorrida = tempoTotalCorrida;
	}
	
	public Piloto getIdVencedor() {
		return vencedor;
	}

	public void setVencedor(Piloto vencedor) {
		this.vencedor = vencedor;
	}
	
	public List<Piloto> getListaPiloto() {
		return listaPiloto;
	}

	public void insertListaPiloto(Piloto piloto) {
		this.listaPiloto.add(piloto);
	}
	public String converterMilissegundos(int milissegundos) {
        long minutos = milissegundos / (60 * 1000);
        long segundos = (milissegundos % (60 * 1000)) / 1000;
        long milissegundosRestantes = milissegundos % 1000;

        return String.format("%02d:%02d.%03d", minutos, segundos, milissegundosRestantes);
    } 
	
	public void LerCorridaTxt(BufferedReader br){	
		
		int maxVoltas = 0; // Variavel que informa o número de voltas do primeiro Lugar;
		try {
			String linha;
			linha = br.readLine();// Instrução para ignorar a primeira Linha
			while ((linha = br.readLine()) != null) {
				Piloto piloto = new Piloto();
				Volta volta = new Volta();
				Piloto pilotoAux = null;
				String[] separar = linha.split(" ");
				if (separar.length <= 9) {
					String horaCorrida = separar[0];
	                String idPilotoCorrida = separar[1];
	                String nomePilotoCorrida = separar[3];
	                String tempoVoltaCorrida = separar[5];
	                String mediaVoltaCorrida = separar[6].replace(",", ".");

	                String[] t = tempoVoltaCorrida.split(":");
	                
	                int tempoVoltaMili = Integer.parseInt(t[0]) * 60000;
	                String t2 = t[1].replace(".","");
	                tempoVoltaMili += Integer.parseInt(t2);
	                
	    			LocalTime hora = LocalTime.parse(horaCorrida);
	    			Double mediaVolta = Double.parseDouble(mediaVoltaCorrida);
	    			
	    			piloto.setId(idPilotoCorrida);
	    			piloto.setNome(nomePilotoCorrida);
	    			
	    			volta.setHora(hora);
	    			volta.setTempVolta(tempoVoltaMili);
	    			volta.setMediaVolta(mediaVolta);
	    			
	    			for (Piloto p : listaPiloto) {
    		            if (p.getId().equals(piloto.getId())) {//estou verificando se o piloto que está na linha atual já existe na listaPiloto
    		            	pilotoAux = p; 
    		                break;
    		            }
	    		    }
	    			if (pilotoAux == null) {//Insere o piloto somente se ele ainda não estiver na lista
	    				insertListaPiloto(piloto);
	    				piloto.adicionarVolta(volta);
	    			
	    			}
	    			else if (maxVoltas < pilotoAux.adicionarVolta(volta)) {//Pega o tempo total de prova e o primeiro Lugar
						maxVoltas ++; 
						if (maxVoltas == 4) {
							setTempoTotalCorrida(pilotoAux.getTempoTotalCorrida());
							setVencedor(pilotoAux);
							
							for (Piloto p : listaPiloto) {//cria uma cópia indepente da listaPilotos, chamado posicaoPilotos para poder receber as informações dos Pilotos até que o primeiro de 4 voltas
								ArrayList<Volta> lv = new ArrayList<Volta>();
								for (Volta v : p.getVoltas()) {
									lv.add(new Volta(v.getHora(),v.getTempVolta(),v.getMediaVolta()));
								}
								posicaoPilotos.add(new Piloto(p.getId(),p.getNome(),lv));
							}
						}						
					}
				}
			}
			
		}
		catch (Exception e){
			System.out.println(e);
		}
		
	}




	

	


	

	
}

