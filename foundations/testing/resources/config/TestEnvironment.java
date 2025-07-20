package java_advanced_testing.resources.config;

/**
 * Gestor de ambientes de testing con configuración automática.
 * 
 * CONTENIDO DE LA CLASE: • Enum de ambientes (LOCAL, CI, STAGING, PRODUCTION) •
 * Detección automática del ambiente desde system properties • Configuración
 * dinámica según el ambiente actual • Control de modo debug y servicios mock •
 * Métodos de verificación de ambiente • Configuración automática de parámetros
 * por ambiente • Recomendaciones de configuración específicas • Información y
 * utilidades del ambiente actual • Inicialización automática al cargar la clase
 */

public class TestEnvironment {
	// ===== ENUM DE AMBIENTES =====
	public enum Environment {
		LOCAL("local", "Desarrollo local"), CI("ci", "Integración continua"), STAGING("staging", "Ambiente de staging"),
		PRODUCTION("production", "Ambiente de producción");

		private final String name;
		private final String description;

		Environment(String name, String description) {
			this.name = name;
			this.description = description;
		}

		public String getName() {
			return name;
		}

		public String getDescription() {
			return description;
		}
	}

	// ===== CONFIGURACIÓN ACTUAL =====
	private static Environment currentEnvironment = Environment.LOCAL;
	private static boolean debugMode = true;
	private static boolean mockExternalServices = true;

	// ===== MÉTODOS DE CONFIGURACIÓN =====
	public static Environment getCurrentEnvironment() {
		return currentEnvironment;
	}

	public static void setEnvironment(Environment env) {
		currentEnvironment = env;
		adjustConfigurationForEnvironment(env);
	}

	public static void setEnvironment(String envName) {
		for (Environment env : Environment.values()) {
			if (env.getName().equalsIgnoreCase(envName)) {
				setEnvironment(env);
				return;
			}
		}
		throw new IllegalArgumentException("Ambiente desconocido: " + envName);
	}

	// ===== MÉTODOS DE VERIFICACIÓN =====
	public static boolean isLocal() {
		return currentEnvironment == Environment.LOCAL;
	}

	public static boolean isCI() {
		return currentEnvironment == Environment.CI;
	}

	public static boolean isStaging() {
		return currentEnvironment == Environment.STAGING;
	}

	public static boolean isProduction() {
		return currentEnvironment == Environment.PRODUCTION;
	}

	public static boolean isDebugMode() {
		return debugMode;
	}

	public static boolean shouldMockExternalServices() {
		return mockExternalServices;
	}

	// ===== CONFIGURACIÓN AUTOMÁTICA =====
	private static void adjustConfigurationForEnvironment(Environment env) {
		switch (env) {
		case LOCAL:
			debugMode = true;
			mockExternalServices = true;
			break;
		case CI:
			debugMode = false;
			mockExternalServices = true;
			break;
		case STAGING:
			debugMode = false;
			mockExternalServices = false;
			break;
		case PRODUCTION:
			debugMode = false;
			mockExternalServices = false;
			break;
		}
	}

	// ===== MÉTODOS DE CONFIGURACIÓN MANUAL =====
	public static void enableDebugMode() {
		debugMode = true;
	}

	public static void disableDebugMode() {
		debugMode = false;
	}

	public static void enableMocking() {
		mockExternalServices = true;
	}

	public static void disableMocking() {
		mockExternalServices = false;
	}

	// ===== INFORMACIÓN DEL AMBIENTE =====
	public static void printCurrentConfiguration() {
		System.out.println("=== CONFIGURACIÓN DE TESTING ===");
		System.out.println("Ambiente: " + currentEnvironment.getDescription());
		System.out.println("Modo debug: " + (debugMode ? "Habilitado" : "Deshabilitado"));
		System.out.println("Mock services: " + (mockExternalServices ? "Habilitado" : "Deshabilitado"));
		System.out.println("Timeouts: " + getTimeoutConfiguration());
		System.out.println("================================");
	}

	private static String getTimeoutConfiguration() {
		return switch (currentEnvironment) {
		case LOCAL -> "Normales (desarrollo)";
		case CI -> "Extendidos (CI)";
		case STAGING -> "Normales (staging)";
		case PRODUCTION -> "Cortos (producción)";
		};
	}

	// ===== INICIALIZACIÓN AUTOMÁTICA =====
	static {
		String envVar = System.getProperty("test.environment", "local");
		try {
			setEnvironment(envVar);
		} catch (IllegalArgumentException e) {
			System.out.println("⚠️ Ambiente no reconocido '" + envVar + "', usando LOCAL por defecto");
			setEnvironment(Environment.LOCAL);
		}

		if (debugMode) {
			System.out.println("🔧 Test Environment inicializado: " + currentEnvironment.getName());
		}
	}

	// ===== UTILIDADES =====
	public static String getEnvironmentInfo() {
		return String.format("Environment: %s (%s), Debug: %s, Mocking: %s", currentEnvironment.getName(),
				currentEnvironment.getDescription(), debugMode, mockExternalServices);
	}

	public static boolean shouldRunPerformanceTests() {
		return currentEnvironment != Environment.CI;
	}

	public static boolean shouldRunIntegrationTests() {
		return currentEnvironment == Environment.LOCAL || currentEnvironment == Environment.STAGING;
	}

	public static int getRecommendedThreadCount() {
		return switch (currentEnvironment) {
		case LOCAL -> 4;
		case CI -> 2;
		case STAGING -> 8;
		case PRODUCTION -> 1;
		};
	}

}
