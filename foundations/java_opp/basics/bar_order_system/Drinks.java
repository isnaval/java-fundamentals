package java_opp.basics.bar_order_system;

	public enum Drinks {
	    COFFEE("Café", 1.50, false),
	    BEER("Cerveza", 3.00, true),
	    MOJITO("Mojito", 7.50, true),
	    WATER("Agua", 1.00, false),
	    TEA("Té", 1.20, false),
	    WINE("Vino", 4.50, true),
	    WHISKEY("Whisky", 6.00, true),
	    SODA("Refresco", 2.00, false),
	    JUICE("Zumo", 2.50, false),
	    MILKSHAKE("Batido", 3.50, false);
	    
	    private final String name;
	    private final double price;
	    private final boolean containsAlcohol;
	    
	    Drinks(String name, double price, boolean containsAlcohol) {
	        this.name = name;
	        this.price = price;
	        this.containsAlcohol = containsAlcohol;
	    }
	    
	    public String getName() {
	        return name;
	    }
	    
	    public double getPrice() {
	        return price;
	    }
	    
	    public boolean containsAlcohol() {
	        return containsAlcohol;
	    }
	    
	    public Drink toDrink() {
	        return new Drink(this.name, this.price);
	    }
	    
	    @Override
	    public String toString() {
	        return name + " - " + String.format("%.2f €", price) + 
	               (containsAlcohol ? " (contiene alcohol)" : "");
	    }
	
}
