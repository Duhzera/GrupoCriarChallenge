package Models;

import com.grupocriar.corrida.*;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class main {
	public static void main (String[]args){
		String caminhoArquivo = "C:\\Projeto\\TesteDesenvolvimentoGrupoCriar\\Utils\\Corrida.txt";
		ArrayList<Piloto> listaPilotos = new ArrayList<>();
		FileReader f = new FileReader();
		try(BufferedReader br = new BufferedReader (new InputStreamReader(new FileInputStream(new File (caminhoArquivo))));){
			listaPilotos = (ArrayList<Piloto>) f.LerCorridaTxt(br);
			

		}
	
		
		catch (Exception e) {
			System.out.println("Erro de leitura de arquivo");
		}
		
		System.out.println(listaPilotos.get(2).getVoltas());
		
	}
}
