package java_core.strings.advanced.URL_patterns;

public class SecurityAnalysis {

	public enum RiskLevel {
		NONE("NINGUNO"), LOW("BAJO"), MEDIUM("MEDIO"), HIGH("ALTO");

		private final String description;

		RiskLevel(String description) {
			this.description = description;
		}

		public String getDescription() {
			return description;
		}
	}

	private RiskLevel riskLevel;
	private String reason;
	private int urlCount;

	public SecurityAnalysis(RiskLevel riskLevel, String reason, int urlCount) {
		this.riskLevel = riskLevel;
		this.reason = reason;
		this.urlCount = urlCount;
	}

	public RiskLevel getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(RiskLevel riskLevel) {
		this.riskLevel = riskLevel;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getUrlCount() {
		return urlCount;
	}

	public void setUrlCount(int urlCount) {
		this.urlCount = urlCount;
	}

	public String getRecommendation() {
		switch (riskLevel) {
		case NONE:
			return "APROBAR - Comentario limpio sin enlaces";
		case LOW:
			return "APROBAR CON CUIDADO - Enlaces seguros detectados";
		case MEDIUM:
			return urlCount > 3 ? "REVISAR - Demasiados enlaces en un comentario"
					: "REVISAR - Enlaces detectados, verificar manualmente";
		case HIGH:
			return "RECHAZAR - Enlaces sospechosos detectados";
		default:
			return "REVISAR - Estado desconocido";
		}
	}

	@Override
	public String toString() {
		return String.format("Nivel: %s | URLs: %d | Razón: %s | Recomendación: %s", riskLevel.getDescription(),
				urlCount, reason, getRecommendation());
	}

}
