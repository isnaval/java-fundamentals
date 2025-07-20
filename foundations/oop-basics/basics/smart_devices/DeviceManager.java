package java_oop.basics.smart_devices;

import java.util.ArrayList;
import java.util.List;

public class DeviceManager {
	private List<Device> devices;
	private int nextId;

	public DeviceManager() {
		this.devices = new ArrayList<>();
		this.nextId = 1;
	}

	public void addDevice(Device device) {
		devices.add(device);
		System.out.println("Dispositivo agregado: " + device.getDeviceType() + " (ID: " + device.getId() + ")");
	}

	public MobilePhone createMobilePhone(String brand, String model) {
		MobilePhone phone = new MobilePhone(nextId++, brand, model);
		addDevice(phone);
		return phone;
	}

	public SmartWatch createSmartWatch(String brand, String model) {
		SmartWatch watch = new SmartWatch(nextId++, brand, model);
		addDevice(watch);
		return watch;
	}

	public Device findById(int id) {
		return devices.stream().filter(device -> device.getId() == id).findFirst().orElse(null);
	}

	public List<Device> findByBrand(String brand) {
		return devices.stream().filter(device -> device.getBrand().equalsIgnoreCase(brand)).toList();
	}

	public void turnOnAllDevices() {
		System.out.println("\nEncendiendo todos los dispositivos...");
		devices.forEach(Device::turnOn);
	}

	public void turnOffAllDevices() {
		System.out.println("\nApagando todos los dispositivos...");
		devices.forEach(Device::turnOff);
	}

	public void showInventory() {
		System.out.println("\nINVENTARIO DE DISPOSITIVOS");
		System.out.println("===============================================");

		if (devices.isEmpty()) {
			System.out.println("No hay dispositivos registrados");
			return;
		}

		long phones = devices.stream().filter(d -> d instanceof MobilePhone).count();
		long watches = devices.stream().filter(d -> d instanceof SmartWatch).count();

		System.out.println("Total dispositivos: " + devices.size());
		System.out.println("Telefonos: " + phones);
		System.out.println("Relojes: " + watches);
		System.out.println();

		devices.forEach(System.out::println);
	}

	public void showActiveDevices() {
		System.out.println("\nDISPOSITIVOS ACTIVOS");
		System.out.println("===============================================");

		List<Device> activeDevices = devices.stream().filter(Device::isOn).toList();

		if (activeDevices.isEmpty()) {
			System.out.println("No hay dispositivos encendidos");
		} else {
			activeDevices.forEach(device -> {
				System.out.println("ID " + device.getId() + " - " + device.getDeviceType() + ": " + device.getBrand());
			});
		}
	}

	public void testTrackableDevices() {
		System.out.println("\nTEST DE DISPOSITIVOS RASTREABLES");
		System.out.println("===============================================");

		devices.stream().filter(device -> device instanceof Trackable).forEach(device -> {
			Trackable trackable = (Trackable) device;
			System.out.println("Probando " + device.getDeviceType() + " ID " + device.getId());
			trackable.updateLocation("Nueva ubicacion");
			System.out.println("Ubicacion actual: " + trackable.getCurrentLocation());
			System.out.println();
		});
	}

	public void showStatistics() {
		System.out.println("\nESTADISTICAS");
		System.out.println("===============================================");

		long totalDevices = devices.size();
		long activeDevices = devices.stream().filter(Device::isOn).count();
		long trackableDevices = devices.stream().filter(d -> d instanceof Trackable).count();
		long photographableDevices = devices.stream().filter(d -> d instanceof Photographable).count();
		long radioableDevices = devices.stream().filter(d -> d instanceof Radioable).count();

		System.out.println("Total dispositivos: " + totalDevices);
		System.out.println("Dispositivos activos: " + activeDevices);
		System.out.println("Dispositivos rastreables: " + trackableDevices);
		System.out.println("Dispositivos con camara: " + photographableDevices);
		System.out.println("Dispositivos con radio: " + radioableDevices);

		if (totalDevices > 0) {
			double activeRate = (double) activeDevices / totalDevices * 100;
			System.out.printf("Tasa de actividad: %.1f%%\n", activeRate);
		}
	}
}