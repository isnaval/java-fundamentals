package java_oop.basics.smart_devices;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone extends Device implements Trackable, Photographable, Radioable {
	private String currentLocation;
	private List<String> locationHistory;
	private int photoCount;
	private String currentStation;
	private int volume;

	public MobilePhone(int id, String brand, String model) {
		super(id, brand, model);
		this.currentLocation = "Ubicacion inicial";
		this.locationHistory = new ArrayList<>();
		this.photoCount = 0;
		this.currentStation = "Radio Nacional";
		this.volume = 50;
	}

	@Override
	public String getDeviceType() {
		return "Telefono movil";
	}

	@Override
	public void updateLocation(String newLocation) {
		if (isOn()) {
			locationHistory.add(currentLocation);
			this.currentLocation = newLocation;
			System.out.println("Ubicacion actualizada a: " + newLocation);
		} else {
			System.out.println("El telefono esta apagado");
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
			System.out.println("El telefono esta apagado");
		}
	}

	@Override
	public void takePicture() {
		if (isOn()) {
			photoCount++;
			System.out.println("Foto tomada. Total fotos: " + photoCount);
		} else {
			System.out.println("El telefono esta apagado");
		}
	}

	@Override
	public void takeVideo(int seconds) {
		if (isOn()) {
			System.out.println("Video grabado durante " + seconds + " segundos");
		} else {
			System.out.println("El telefono esta apagado");
		}
	}

	@Override
	public void showPhotoCount() {
		System.out.println("Total de fotos: " + photoCount);
	}

	@Override
	public void tuneToStation(String station) {
		if (isOn()) {
			this.currentStation = station;
			System.out.println("Sintonizando: " + station);
		} else {
			System.out.println("El telefono esta apagado");
		}
	}

	@Override
	public String getCurrentStation() {
		return isOn() ? currentStation : "Radio apagada";
	}

	@Override
	public void adjustVolume(int volume) {
		if (isOn()) {
			this.volume = Math.max(0, Math.min(100, volume));
			System.out.println("Volumen ajustado a: " + this.volume);
		} else {
			System.out.println("El telefono esta apagado");
		}
	}

	@Override
	public int getVolume() {
		return isOn() ? volume : 0;
	}

	@Override
	public void displayInfo() {
		System.out.println("===============================================");
		System.out.println("           TELEFONO MOVIL");
		System.out.println("===============================================");
		System.out.println(getBasicInfo());
		System.out.println("Ubicacion: " + getCurrentLocation());
		System.out.println("Fotos: " + photoCount);
		System.out.println("Radio: " + getCurrentStation());
		System.out.println("Volumen: " + getVolume());
		System.out.println("===============================================");
	}
}