package java_oop.basics.smart_devices;

import java.util.ArrayList;
import java.util.List;

public class SmartWatch extends Device implements Trackable {
	private String currentLocation;
	private List<String> locationHistory;
	private int steps;
	private int heartRate;

	public SmartWatch(int id, String brand, String model) {
		super(id, brand, model);
		this.currentLocation = "Posicion inicial";
		this.locationHistory = new ArrayList<>();
		this.steps = 0;
		this.heartRate = 70;
	}

	@Override
	public String getDeviceType() {
		return "Reloj inteligente";
	}

	@Override
	public void updateLocation(String newLocation) {
		if (isOn()) {
			locationHistory.add(currentLocation);
			this.currentLocation = newLocation;
			System.out.println("Ubicacion actualizada a: " + newLocation);
		} else {
			System.out.println("El reloj esta apagado");
		}
	}

	@Override
	public String getCurrentLocation() {
		return isOn() ? currentLocation : "GPS desactivado";
	}

	@Override
	public void showLocationHistory() {
		if (isOn()) {
			System.out.println("Historial de ubicaciones:");
			for (int i = 0; i < locationHistory.size(); i++) {
				System.out.println((i + 1) + ". " + locationHistory.get(i));
			}
			System.out.println("Actual: " + currentLocation);
		} else {
			System.out.println("El reloj esta apagado");
		}
	}

	public void addSteps(int newSteps) {
		if (isOn()) {
			this.steps += newSteps;
			System.out.println("Pasos agregados: " + newSteps + ". Total: " + steps);
		} else {
			System.out.println("El reloj esta apagado");
		}
	}

	public int getSteps() {
		return isOn() ? steps : 0;
	}

	public void measureHeartRate() {
		if (isOn()) {
			this.heartRate = 60 + (int) (Math.random() * 40);
			System.out.println("Ritmo cardiaco medido: " + heartRate + " bpm");
		} else {
			System.out.println("El reloj esta apagado");
		}
	}

	public int getHeartRate() {
		return isOn() ? heartRate : 0;
	}

	public void resetSteps() {
		if (isOn()) {
			this.steps = 0;
			System.out.println("Contador de pasos reiniciado");
		} else {
			System.out.println("El reloj esta apagado");
		}
	}

	@Override
	public void displayInfo() {
		System.out.println("===============================================");
		System.out.println("           RELOJ INTELIGENTE");
		System.out.println("===============================================");
		System.out.println(getBasicInfo());
		System.out.println("Ubicacion: " + getCurrentLocation());
		System.out.println("Pasos: " + getSteps());
		System.out.println("Ritmo cardiaco: " + getHeartRate() + " bpm");
		System.out.println("===============================================");
	}
}
