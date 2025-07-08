package java_oop.medium.email_generator;

public abstract class AbstractEmailGenerator implements EmailGeneratorInterface {

	protected static final String DEFAULT_DOMAIN = "@dominio.com";

	@Override
	public String generate(User user) {
		validateUser(user);
		String localPart = generateLocalPart(user);
		return normalizeEmail(localPart + getDomain());
	}

	protected abstract String generateLocalPart(User user);

	protected String getDomain() {
		return DEFAULT_DOMAIN;
	}

	protected void validateUser(User user) {
		if (user == null) {
			throw new IllegalArgumentException("El usuario no puede ser null");
		}
		if (user.getName() == null || user.getName().trim().isEmpty()) {
			throw new IllegalArgumentException("El nombre no puede estar vacío");
		}
		if (user.getFirstSurname() == null || user.getFirstSurname().trim().isEmpty()) {
			throw new IllegalArgumentException("El primer apellido no puede estar vacío");
		}
	}

	protected String normalizeEmail(String email) {
		return email.toLowerCase().trim().replaceAll("\\s+", "").replaceAll("[áàäâ]", "a").replaceAll("[éèëê]", "e")
				.replaceAll("[íìïî]", "i").replaceAll("[óòöô]", "o").replaceAll("[úùüû]", "u").replaceAll("ñ", "n");
	}

	protected String safe(String value) {
		return value != null ? value : "";
	}
}