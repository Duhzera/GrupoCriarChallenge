package Models;

import com.grupocriar.corrida.*;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class Corrida {
	public static void main (String[]args){
		String caminhoArquivo = "C:\\Projeto\\TesteDesenvolvimentoGrupoCriar\\Utils\\Corrida.txt";
		ArrayList<Piloto> listaPilotos;
		ArrayList<Piloto> qualificacao;
		ArrayList<Integer> melhorVoltaPiloto = new ArrayList<Integer>();
		int melhorVoltaCorrida;
		String melhorPiloto = "";
		Piloto aux;
		int posicao = 1;
		
		FileReader f = new FileReader();
		try(BufferedReader br = new BufferedReader (new InputStreamReader(new FileInputStream(new File (caminhoArquivo))));){
			f.LerCorridaTxt(br);
		}
		catch (Exception e) {
			System.out.println("Erro de leitura de arquivo ");
		}
		listaPilotos = (ArrayList<Piloto>) f.getListaPiloto();
		qualificacao = (ArrayList<Piloto>) f.getPosicaoPilotos();
		
		System.out.println("==================================================================================================");
		System.out.println("======================================Resultado da corrida========================================\n");
		for (Piloto p : qualificacao) {
			aux = p;
			for(Piloto p1 : qualificacao) {
				if(aux.getNumeroVoltas() < p1.getNumeroVoltas()) {
					aux = p1;
				}
				else if(aux.getNumeroVoltas() == p1.getNumeroVoltas()) {
					if(aux.getTempoTotalCorrida() > p1.getTempoTotalCorrida()) {
						aux = p1;
					}
				}
			}
			
			System.out.println(posicao + "º Lugar: ID " + aux.getId() + " | Nome: "
					+ aux.getNome() + " \t| Qtde Voltas Completadas: " + aux.getNumeroVoltas() + " | Tempo de Prova: "
					+ f.converterMilissegundos(aux.getTempoTotalCorrida()));
			//if(p.getNumeroVoltas() == vencedor.getNumeroVoltas() -1){
			posicao ++;
			aux.setNumeroVoltas(0);
		}
		System.out.println("\n==================================Melhores Voltas e Média de Velocidade===========================\n");
		
		melhorVoltaCorrida = f.getTempoTotalCorrida();
		
		for(Piloto p: listaPilotos) {
			if (melhorVoltaCorrida > p.getMelhorVolta()) {
				melhorPiloto = p.getNome();
				melhorVoltaCorrida = p.getMelhorVolta();
			}
			System.out.print("Piloto: " + p.getNome() + " \t | Melhor Volta: " + f.converterMilissegundos(p.getMelhorVolta())  + " | Velocidade Média: ");
			System.out.printf("%.3f \n", p.getMediaVelocidadeCorrida());
			melhorVoltaPiloto.add(p.getMelhorVolta());
		}
		
		System.out.println("\n===========================================A Melhor Volta=========================================\n");
		System.out.println("Melhor volta da corrida: " + f.converterMilissegundos(melhorVoltaCorrida) + " | Piloto: " + melhorPiloto);
		System.out.println("\n==================================================================================================");
		
	}
}
