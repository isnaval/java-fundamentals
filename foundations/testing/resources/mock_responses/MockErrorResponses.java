package java_advanced_testing.resources.mock_responses;

public class MockErrorResponses {
	public static String getNotFoundError() {
		return "{\"error\": \"Resource not found\", \"code\": 404}";
	}

	public static String getBadRequestError() {
		return "{\"error\": \"Invalid request data\", \"code\": 400}";
	}

	public static String getServerError() {
		return "{\"error\": \"Internal server error\", \"code\": 500}";
	}

	public static String getUnauthorizedError() {
		return "{\"error\": \"Unauthorized access\", \"code\": 401}";
	}
}
