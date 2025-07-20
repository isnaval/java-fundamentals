package exceptions.user_repository;

import java.util.Arrays;

/**
 * Implementación del repositorio usando un array. Almacena usuarios en memoria
 * de forma simple.
 */

public class ArrayUserRepository implements UserRepository {
	private final String[] users;
	private int currentSize;

	public ArrayUserRepository() {
		this.users = new String[50];
		this.currentSize = 0;
	}

	public String findById(int userId) throws UserNotFoundException {
		validateUserId(userId);

		if (users[userId] == null) {
			throw new UserNotFoundException(userId);
		}

		return users[userId];

	}

	public void addUser(String username) throws IllegalArgumentException {
		if (username == null || username.trim().isEmpty()) {
			throw new IllegalArgumentException("El nombre de usuario no puede estar vacio");
		}
		if (currentSize >= users.length) {
			throw new IllegalStateException("No hay espacio para más usuarios");
		}
		users[currentSize] = username.trim();
		currentSize++;
	}

	public String[] getAllUsers() {
		return Arrays.copyOf(users, currentSize);
	}

	public int getUserCount() {
		return currentSize;
	}

	private void validateUserId(int userId) throws UserNotFoundException {
		if (userId < 0 || userId >= users.length) {
			throw new UserNotFoundException(userId, "ID de usuario fuera del rango valido");
		}
	}
}
