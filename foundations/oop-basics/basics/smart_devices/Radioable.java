package java_oop.basics.smart_devices;

public interface Radioable {
	void tuneToStation(String station);

	String getCurrentStation();

	void adjustVolume(int volume);

	int getVolume();

}
