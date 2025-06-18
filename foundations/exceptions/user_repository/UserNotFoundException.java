package exceptions.user_repository;

/**
 * Excepción personalizada que se lanza cuando un usuario no es encontrado.
 * Extiende Exception (checked exception) para forzar el manejo explícito.
 */

@SuppressWarnings("serial")
public class UserNotFoundException extends Exception {
	private final int userId;

	public UserNotFoundException(int userId) {
		super("Id Usser" + userId + " not found");
		this.userId = userId;
	}

	public UserNotFoundException(int userId, String costumMessage) {
		super(costumMessage);
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}

}
