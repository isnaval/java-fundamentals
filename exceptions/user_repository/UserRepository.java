package exceptions.user_repository;

/**
 * Interfaz que define el contrato para acceder a usuarios. Patrón Repository:
 * abstrae la forma de acceso a los datos.
 */

public interface UserRepository {
	String findById(int userId) throws UserNotFoundException;

	void addUser(String username) throws IllegalArgumentException;

	String[] getAllUsers();

	int getUserCount();

}
