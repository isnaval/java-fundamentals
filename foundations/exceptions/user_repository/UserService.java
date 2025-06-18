package exceptions.user_repository;

public class UserService {
	private final UserRepository repository;

	public UserService(UserRepository repository) {
		this.repository = repository;
	}

	public String getUserById(int id) throws UserNotFoundException {
		try {
			return repository.findById(id);
		} catch (UserNotFoundException e) {
			System.err.println("Error al buscar el usuario " + e.getMessage());
			throw e;
		}
	}

	public boolean userExists(int id) {
		try {
			repository.findById(id);
			return true;
		} catch (UserNotFoundException e) {
			return false;
		}
	}

	public void addNewUser(String username) {
		try {
			repository.addUser(username);
			System.out.println("Usuario" + username + " agregado correctamente");
		} catch (IllegalArgumentException e) {
			System.err.println("Error al agreagar el usaurio " + e.getMessage());
		} catch (IllegalStateException e) {
			System.err.println("Error; " + e.getMessage());
		}
	}

	public void showStats() {
		int totalUsers = repository.getUserCount();
		System.out.println("Total de usuarios en el sistema " + totalUsers);
		if (totalUsers > 0) {
			String[] allUsers = repository.getAllUsers();
			System.out.println("Usuarios registrados.");
			for (int i = 0; i < allUsers.length; i++) {
				System.out.println(" " + i + ": " + allUsers);
			}
		}
	}

}
