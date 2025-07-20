package fundamentals.advanced.URL_patterns;

import java.util.Scanner;

import fundamentals.advanced.URL_patterns.CommentModerator.ModerationResult;

public class URLDetectorMain {

	public static void main(String[] args) {
		URLDetectorMain app = new URLDetectorMain();
		Scanner scanner = new Scanner(System.in);

		System.out.println("MODERADOR DE COMENTARIOS - DETECTOR DE ENLACES");
		System.out.println("===============================================");
		System.out.println("Opciones:");
		System.out.println("1. Modo interactivo");
		System.out.println("2. Ejecutar tests automaticos");
		System.out.print("Selecciona una opcion (1-2): ");

		int option = scanner.nextInt();
		scanner.nextLine();

		switch (option) {
		case 1:
			app.runInteractiveMode(scanner);
			break;
		case 2:
			app.runAutomaticTests();
			break;
		default:
			System.out.println("Opcion no valida");
		}

		scanner.close();
	}

	private void runInteractiveMode(Scanner scanner) {
		CommentModerator moderator = new CommentModerator();

		System.out.println("\nMODO INTERACTIVO ACTIVADO");
		System.out.println("========================");

		while (true) {
			System.out.print("\nIntroduce un comentario (o 'salir' para terminar): ");
			String comment = scanner.nextLine();

			if (comment.equalsIgnoreCase("salir")) {
				break;
			}

			if (comment.trim().isEmpty()) {
				System.out.println("Comentario vacio, intenta de nuevo.");
				continue;
			}

			moderator.displayDetailedAnalysis(comment);

			CommentModerator.ModerationResult result = moderator.moderateComment(comment);
			System.out.println("\nDECISION RAPIDA:");
			if (result.shouldApprove()) {
				System.out.println("APROBAR automaticamente");
			} else if (result.shouldReject()) {
				System.out.println("RECHAZAR automaticamente");
			} else {
				System.out.println("ENVIAR A REVISION MANUAL");
			}
		}

		System.out.println("Modo interactivo finalizado.");
	}

	private void runAutomaticTests() {
		CommentModerator moderator = new CommentModerator();

		String[] testComments = { "Hola, que tal todo", "Mi email es usuario@ejemplo.com",
				"Visita mi web en www.ejemplo.com", "Mira este video https://youtube.com/watch?v=123",
				"Link sospechoso: http://bit.ly/abc123",
				"Muchos links: www.a.com www.b.com www.c.com www.d.com www.e.com www.f.com",
				"Redes sociales: facebook.com/miperfil y twitter.com/usuario",
				"Sitio seguro: https://github.com/usuario/proyecto" };

		System.out.println("\nEJECUTANDO TESTS AUTOMATICOS");
		System.out.println("============================");

		for (int i = 0; i < testComments.length; i++) {
			System.out.println("\nTEST " + (i + 1) + ":");
			moderator.displayDetailedAnalysis(testComments[i]);
			System.out.println("-".repeat(50));
		}

		System.out.println("\nTESTS COMPLETADOS");

		showTestStatistics(moderator, testComments);
	}

	private void showTestStatistics(CommentModerator moderator, String[] comments) {
		System.out.println("\nESTADISTICAS DE TESTS:");
		System.out.println("=====================");

		int approved = 0, rejected = 0, needReview = 0;

		for (String comment : comments) {
			ModerationResult result = moderator.moderateComment(comment);
			if (result.shouldApprove())
				approved++;
			else if (result.shouldReject())
				rejected++;
			else
				needReview++;
		}

		System.out.println("Total comentarios analizados: " + comments.length);
		System.out.println("Aprobados automaticamente: " + approved);
		System.out.println("Rechazados automaticamente: " + rejected);
		System.out.println("Requieren revision manual: " + needReview);

		double autoDecisionRate = ((double) (approved + rejected) / comments.length) * 100;
		System.out.printf("Tasa de decision automatica: %.1f%%\n", autoDecisionRate);
	}
}