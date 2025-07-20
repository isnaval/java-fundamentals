package java_oop.medium.email_generator.generators;

import java_oop.medium.email_generator.AbstractEmailGenerator;
import java_oop.medium.email_generator.User;

public class NameWithSurnameInitialsGenerator extends AbstractEmailGenerator {

	@Override
	protected String generateLocalPart(User user) {
		StringBuilder localPart = new StringBuilder();

		localPart.append(user.getName());

		String firstSurname = user.getFirstSurname();
		if (firstSurname.length() >= 2) {
			localPart.append(firstSurname.substring(0, 2));
		} else {
			localPart.append(firstSurname);
		}

		if (user.getSecondSurname() != null && !user.getSecondSurname().isEmpty()) {
			String secondSurname = user.getSecondSurname();
			if (secondSurname.length() >= 2) {
				localPart.append(secondSurname.substring(0, 2));
			} else {
				localPart.append(secondSurname);
			}
		}

		return localPart.toString();
	}
}