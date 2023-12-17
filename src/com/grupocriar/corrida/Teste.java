package com.grupocriar.corrida;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import Models.Corrida;
import Models.Piloto;

public class Teste {
	public static void main (String[]args){
		
		try(BufferedReader br = new BufferedReader (new InputStreamReader(
				new FileInputStream(new File ("C:\\Projeto\\TesteDesenvolvimentoGrupoCriar\\Utils\\Corrida.txt"))));){
			List<Piloto> piloto = new ArrayList<Piloto>();
			String linha;	
			while ((linha = br.readLine()) != null) {
				Piloto piloto1 = new Piloto();
				Corrida corrida = new Corrida();
				
				String[] separar = linha.split(" ");
				if (separar.length <= 9) {
					String hourStr = separar[0];
	                String idStr = separar[1];
	                String name = separar[3];
	                String lapNumberStr = separar[4];
	                String lapTimeStr = separar[5];
	                String averageSpeedStr = separar[6];

				}
				System.out.println(separar[3]);
			}
		}
		catch (Exception e) {
			System.out.println("Erro de leitura de arquivo");
		}
		
	}
}
