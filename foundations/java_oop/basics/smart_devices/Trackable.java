package java_oop.basics.smart_devices;

public interface Trackable {
	void updateLocation(String newLocation);

	String getCurrentLocation();

	void showLocationHistory();

}
