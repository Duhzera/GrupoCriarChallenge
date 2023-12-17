package com.grupocriar.corrida;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import Models.Corrida;
import Models.Piloto;

public class Teste {
	public static void main (String[]args){
		
		try(BufferedReader br = new BufferedReader (new InputStreamReader(
				new FileInputStream(new File ("C:\\Projeto\\TesteDesenvolvimentoGrupoCriar\\Utils\\Corrida.txt"))));){
			List<Piloto> listaPiloto = new ArrayList<Piloto>();
	        
			String linha;	
			while ((linha = br.readLine()) != null) {
				Piloto piloto = new Piloto();
				Corrida corrida = new Corrida();
				
				String[] separar = linha.split(" ");
				if (separar.length <= 9) {
					String horaCorrida = separar[0];
	                String idPilotoCorrida = separar[1];
	                String nomePilotoCorrida = separar[3];
	                String voltaCorrida = separar[4];
	                String tempoVoltaCorrida = "00:0" + separar[5];
	                String mediaVoltaCorrida = separar[6].replace(",", ".");

	                int id = Integer.parseInt(idPilotoCorrida);
	    			piloto.setId(id);
	    			piloto.setNome(nomePilotoCorrida);
	    			
	    			LocalTime hora = LocalTime.parse(horaCorrida);
	    			int volta = Integer.parseInt(voltaCorrida);
	  	    		LocalTime tempVolta = LocalTime.parse(tempoVoltaCorrida, DateTimeFormatter.ofPattern("HH:mm:ss.SSS"));
	    			Double mediaVolta = Double.parseDouble(mediaVoltaCorrida);
	    			
	    			corrida.setHora(hora);
	    			corrida.setPiloto(piloto);
	    			corrida.setVolta(volta);
	    			corrida.setTempVolta(tempVolta);
	    			corrida.setMediaVolta(mediaVolta);
				}
				
				
			}
		}
		catch (Exception e) {
			System.out.println("Erro de leitura de arquivo");
		}
		
	}
}
