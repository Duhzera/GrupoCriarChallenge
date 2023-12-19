package com.grupocriar.corrida;
import Models.Volta;
import Models.Piloto;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class FileReader {
	
	public List<Piloto> LerCorridaTxt(BufferedReader br){	
		List<Piloto> listaPiloto = new ArrayList<Piloto>();
		int maxVoltas = 0; // Variavel que informa o número de voltas do primeiro Lugar;
		try {
			String linha;
			linha = br.readLine();// Instrução para ignorar a primeira Linha
			
			while ((linha = br.readLine()) != null && maxVoltas != 4) {
				Piloto piloto = new Piloto();
				Volta volta = new Volta();
				
				String[] separar = linha.split(" ");
				if (separar.length <= 9) {
					String horaCorrida = separar[0];
	                String idPilotoCorrida = separar[1];
	                String nomePilotoCorrida = separar[3];
	                String voltaCorrida = separar[4];
	                String tempoVoltaCorrida = "00:0" + separar[5];
	                String mediaVoltaCorrida = separar[6].replace(",", ".");

	                int id = Integer.parseInt(idPilotoCorrida);
	    			LocalTime hora = LocalTime.parse(horaCorrida);
	    			int qntVolta = Integer.parseInt(voltaCorrida);
	  	    		LocalTime tempVolta = LocalTime.parse(tempoVoltaCorrida, DateTimeFormatter.ofPattern("HH:mm:ss.SSS"));
	    			Double mediaVolta = Double.parseDouble(mediaVoltaCorrida);
	    			
	    			
	    			piloto.setId(id);
	    			piloto.setNome(nomePilotoCorrida);
	    			
	    			volta.setHora(hora);
	    			volta.setTempVolta(tempVolta);
	    			volta.setMediaVolta(mediaVolta);
	    			boolean pilotoExiste = false;	
	    			 for (Piloto p : listaPiloto) {
	    		            if (p.getId() == piloto.getId()) {
	    		            	pilotoExiste = true;
	    		                break;
	    		            }
	    		        }
	    			if (!pilotoExiste) {//Insere o piloto somente se ele ainda não estiver na lista
	    				listaPiloto.add(piloto);
	    				System.out.println(piloto.toString());
	    			}
	    			
	    			/* for (Piloto p : listaPiloto){
	    				if (p.getId() == piloto.getId()) {
	    					if (maxVoltas < p.adicionarVolta(volta)) {
	    						maxVoltas ++; 
	    						//p.adicionarVolta(volta);
	    					}
	    				}
	    			}*/

				}
			}
		}
		catch (Exception e){
			System.out.println("Erro de leitura de arquivo");
		}
		
		return listaPiloto;
	}

	
}

