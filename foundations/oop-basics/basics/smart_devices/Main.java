package java_oop.basics.smart_devices;

public class Main {

	public static void main(String[] args) {
		System.out.println("===============================================================");
		System.out.println("         SISTEMA DE GESTION DE DISPOSITIVOS INTELIGENTES");
		System.out.println("===============================================================");

		DeviceManager manager = new DeviceManager();

		demo1CrearDispositivos(manager);
		demo2ControlBasico(manager);
		demo3FuncionalidadesEspecificas(manager);
		demo4GestionAvanzada(manager);

		System.out.println("\nDEMOSTRACION COMPLETADA!");
	}

	private static void demo1CrearDispositivos(DeviceManager manager) {
		System.out.println("\nDEMO 1: CREANDO DISPOSITIVOS");
		System.out.println("===============================================");

		MobilePhone phone1 = manager.createMobilePhone("Samsung", "Galaxy S21");
		MobilePhone phone2 = manager.createMobilePhone("iPhone", "14 Pro");
		SmartWatch watch1 = manager.createSmartWatch("Apple", "Watch Series 8");
		SmartWatch watch2 = manager.createSmartWatch("Garmin", "Forerunner 955");

		manager.showInventory();
	}

	private static void demo2ControlBasico(DeviceManager manager) {
		System.out.println("\nDEMO 2: CONTROL BASICO");
		System.out.println("===============================================");

		manager.turnOnAllDevices();
		manager.showActiveDevices();

		Device phone = manager.findById(1);
		if (phone != null) {
			phone.turnOff();
			phone.displayInfo();
		}
	}

	private static void demo3FuncionalidadesEspecificas(DeviceManager manager) {
		System.out.println("\nDEMO 3: FUNCIONALIDADES ESPECIFICAS");
		System.out.println("===============================================");

		MobilePhone phone = (MobilePhone) manager.findById(2);
		if (phone != null) {
			phone.turnOn();
			phone.updateLocation("Madrid");
			phone.takePicture();
			phone.takePicture();
			phone.tuneToStation("Los 40");
			phone.adjustVolume(75);
			phone.displayInfo();
		}

		SmartWatch watch = (SmartWatch) manager.findById(3);
		if (watch != null) {
			watch.turnOn();
			watch.updateLocation("Gimnasio");
			watch.addSteps(1500);
			watch.measureHeartRate();
			watch.displayInfo();
		}
	}

	private static void demo4GestionAvanzada(DeviceManager manager) {
		System.out.println("\nDEMO 4: GESTION AVANZADA");
		System.out.println("===============================================");

		manager.showStatistics();

		System.out.println("\nBUSQUEDAS POR MARCA:");
		System.out.println("Dispositivos Apple:");
		manager.findByBrand("Apple").forEach(System.out::println);

		manager.testTrackableDevices();

		System.out.println("\nDEMOSTRACION DE POLIMORFISMO:");
		for (int i = 1; i <= 4; i++) {
			Device device = manager.findById(i);
			if (device != null) {
				System.out.println("\n--- Dispositivo ID " + i + " ---");
				device.displayInfo();
			}
		}

		System.out.println("\nMANIPULACION DE INTERFACES:");
		Device device = manager.findById(1);
		if (device instanceof Trackable) {
			device.turnOn();
			Trackable trackable = (Trackable) device;
			trackable.updateLocation("Barcelona");
			System.out.println("Nueva ubicacion: " + trackable.getCurrentLocation());
		}
	}
}