package java_advanced_testing.mock_test;

import java_advanced_testing.resources.mock_responses.MockCustomerResponses;
import java_advanced_testing.resources.mock_responses.MockErrorResponses;

public class CustomerApiTest {
	public static void main(String[] args) {
		System.out.println("CUSTOMER API MOCK TESTS");
		System.out.println("=======================");

		testValidCustomerResponse();
		testInvalidEmailResponse();
		testMinorCustomerResponse();
		testErrorHandling();

		System.out.println("\nCustomer API tests completados");
	}

	public static void testValidCustomerResponse() {
		System.out.println("\n--- Test: Valid Customer Response ---");

		String mockResponse = MockCustomerResponses.getValidCustomerResponse();

		boolean hasValidFormat = isValidJsonResponse(mockResponse);
		boolean hasRequiredFields = hasCustomerFields(mockResponse);
		boolean hasValidId = mockResponse.contains("\"id\": 1");

		System.out.println("Mock response: " + mockResponse);
		System.out.println("Valid JSON format: " + (hasValidFormat ? "PASS" : "FAIL"));
		System.out.println("Has required fields: " + (hasRequiredFields ? "PASS" : "FAIL"));
		System.out.println("Has valid ID: " + (hasValidId ? "PASS" : "FAIL"));

		String customerName = extractField(mockResponse, "name");
		String customerEmail = extractField(mockResponse, "email");

		System.out.println("Extracted name: " + customerName);
		System.out.println("Extracted email: " + customerEmail);

		boolean validExtraction = customerName != null && customerEmail != null;
		System.out.println("Data extraction: " + (validExtraction ? "PASS" : "FAIL"));
	}

	public static void testInvalidEmailResponse() {
		System.out.println("\n--- Test: Invalid Email Response ---");

		String errorResponse = MockCustomerResponses.getInvalidEmailCustomerResponse();

		boolean isErrorResponse = isErrorFormat(errorResponse);
		boolean hasErrorCode = errorResponse.contains("\"code\": 400");
		boolean hasErrorMessage = errorResponse.contains("Invalid email format");

		System.out.println("Error response: " + errorResponse);
		System.out.println("Is error format: " + (isErrorResponse ? "PASS" : "FAIL"));
		System.out.println("Has error code 400: " + (hasErrorCode ? "PASS" : "FAIL"));
		System.out.println("Has error message: " + (hasErrorMessage ? "PASS" : "FAIL"));

		String errorCode = extractField(errorResponse, "code");
		System.out.println("Extracted error code: " + errorCode);

		boolean correctErrorHandling = "400".equals(errorCode);
		System.out.println("Error handling: " + (correctErrorHandling ? "PASS" : "FAIL"));
	}

	public static void testMinorCustomerResponse() {
		System.out.println("\n--- Test: Minor Customer Response ---");

		String minorResponse = MockCustomerResponses.getMinorCustomerResponse();

		boolean hasSpecialMessage = minorResponse.contains("Customer is a minor");
		boolean hasValidData = hasCustomerFields(minorResponse);
		boolean hasId = minorResponse.contains("\"id\": 2");

		System.out.println("Minor response: " + minorResponse);
		System.out.println("Has minor message: " + (hasSpecialMessage ? "PASS" : "FAIL"));
		System.out.println("Has valid data: " + (hasValidData ? "PASS" : "FAIL"));
		System.out.println("Has correct ID: " + (hasId ? "PASS" : "FAIL"));

		boolean requiresParentalConsent = hasSpecialMessage;
		System.out.println("Requires parental consent: " + (requiresParentalConsent ? "YES" : "NO"));
		System.out.println("Business logic: " + (requiresParentalConsent ? "PASS" : "FAIL"));
	}

	public static void testErrorHandling() {
		System.out.println("\n--- Test: Error Handling ---");

		String notFoundError = MockErrorResponses.getNotFoundError();
		String badRequestError = MockErrorResponses.getBadRequestError();
		String serverError = MockErrorResponses.getServerError();

		boolean handles404 = handleErrorCode(notFoundError, "404");
		boolean handles400 = handleErrorCode(badRequestError, "400");
		boolean handles500 = handleErrorCode(serverError, "500");

		System.out.println("404 Not Found: " + (handles404 ? "PASS" : "FAIL"));
		System.out.println("400 Bad Request: " + (handles400 ? "PASS" : "FAIL"));
		System.out.println("500 Server Error: " + (handles500 ? "PASS" : "FAIL"));

		String userMessage = getUserFriendlyMessage(notFoundError);
		System.out.println("User-friendly message: " + userMessage);
	}

	private static boolean isValidJsonResponse(String response) {
		return response.startsWith("{") && response.endsWith("}") && response.contains(":");
	}

	private static boolean hasCustomerFields(String response) {
		return response.contains("name") && response.contains("email") && response.contains("phone");
	}

	private static boolean isErrorFormat(String response) {
		return response.contains("error") && response.contains("code");
	}

	private static String extractField(String json, String fieldName) {
		String pattern = "\"" + fieldName + "\": \"";
		int start = json.indexOf(pattern);
		if (start == -1) {
			pattern = "\"" + fieldName + "\": ";
			start = json.indexOf(pattern);
			if (start == -1)
				return null;
			start += pattern.length();
			int end = json.indexOf(",", start);
			if (end == -1)
				end = json.indexOf("}", start);
			return json.substring(start, end).trim();
		}
		start += pattern.length();
		int end = json.indexOf("\"", start);
		return json.substring(start, end);
	}

	private static boolean handleErrorCode(String errorResponse, String expectedCode) {
		String actualCode = extractField(errorResponse, "code");
		return expectedCode.equals(actualCode);
	}

	private static String getUserFriendlyMessage(String errorResponse) {
		String code = extractField(errorResponse, "code");
		switch (code) {
		case "404":
			return "Customer not found";
		case "400":
			return "Invalid customer data";
		case "500":
			return "Server error, try again later";
		default:
			return "Unknown error";
		}
	}

}
