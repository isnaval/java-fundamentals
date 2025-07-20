package java_oop.basics.sports_equipment;

public interface Inflatable {

	void inflate(double pressure);

	void deflate();

	boolean isInflated();

	double getCurrentPressure();

	double getRecommendedPressure();
}
