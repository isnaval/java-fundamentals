package java_advanced_testing.resources.config;

/**
 * Clase de configuración centralizada para todos los tests del sistema.
 * 
 * CONTENIDO DE LA CLASE: • Configuración de timeouts para diferentes tipos de
 * tests • Configuración de reintentos para tests fallidos • Umbrales de
 * rendimiento y límites de datos • Precisión decimal para comparaciones
 * numéricas • Categorías y clasificación de tests • Configuración de logging y
 * debugging • Rutas de archivos para datos de test • Reglas de validación para
 * objetos de prueba • Métodos utilitarios para obtener configuración dinámica
 * 
 */

public class TestConfiguration {
	// ===== TIMEOUTS =====
	public static final int DEFAULT_TIMEOUT = 5000;
	public static final int LONG_TIMEOUT = 10000;
	public static final int SHORT_TIMEOUT = 1000;
	public static final int PERFORMANCE_TIMEOUT = 30000;

	// ===== RETRY CONFIGURATION =====
	public static final int MAX_RETRY_ATTEMPTS = 3;
	public static final int RETRY_DELAY_MS = 500;
	public static final int RETRY_BACKOFF_MULTIPLIER = 2;

	// ===== PERFORMANCE THRESHOLDS =====
	public static final int PERFORMANCE_THRESHOLD_MS = 1000;
	public static final int BULK_TEST_SIZE = 1000;
	public static final int LARGE_DATASET_SIZE = 10000;
	public static final int CONCURRENT_THREADS = 10;

	// ===== TEST DATA LIMITS =====
	public static final int MAX_TEST_BOOKS = 100;
	public static final int MAX_TEST_CUSTOMERS = 50;
	public static final int MAX_TEST_EMPLOYEES = 25;
	public static final double MAX_TEST_PRICE = 999.99;
	public static final double MIN_TEST_PRICE = 0.01;

	// ===== PRECISION AND TOLERANCE =====
	public static final double PRICE_PRECISION = 0.01;
	public static final double PERCENTAGE_PRECISION = 0.1;
	public static final double SALARY_PRECISION = 0.01;

	// ===== TEST CATEGORIES =====
	public static final String UNIT_TEST_CATEGORY = "unit";
	public static final String INTEGRATION_TEST_CATEGORY = "integration";
	public static final String PERFORMANCE_TEST_CATEGORY = "performance";
	public static final String FUNCTIONAL_TEST_CATEGORY = "functional";

	// ===== LOGGING CONFIGURATION =====
	public static final String LOG_LEVEL = "DEBUG";
	public static final boolean ENABLE_TEST_LOGGING = true;
	public static final boolean ENABLE_PERFORMANCE_LOGGING = true;
	public static final boolean ENABLE_ERROR_DETAILS = true;

	// ===== FILE PATHS =====
	public static final String CSV_DATA_PATH = "src/foundations/test/java_advanced_testing/resources/output/csv/";
	public static final String JSON_DATA_PATH = "src/foundations/test/java_advanced_testing/resources/output/json/";
	public static final String TEST_OUTPUT_PATH = "src/foundations/tets/java_advanced_testing/resources/output/test-output/";

	// ===== VALIDATION RULES =====
	public static final int MIN_BOOK_TITLE_LENGTH = 1;
	public static final int MAX_BOOK_TITLE_LENGTH = 100;
	public static final int MIN_CUSTOMER_NAME_LENGTH = 2;
	public static final int MAX_CUSTOMER_NAME_LENGTH = 50;

	// Método para obtener timeout basado en tipo de test
	public static int getTimeoutForTestType(String testType) {
		return switch (testType.toLowerCase()) {
		case "unit" -> SHORT_TIMEOUT;
		case "integration" -> DEFAULT_TIMEOUT;
		case "performance" -> PERFORMANCE_TIMEOUT;
		case "functional" -> LONG_TIMEOUT;
		default -> DEFAULT_TIMEOUT;
		};
	}

	// Método para obtener el tamaño de dataset según el tipo de test
	public static int getDatasetSizeForTest(String testType) {
		return switch (testType.toLowerCase()) {
		case "unit" -> 10;
		case "integration" -> 100;
		case "performance" -> BULK_TEST_SIZE;
		case "load" -> LARGE_DATASET_SIZE;
		default -> 50;
		};
	}

	// Método para verificar si está habilitado el logging para un nivel
	public static boolean isLoggingEnabled(String level) {
		return ENABLE_TEST_LOGGING && ("DEBUG".equalsIgnoreCase(level) || "INFO".equalsIgnoreCase(level)
				|| "ERROR".equalsIgnoreCase(level));
	}

}
