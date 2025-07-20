package java_oop.basics.smart_devices;

public abstract class Device {
	protected int id;
	protected String brand;
	protected String model;
	protected boolean isOn;

	public Device(int id, String brand, String model) {
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.isOn = false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public boolean isOn() {
		return isOn;
	}

	public void turnOn() {
		this.isOn = true;
		System.out.println(getDeviceType() + " encendido");
	}

	public void turnOff() {
		this.isOn = false;
		System.out.println(getDeviceType() + " apagado");
	}

	public abstract String getDeviceType();

	public abstract void displayInfo();

	public String getBasicInfo() {
		return String.format("ID: %d | %s %s | Estado: %s", id, brand, model, isOn ? "Encendido" : "Apagado");
	}

	@Override
	public String toString() {
		return getBasicInfo();
	}
}