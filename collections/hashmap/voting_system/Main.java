package collections.hashmap.voting_system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
	    System.out.print("Ingrese el número de rondas: ");
		int rounds = scanner.nextInt();
		
		for(int i = 1; i <= rounds; i++) {
			System.out.println("=== Ejecución " + i + " de createRandom ===");
			VoteOption[] votes = Votation.createRandom();
			Map<VoteOption, Integer> results = VotationCounter.countVotes(votes);
			for (VoteOption option : VoteOption.values()) {
				System.out.println(option.getName() + ": " + results.getOrDefault(option, 0) + " votos");
			}
            
			System.out.println();
		}
		
//		Map<VoteOption, Integer> totalVotes = new HashMap<>();
//		
//		// Ejecutar el número de rondas especificado
//        for (int i = 1; i <= rounds; i++) {
//            System.out.println("=== Ejecución " + i + " de createRandom ===");
//            // Generar 1000 votos aleatorios
//            VoteOption[] votes = Votation.createRandom();
//            // Contar los votos de la ronda actual
//            Map<VoteOption, Integer> results = VotationCounter.countVotes(votes);
//            // Imprimir los resultados para cada opción
//            for (VoteOption option : VoteOption.values()) {
//                int count = results.getOrDefault(option, 0);
//                System.out.println(option.getName() + ": " + count + " votos");
//                // Acumular los votos en el mapa total
//                totalVotes.put(option, totalVotes.getOrDefault(option, 0) + count);
//            }
//            System.out.println(); // Línea en blanco para separar rondas
//        }
//
//        // Determinar y mostrar la opción con más votos en total
//        if (!totalVotes.isEmpty()) {
//            // Encontrar el conteo máximo
//            int maxVotes = 0;
//            for (int count : totalVotes.values()) {
//                if (count > maxVotes) {
//                    maxVotes = count;
//                }
//            }
//
//            // Recolectar todas las opciones con el conteo máximo (en caso de empate)
//            List<VoteOption> winners = new ArrayList<>();
//            for (Map.Entry<VoteOption, Integer> entry : totalVotes.entrySet()) {
//                if (entry.getValue() == maxVotes) {
//                    winners.add(entry.getKey());
//                }
//            }
//
//            // Mostrar el ganador o empate
//            System.out.println("=== Resultado final tras " + rounds + " rondas ===");
//            if (winners.size() == 1) {
//                System.out.println("Ganador: " + winners.get(0).getName() + " con " + maxVotes + " votos en total");
//            } else {
//                System.out.print("Empate entre: ");
//                for (int j = 0; j < winners.size(); j++) {
//                    System.out.print(winners.get(j).getName());
//                    if (j < winners.size() - 1) {
//                        System.out.print(", ");
//                    }
//                }
//                System.out.println(" con " + maxVotes + " votos en total");
//            }
//        } else {
//            System.out.println("No hay votos para determinar un ganador");
//        }
//
//        // Cerrar el Scanner
//        scanner.close();
		
	}
}
