package java_core.strings.advanced.URL_patterns;

public class SecurityAnalyzer {

	private URLExtractor extractor;

	public SecurityAnalyzer() {
		this.extractor = new URLExtractor();
	}

	public SecurityAnalysis analyze(String text) {
		String lowerText = text.toLowerCase();
		int urlCount = extractor.countURLs(text);

		if (extractor.containsSuspiciousShorteners(text)) {
			return new SecurityAnalysis(SecurityAnalysis.RiskLevel.HIGH, "Contiene acortadores de URL sospechosos",
					urlCount);
		}

		if (urlCount > 5) {
			return new SecurityAnalysis(SecurityAnalysis.RiskLevel.HIGH, "Exceso de enlaces detectados (posible spam)",
					urlCount);
		}

		if (urlCount == 0 && !extractor.hasBasicURLPatterns(text)) {
			return new SecurityAnalysis(SecurityAnalysis.RiskLevel.NONE, "No se detectaron URLs", 0);
		}

		if (extractor.containsSocialMedia(text)) {
			return new SecurityAnalysis(SecurityAnalysis.RiskLevel.LOW, "URLs de redes sociales conocidas", urlCount);
		}

		if (lowerText.contains("https://")) {
			return new SecurityAnalysis(SecurityAnalysis.RiskLevel.LOW, "Conexion segura HTTPS detectada", urlCount);
		}

		if (lowerText.contains("http://")) {
			return new SecurityAnalysis(SecurityAnalysis.RiskLevel.MEDIUM, "Conexion no segura HTTP detectada",
					urlCount);
		}

		if (extractor.hasBasicURLPatterns(text)) {
			return new SecurityAnalysis(SecurityAnalysis.RiskLevel.MEDIUM, "Patron de URL detectado sin protocolo",
					urlCount);
		}

		return new SecurityAnalysis(SecurityAnalysis.RiskLevel.MEDIUM, "URLs detectadas requieren revision", urlCount);
	}
}