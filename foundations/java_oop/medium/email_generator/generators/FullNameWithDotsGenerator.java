package java_oop.medium.email_generator.generators;

import java_oop.medium.email_generator.AbstractEmailGenerator;
import java_oop.medium.email_generator.User;

public class FullNameWithDotsGenerator extends AbstractEmailGenerator {

	@Override
	protected String generateLocalPart(User user) {
		StringBuilder localPart = new StringBuilder();
		localPart.append(user.getName());
		localPart.append(".");
		localPart.append(user.getFirstSurname());

		if (user.getSecondSurname() != null && !user.getSecondSurname().isEmpty()) {
			localPart.append(".");
			localPart.append(user.getSecondSurname());
		}

		return localPart.toString();
	}
}