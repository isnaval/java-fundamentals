package java_oop.basics.student_system_2.people;

public class Car {

	private String trade;
	private String model;
	private String color;

	public Car(String trade, String model, String color) {

		this.trade = trade;
		this.model = model;
		this.color = color;
	}

	public String getTrade() {
		return trade;
	}

	public void setTrade(String trade) {
		this.trade = trade;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
