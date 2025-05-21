package java_oop.basics.student_system_2.main;

import java_oop.basics.student_system_2.management.StudentMenuManagement;

public class Main {

	public static void main(String[] args) {
		StudentMenuManagement menu = new StudentMenuManagement();
		while (true) {
			menu.showMenu();
			menu.readOption();
			menu.excuteOption();

		}

	}

}
