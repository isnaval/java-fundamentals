package java_core.strings.advanced.URL_patterns;

import java.util.List;

public class CommentModerator {

	private URLExtractor extractor;
	private SecurityAnalyzer analyzer;

	public CommentModerator() {
		this.extractor = new URLExtractor();
		this.analyzer = new SecurityAnalyzer();
	}

	public ModerationResult moderateComment(String comment) {
		SecurityAnalysis analysis = analyzer.analyze(comment);
		List<String> urls = extractor.extractURLs(comment);
		List<String> emails = extractor.extractEmails(comment);

		return new ModerationResult(comment, analysis, urls, emails);
	}

	public void displayDetailedAnalysis(String comment) {
		System.out.println("\nANALISIS DETALLADO DEL COMENTARIO");
		System.out.println("=================================");
		System.out.println("Texto: \"" + comment + "\"");
		System.out.println();

		boolean hasBasicPatterns = extractor.hasBasicURLPatterns(comment);
		System.out.println("Contiene patrones URL basicos: " + hasBasicPatterns);

		List<String> urls = extractor.extractURLs(comment);
		System.out.println("URLs encontradas: " + urls.size());
		if (!urls.isEmpty()) {
			for (int i = 0; i < urls.size(); i++) {
				System.out.println("  " + (i + 1) + ". " + urls.get(i));
			}
		}

		List<String> emails = extractor.extractEmails(comment);
		if (!emails.isEmpty()) {
			System.out.println("Emails encontrados: " + emails.size());
			for (String email : emails) {
				System.out.println("  - " + email);
			}
		}

		SecurityAnalysis analysis = analyzer.analyze(comment);
		System.out.println();
		System.out.println("ANALISIS DE SEGURIDAD:");
		System.out.println(analysis);
	}

	public static class ModerationResult {
		private String originalComment;
		private SecurityAnalysis analysis;
		private List<String> extractedURLs;
		private List<String> extractedEmails;

		public ModerationResult(String comment, SecurityAnalysis analysis, List<String> urls, List<String> emails) {
			this.originalComment = comment;
			this.analysis = analysis;
			this.extractedURLs = urls;
			this.extractedEmails = emails;
		}

		public String getOriginalComment() {
			return originalComment;
		}

		public SecurityAnalysis getAnalysis() {
			return analysis;
		}

		public List<String> getExtractedURLs() {
			return extractedURLs;
		}

		public List<String> getExtractedEmails() {
			return extractedEmails;
		}

		public boolean shouldApprove() {
			return analysis.getRiskLevel() == SecurityAnalysis.RiskLevel.NONE
					|| analysis.getRiskLevel() == SecurityAnalysis.RiskLevel.LOW;
		}

		public boolean shouldReject() {
			return analysis.getRiskLevel() == SecurityAnalysis.RiskLevel.HIGH;
		}

		public boolean needsReview() {
			return analysis.getRiskLevel() == SecurityAnalysis.RiskLevel.MEDIUM;
		}
	}
}