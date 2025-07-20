package java_oop.medium.email_generator.generators;

import java_oop.medium.email_generator.AbstractEmailGenerator;
import java_oop.medium.email_generator.User;

public class SurnamesFirstGenerator extends AbstractEmailGenerator {

	@Override
	protected String generateLocalPart(User user) {
		StringBuilder localPart = new StringBuilder();

		localPart.append(user.getFirstSurname());

		if (user.getSecondSurname() != null && !user.getSecondSurname().isEmpty()) {
			localPart.append(user.getSecondSurname());
		}

		localPart.append(user.getName());

		return localPart.toString();
	}
}