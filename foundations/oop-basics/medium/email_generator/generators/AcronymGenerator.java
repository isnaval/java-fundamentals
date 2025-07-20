package java_oop.medium.email_generator.generators;

import java_oop.medium.email_generator.AbstractEmailGenerator;
import java_oop.medium.email_generator.User;

public class AcronymGenerator extends AbstractEmailGenerator {

	@Override
	protected String generateLocalPart(User user) {
		StringBuilder acronym = new StringBuilder();

		acronym.append(user.getName().substring(0, 1));

		acronym.append(user.getFirstSurname().substring(0, 1));

		if (user.getSecondSurname() != null && !user.getSecondSurname().isEmpty()) {
			acronym.append(user.getSecondSurname().substring(0, 1));
		}

		return acronym.toString();
	}
}