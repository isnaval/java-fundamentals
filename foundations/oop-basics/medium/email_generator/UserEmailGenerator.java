package java_oop.medium.email_generator;

public class UserEmailGenerator {
	private EmailGeneratorInterface emailGenerator;

	public UserEmailGenerator(EmailGeneratorInterface emailGenerator) {
		if (emailGenerator == null) {
			throw new IllegalArgumentException("El generador no puede ser null");
		}
		this.emailGenerator = emailGenerator;
	}

	public String generateUserEmail(User user) {
		return this.emailGenerator.generate(user);
	}

	public void setEmailGenerator(EmailGeneratorInterface emailGenerator) {
		if (emailGenerator == null) {
			throw new IllegalArgumentException("El generador no puede ser null");
		}
		this.emailGenerator = emailGenerator;
	}

	public EmailGeneratorInterface getEmailGenerator() {
		return this.emailGenerator;
	}
}