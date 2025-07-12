package java_oop.advanced.electronics_store_system.store;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java_oop.advanced.electronics_store_system.customers.BusinessCustomer;
import java_oop.advanced.electronics_store_system.customers.Customer;
import java_oop.advanced.electronics_store_system.customers.VIPCustomer;
import java_oop.advanced.electronics_store_system.employees.Employee;
import java_oop.advanced.electronics_store_system.employees.Manager;
import java_oop.advanced.electronics_store_system.employees.SalesAssociate;
import java_oop.advanced.electronics_store_system.employees.Technician;
import java_oop.advanced.electronics_store_system.products.Camera;
import java_oop.advanced.electronics_store_system.products.Headphones;
import java_oop.advanced.electronics_store_system.products.Laptop;
import java_oop.advanced.electronics_store_system.products.Product;
import java_oop.advanced.electronics_store_system.products.Smartphone;
import java_oop.advanced.electronics_store_system.products.Television;

public class ElectronicsStore {
	private String storeName;
	private List<Product> inventory;
	private List<Customer> customers;
	private List<Employee> employees;
	private double totalRevenue;
	private Scanner scanner;

	public ElectronicsStore(String storeName) {
		this.storeName = storeName;
		this.inventory = new ArrayList<>();
		this.customers = new ArrayList<>();
		this.employees = new ArrayList<>();
		this.totalRevenue = 0.0;
		this.scanner = new Scanner(System.in);
		initializeStore();
	}

	private void initializeStore() {
		inventory.add(new Smartphone("Apple", "iPhone 15 Pro", 1199.99, "Negro", 24, 15, "iOS", 6, 256, 8, 3274, true));
		inventory
				.add(new Smartphone("Samsung", "Galaxy S24", 899.99, "Azul", 24, 20, "Android", 6, 128, 8, 4000, true));
		inventory.add(new Laptop("Dell", "XPS 13", 1299.99, "Plata", 36, 10, "Intel i7", 16, 512, "SSD", 13,
				"Intel Iris", 1.2, true));
		inventory.add(
				new Television("LG", "OLED55C3", 1599.99, "Negro", 24, 8, 55, "4K", "OLED", true, "webOS", 120, true));
		inventory.add(new Headphones("Sony", "WH-1000XM5", 349.99, "Negro", 12, 25, "Over-ear", true, 30, true,
				"Bluetooth", 40, true));
		inventory.add(new Camera("Canon", "EOS R6", 2499.99, "Negro", 24, 5, "Mirrorless", 24, "Full Frame", true, true,
				"4K", 380, true));

		employees.add(new SalesAssociate("Ana García", "EMP001", 1800.0, 3));
		employees.add(new SalesAssociate("Carlos López", "EMP002", 1900.0, 5));
		employees.add(new Manager("María Rodríguez", "MNG001", 3500.0, "Ventas", 8));
		employees.add(new Technician("Pedro Martín", "TEC001", 2200.0, 4, "Reparaciones", true));
	}

	public void startInteractiveSystem() {
		System.out.println("🏪 BIENVENIDO A " + storeName.toUpperCase() + " 🏪");
		System.out.println("=".repeat(50));

		while (true) {
			showMainMenu();
			int option = getIntInput("Seleccione una opción: ");

			switch (option) {
			case 1:
				customerModule();
				break;
			case 2:
				productModule();
				break;
			case 3:
				employeeModule();
				break;
			case 4:
				salesModule();
				break;
			case 5:
				inventoryModule();
				break;
			case 6:
				showStoreStatistics();
				break;
			case 0:
				System.out.println("👋 ¡Gracias por usar nuestro sistema!");
				return;
			default:
				System.out.println("❌ Opción inválida. Intente de nuevo.");
			}

			System.out.println("\nPresione Enter para continuar...");
			scanner.nextLine();
		}
	}

	private void showMainMenu() {
		System.out.println("\n📋 MENÚ PRINCIPAL:");
		System.out.println("==================");
		System.out.println("1. 👤 Gestión de Clientes");
		System.out.println("2. 📱 Catálogo de Productos");
		System.out.println("3. 👨‍💼 Gestión de Empleados");
		System.out.println("4. 💰 Realizar Venta");
		System.out.println("5. 📦 Gestión de Inventario");
		System.out.println("6. 📊 Estadísticas de la Tienda");
		System.out.println("0. 🚪 Salir");
	}

	private void customerModule() {
		while (true) {
			System.out.println("\n👤 GESTIÓN DE CLIENTES:");
			System.out.println("=======================");
			System.out.println("1. Registrar Cliente Normal");
			System.out.println("2. Registrar Cliente VIP");
			System.out.println("3. Registrar Cliente Empresarial");
			System.out.println("4. Ver Lista de Clientes");
			System.out.println("5. Buscar Cliente");
			System.out.println("0. Volver al Menú Principal");

			int option = getIntInput("Seleccione una opción: ");

			switch (option) {
			case 1:
				registerRegularCustomer();
				break;
			case 2:
				registerVIPCustomer();
				break;
			case 3:
				registerBusinessCustomer();
				break;
			case 4:
				showAllCustomers();
				break;
			case 5:
				searchCustomer();
				break;
			case 0:
				return;
			default:
				System.out.println("❌ Opción inválida.");
			}
		}
	}

	private void registerRegularCustomer() {
		System.out.println("\n📝 REGISTRO DE CLIENTE NORMAL:");
		String name = getStringInput("Nombre: ");
		String email = getStringInput("Email: ");
		String phone = getStringInput("Teléfono: ");
		String address = getStringInput("Dirección: ");

		Customer customer = new Customer(name, email, phone, address);
		customers.add(customer);

		System.out.println("✅ Cliente registrado exitosamente!");
		customer.showCustomerInfo();
	}

	private void registerVIPCustomer() {
		System.out.println("\n💎 REGISTRO DE CLIENTE VIP:");
		String name = getStringInput("Nombre: ");
		String email = getStringInput("Email: ");
		String phone = getStringInput("Teléfono: ");
		String address = getStringInput("Dirección: ");

		System.out.println("Niveles disponibles: Bronze, Silver, Gold, Platinum");
		String level = getStringInput("Nivel de membresía: ");

		VIPCustomer vipCustomer = new VIPCustomer(name, email, phone, address, level);
		customers.add(vipCustomer);

		System.out.println("✅ Cliente VIP registrado exitosamente!");
		vipCustomer.showCustomerInfo();
	}

	private void registerBusinessCustomer() {
		System.out.println("\n🏢 REGISTRO DE CLIENTE EMPRESARIAL:");
		String name = getStringInput("Nombre del contacto: ");
		String email = getStringInput("Email: ");
		String phone = getStringInput("Teléfono: ");
		String address = getStringInput("Dirección: ");
		String companyName = getStringInput("Nombre de la empresa: ");
		String taxId = getStringInput("NIF/CIF: ");
		double creditLimit = getDoubleInput("Límite de crédito (€): ");

		BusinessCustomer businessCustomer = new BusinessCustomer(name, email, phone, address, companyName, taxId,
				creditLimit);
		customers.add(businessCustomer);

		System.out.println("✅ Cliente empresarial registrado exitosamente!");
		businessCustomer.showCustomerInfo();
	}

	private void productModule() {
		while (true) {
			System.out.println("\n📱 CATÁLOGO DE PRODUCTOS:");
			System.out.println("=========================");
			System.out.println("1. Ver Todos los Productos");
			System.out.println("2. Ver Smartphones");
			System.out.println("3. Ver Laptops");
			System.out.println("4. Ver Televisiones");
			System.out.println("5. Ver Auriculares");
			System.out.println("6. Ver Cámaras");
			System.out.println("7. Buscar Producto");
			System.out.println("8. Ver Especificaciones Detalladas");
			System.out.println("0. Volver al Menú Principal");

			int option = getIntInput("Seleccione una opción: ");

			switch (option) {
			case 1:
				showAllProducts();
				break;
			case 2:
				showProductsByType("Smartphone");
				break;
			case 3:
				showProductsByType("Laptop");
				break;
			case 4:
				showProductsByType("Televisión");
				break;
			case 5:
				showProductsByType("Auriculares");
				break;
			case 6:
				showProductsByType("Cámara");
				break;
			case 7:
				searchProduct();
				break;
			case 8:
				showProductSpecifications();
				break;
			case 0:
				return;
			default:
				System.out.println("❌ Opción inválida.");
			}
		}
	}

	private void showAllProducts() {
		System.out.println("\n📦 TODOS LOS PRODUCTOS:");
		System.out.println("=======================");
		for (int i = 0; i < inventory.size(); i++) {
			System.out.printf("%d. %s%n", i + 1, inventory.get(i));
		}
	}

	private void showProductsByType(String type) {
		System.out.println("\n📦 " + type.toUpperCase() + "S:");
		System.out.println("=".repeat(type.length() + 10));

		boolean found = false;
		for (int i = 0; i < inventory.size(); i++) {
			Product product = inventory.get(i);
			if (product.getProductType().equals(type)) {
				System.out.printf("%d. %s%n", i + 1, product);
				found = true;
			}
		}

		if (!found) {
			System.out.println("No hay productos de este tipo disponibles.");
		}
	}

	private void showProductSpecifications() {
		showAllProducts();
		int index = getIntInput("Seleccione el número del producto: ") - 1;

		if (index >= 0 && index < inventory.size()) {
			System.out.println();
			inventory.get(index).showSpecifications();
		} else {
			System.out.println("❌ Producto no encontrado.");
		}
	}

	private String getStringInput(String prompt) {
		System.out.print(prompt);
		return scanner.nextLine().trim();
	}

	private int getIntInput(String prompt) {
		while (true) {
			try {
				System.out.print(prompt);
				int value = Integer.parseInt(scanner.nextLine().trim());
				return value;
			} catch (NumberFormatException e) {
				System.out.println("❌ Por favor, ingrese un número válido.");
			}
		}
	}

	private double getDoubleInput(String prompt) {
		while (true) {
			try {
				System.out.print(prompt);
				double value = Double.parseDouble(scanner.nextLine().trim());
				return value;
			} catch (NumberFormatException e) {
				System.out.println("❌ Por favor, ingrese un número válido.");
			}
		}
	}

	private void showAllCustomers() {
		System.out.println("\n👥 LISTA DE CLIENTES:");
		System.out.println("====================");
		for (int i = 0; i < customers.size(); i++) {
			Customer customer = customers.get(i);
			System.out.printf("%d. %s (%s)%n", i + 1, customer.getName(), customer.getClass().getSimpleName());
		}
	}

	private void searchCustomer() {
		String name = getStringInput("Ingrese el nombre del cliente: ");

		for (Customer customer : customers) {
			if (customer.getName().toLowerCase().contains(name.toLowerCase())) {
				System.out.println("✅ Cliente encontrado:");
				customer.showCustomerInfo();
				return;
			}
		}

		System.out.println("❌ Cliente no encontrado.");
	}

	private void searchProduct() {
		String search = getStringInput("Ingrese marca o modelo: ");

		System.out.println("\n🔍 RESULTADOS DE BÚSQUEDA:");
		System.out.println("==========================");

		boolean found = false;
		for (int i = 0; i < inventory.size(); i++) {
			Product product = inventory.get(i);
			if (product.getBrand().toLowerCase().contains(search.toLowerCase())
					|| product.getModel().toLowerCase().contains(search.toLowerCase())) {
				System.out.printf("%d. %s%n", i + 1, product);
				found = true;
			}
		}

		if (!found) {
			System.out.println("No se encontraron productos con esos criterios.");
		}
	}

	private void employeeModule() {
		while (true) {
			System.out.println("\n👨‍💼 GESTIÓN DE EMPLEADOS:");
			System.out.println("===========================");
			System.out.println("1. Ver Todos los Empleados");
			System.out.println("2. Ver Información Detallada");
			System.out.println("3. Ver Responsabilidades");
			System.out.println("4. Calcular Nóminas");
			System.out.println("0. Volver al Menú Principal");

			int option = getIntInput("Seleccione una opción: ");

			switch (option) {
			case 1:
				showAllEmployees();
				break;
			case 2:
				showEmployeeDetails();
				break;
			case 3:
				showEmployeeResponsibilities();
				break;
			case 4:
				calculatePayroll();
				break;
			case 0:
				return;
			default:
				System.out.println("❌ Opción inválida.");
			}
		}
	}

	private void showAllEmployees() {
		System.out.println("\n👥 LISTA DE EMPLEADOS:");
		System.out.println("======================");
		for (int i = 0; i < employees.size(); i++) {
			Employee employee = employees.get(i);
			System.out.printf("%d. %s - %s (%s)%n", i + 1, employee.getName(), employee.getDepartment(),
					employee.getClass().getSimpleName());
		}
	}

	private void showEmployeeDetails() {
		showAllEmployees();
		int index = getIntInput("Seleccione el número del empleado: ") - 1;

		if (index >= 0 && index < employees.size()) {
			System.out.println();
			employees.get(index).showEmployeeInfo();
		} else {
			System.out.println("❌ Empleado no encontrado.");
		}
	}

	private void showEmployeeResponsibilities() {
		showAllEmployees();
		int index = getIntInput("Seleccione el número del empleado: ") - 1;

		if (index >= 0 && index < employees.size()) {
			System.out.println();
			employees.get(index).showResponsibilities();
		} else {
			System.out.println("❌ Empleado no encontrado.");
		}
	}

	private void calculatePayroll() {
		System.out.println("\n💰 NÓMINA DEL MES:");
		System.out.println("==================");
		double totalPayroll = 0.0;

		for (Employee employee : employees) {
			double salary = employee.calculateSalary();
			totalPayroll += salary;
			System.out.printf("%s: €%.2f%n", employee.getName(), salary);
		}

		System.out.println("-".repeat(30));
		System.out.printf("TOTAL NÓMINA: €%.2f%n", totalPayroll);
	}

	private void salesModule() {
		System.out.println("\n💰 MÓDULO DE VENTAS:");
		System.out.println("====================");

		showAllCustomers();
		int customerIndex = getIntInput("Seleccione el cliente (0 para cliente sin registro): ") - 1;

		Customer customer = null;
		if (customerIndex >= 0 && customerIndex < customers.size()) {
			customer = customers.get(customerIndex);
		}

		List<Product> cart = new ArrayList<>();
		List<Integer> quantities = new ArrayList<>();

		while (true) {
			showAllProducts();
			int productIndex = getIntInput("Seleccione producto (0 para finalizar): ") - 1;

			if (productIndex == -1)
				break;

			if (productIndex >= 0 && productIndex < inventory.size()) {
				Product product = inventory.get(productIndex);
				int quantity = getIntInput("Cantidad: ");

				if (product.getStockQuantity() >= quantity) {
					cart.add(product);
					quantities.add(quantity);
					System.out.printf("✅ Agregado: %dx %s%n", quantity, product.getModel());
				} else {
					System.out.printf("❌ Stock insuficiente. Disponible: %d%n", product.getStockQuantity());
				}
			}
		}

		if (!cart.isEmpty()) {
			processSale(customer, cart, quantities);
		}
	}

	private void processSale(Customer customer, List<Product> cart, List<Integer> quantities) {
		double subtotal = 0.0;

		System.out.println("\n🧾 FACTURA:");
		System.out.println("============");

		for (int i = 0; i < cart.size(); i++) {
			Product product = cart.get(i);
			int quantity = quantities.get(i);
			double lineTotal = product.getPrice() * quantity;
			subtotal += lineTotal;

			System.out.printf("%dx %s %s - €%.2f%n", quantity, product.getBrand(), product.getModel(), lineTotal);
		}

		double discount = 0.0;
		if (customer != null) {
			discount = customer.getDiscount();
			if (customer instanceof BusinessCustomer) {
				BusinessCustomer bc = (BusinessCustomer) customer;
				int totalQuantity = quantities.stream().mapToInt(Integer::intValue).sum();
				double bulkDiscount = bc.getBulkDiscount(totalQuantity);
				discount = Math.max(discount, bulkDiscount);
			}
		}

		double discountAmount = subtotal * (discount / 100);
		double total = subtotal - discountAmount;

		System.out.println("-".repeat(40));
		System.out.printf("Subtotal: €%.2f%n", subtotal);
		if (discount > 0) {
			System.out.printf("Descuento (%.1f%%): -€%.2f%n", discount, discountAmount);
		}
		System.out.printf("TOTAL: €%.2f%n", total);

		String confirm = getStringInput("¿Confirmar venta? (s/n): ");
		if (confirm.toLowerCase().startsWith("s")) {
			for (int i = 0; i < cart.size(); i++) {
				cart.get(i).reduceStock(quantities.get(i));
			}

			if (customer != null) {
				StringBuilder purchaseInfo = new StringBuilder();
				for (int i = 0; i < cart.size(); i++) {
					purchaseInfo.append(quantities.get(i)).append("x ").append(cart.get(i).getBrand()).append(" ")
							.append(cart.get(i).getModel()).append("; ");
				}
				customer.addPurchase(purchaseInfo.toString(), total);
			}

			totalRevenue += total;
			System.out.println("✅ Venta completada exitosamente!");
		} else {
			System.out.println("❌ Venta cancelada.");
		}
	}

	private void inventoryModule() {
		while (true) {
			System.out.println("\n📦 GESTIÓN DE INVENTARIO:");
			System.out.println("=========================");
			System.out.println("1. Ver Stock Actual");
			System.out.println("2. Productos con Bajo Stock");
			System.out.println("3. Reabastecer Producto");
			System.out.println("4. Agregar Nuevo Producto");
			System.out.println("0. Volver al Menú Principal");

			int option = getIntInput("Seleccione una opción: ");

			switch (option) {
			case 1:
				showInventoryStatus();
				break;
			case 2:
				showLowStock();
				break;
			case 3:
				restockProduct();
				break;
			case 4:
				addNewProduct();
				break;
			case 0:
				return;
			default:
				System.out.println("❌ Opción inválida.");
			}
		}
	}

	private void showInventoryStatus() {
		System.out.println("\n📊 ESTADO DEL INVENTARIO:");
		System.out.println("=========================");
		for (Product product : inventory) {
			String status = product.getStockQuantity() < 5 ? "⚠️ BAJO"
					: product.getStockQuantity() < 10 ? "📦 MEDIO" : "✅ ALTO";
			System.out.printf("%s - Stock: %d %s%n", product, product.getStockQuantity(), status);
		}
	}

	private void showLowStock() {
		System.out.println("\n⚠️ PRODUCTOS CON BAJO STOCK:");
		System.out.println("=============================");
		boolean found = false;

		for (Product product : inventory) {
			if (product.getStockQuantity() < 5) {
				System.out.printf("⚠️ %s - Stock: %d%n", product, product.getStockQuantity());
				found = true;
			}
		}

		if (!found) {
			System.out.println("✅ No hay productos con bajo stock.");
		}
	}

	private void restockProduct() {
		showAllProducts();
		int index = getIntInput("Seleccione el producto a reabastecer: ") - 1;

		if (index >= 0 && index < inventory.size()) {
			Product product = inventory.get(index);
			int currentStock = product.getStockQuantity();
			int addQuantity = getIntInput("Cantidad a agregar: ");

			product.setStockQuantity(currentStock + addQuantity);

			System.out.printf("✅ Stock actualizado: %s - Nuevo stock: %d%n", product.getModel(),
					product.getStockQuantity());
		} else {
			System.out.println("❌ Producto no encontrado.");
		}
	}

	private void addNewProduct() {
		System.out.println("\n➕ AGREGAR NUEVO PRODUCTO:");
		System.out.println("===========================");
		System.out.println("1. Smartphone");
		System.out.println("2. Laptop");
		System.out.println("3. Televisión");
		System.out.println("4. Auriculares");
		System.out.println("5. Cámara");

		int type = getIntInput("Tipo de producto: ");

		String brand = getStringInput("Marca: ");
		String model = getStringInput("Modelo: ");
		double price = getDoubleInput("Precio (€): ");
		String color = getStringInput("Color: ");
		int warranty = getIntInput("Garantía (meses): ");
		int stock = getIntInput("Stock inicial: ");

		Product newProduct = null;

		switch (type) {
		case 1:
			String os = getStringInput("Sistema operativo: ");
			int screenSize = getIntInput("Tamaño de pantalla (pulgadas): ");
			int storage = getIntInput("Almacenamiento (GB): ");
			int ram = getIntInput("RAM (GB): ");
			int battery = getIntInput("Batería (mAh): ");
			boolean has5G = getStringInput("¿Tiene 5G? (s/n): ").toLowerCase().startsWith("s");

			newProduct = new Smartphone(brand, model, price, color, warranty, stock, os, screenSize, storage, ram,
					battery, has5G);
			break;

		case 2:
			String processor = getStringInput("Procesador: ");
			int laptopRam = getIntInput("RAM (GB): ");
			int laptopStorage = getIntInput("Almacenamiento (GB): ");
			String storageType = getStringInput("Tipo de almacenamiento (SSD/HDD): ");
			int laptopScreen = getIntInput("Tamaño de pantalla (pulgadas): ");
			String graphics = getStringInput("Tarjeta gráfica: ");
			double weight = getDoubleInput("Peso (kg): ");
			boolean touchscreen = getStringInput("¿Pantalla táctil? (s/n): ").toLowerCase().startsWith("s");

			newProduct = new Laptop(brand, model, price, color, warranty, stock, processor, laptopRam, laptopStorage,
					storageType, laptopScreen, graphics, weight, touchscreen);
			break;

		case 3:
			int tvScreen = getIntInput("Tamaño de pantalla (pulgadas): ");
			String resolution = getStringInput("Resolución (4K/HD): ");
			String technology = getStringInput("Tecnología (LED/OLED/QLED): ");
			boolean smartTV = getStringInput("¿Smart TV? (s/n): ").toLowerCase().startsWith("s");
			String tvOS = smartTV ? getStringInput("Sistema operativo: ") : "N/A";
			int refreshRate = getIntInput("Tasa de refresco (Hz): ");
			boolean hdr = getStringInput("¿Compatible con HDR? (s/n): ").toLowerCase().startsWith("s");

			newProduct = new Television(brand, model, price, color, warranty, stock, tvScreen, resolution, technology,
					smartTV, tvOS, refreshRate, hdr);
			break;

		case 4:
			String headphoneType = getStringInput("Tipo (Over-ear/On-ear/In-ear): ");
			boolean wireless = getStringInput("¿Inalámbricos? (s/n): ").toLowerCase().startsWith("s");
			int batteryLife = wireless ? getIntInput("Duración batería (horas): ") : 0;
			boolean noiseCanceling = getStringInput("¿Cancelación de ruido? (s/n): ").toLowerCase().startsWith("s");
			String connectivity = getStringInput("Conectividad: ");
			int driverSize = getIntInput("Tamaño del driver (mm): ");
			boolean microphone = getStringInput("¿Tiene micrófono? (s/n): ").toLowerCase().startsWith("s");

			newProduct = new Headphones(brand, model, price, color, warranty, stock, headphoneType, wireless,
					batteryLife, noiseCanceling, connectivity, driverSize, microphone);
			break;

		case 5:
			String cameraType = getStringInput("Tipo (DSLR/Mirrorless/Compact): ");
			int megapixels = getIntInput("Megapíxeles: ");
			String sensorSize = getStringInput("Tamaño del sensor: ");
			boolean wifi = getStringInput("¿Tiene WiFi? (s/n): ").toLowerCase().startsWith("s");
			boolean video = getStringInput("¿Graba video? (s/n): ").toLowerCase().startsWith("s");
			String videoRes = video ? getStringInput("Resolución máxima de video: ") : "N/A";
			int cameraBattery = getIntInput("Duración batería (disparos): ");
			boolean stabilization = getStringInput("¿Estabilización de imagen? (s/n): ").toLowerCase().startsWith("s");

			newProduct = new Camera(brand, model, price, color, warranty, stock, cameraType, megapixels, sensorSize,
					wifi, video, videoRes, cameraBattery, stabilization);
			break;

		default:
			System.out.println("❌ Tipo de producto inválido.");
			return;
		}

		if (newProduct != null) {
			inventory.add(newProduct);
			System.out.println("✅ Producto agregado exitosamente!");
			newProduct.showSpecifications();
		}
	}

	private void showStoreStatistics() {
		System.out.println("\n📊 ESTADÍSTICAS DE LA TIENDA:");
		System.out.println("=============================");

		System.out.println("🏪 " + storeName);
		System.out.printf("💰 Ingresos totales: €%.2f%n", totalRevenue);
		System.out.printf("📦 Productos en catálogo: %d%n", inventory.size());
		System.out.printf("👥 Clientes registrados: %d%n", customers.size());
		System.out.printf("👨‍💼 Empleados: %d%n", employees.size());

		if (!inventory.isEmpty()) {
			Product mostExpensive = inventory.get(0);
			Product cheapest = inventory.get(0);

			for (Product product : inventory) {
				if (product.getPrice() > mostExpensive.getPrice()) {
					mostExpensive = product;
				}
				if (product.getPrice() < cheapest.getPrice()) {
					cheapest = product;
				}
			}

			System.out.println("\n💎 Producto más caro: " + mostExpensive);
			System.out.println("💰 Producto más barato: " + cheapest);
		}

		int regularCustomers = 0;
		int vipCustomers = 0;
		int businessCustomers = 0;

		for (Customer customer : customers) {
			if (customer instanceof BusinessCustomer) {
				businessCustomers++;
			} else if (customer instanceof VIPCustomer) {
				vipCustomers++;
			} else {
				regularCustomers++;
			}
		}

		System.out.println("\n👥 DISTRIBUCIÓN DE CLIENTES:");
		System.out.printf("   Regulares: %d%n", regularCustomers);
		System.out.printf("   VIP: %d%n", vipCustomers);
		System.out.printf("   Empresariales: %d%n", businessCustomers);

		int totalStock = inventory.stream().mapToInt(Product::getStockQuantity).sum();
		double totalInventoryValue = 0.0;
		for (Product product : inventory) {
			totalInventoryValue += product.getPrice() * product.getStockQuantity();
		}

		System.out.printf("\n📦 Stock total: %d unidades%n", totalStock);
		System.out.printf("💵 Valor del inventario: €%.2f%n", totalInventoryValue);
	}

	// Getters
	public String getStoreName() {
		return storeName;
	}

	public List<Product> getInventory() {
		return new ArrayList<>(inventory);
	}

	public List<Customer> getCustomers() {
		return new ArrayList<>(customers);
	}

	public List<Employee> getEmployees() {
		return new ArrayList<>(employees);
	}

	public double getTotalRevenue() {
		return totalRevenue;
	}
}
