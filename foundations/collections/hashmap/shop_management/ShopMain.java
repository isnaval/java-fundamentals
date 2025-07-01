package collections.hashmap.shop_management;

import java.util.Scanner;

public class ShopMain {
	public static void main(String[] args) {
		Shop tienda = new Shop("La tiene de Java");
		ShopOperations operations = new ShopOperations(tienda);
		Scanner scanner = new Scanner(System.in);
		System.out.println("🛍️  Bienvenido a " + tienda.getShopName() + "!");

		while (true) {
			showMenu();
			int option = scanner.nextInt();
			scanner.nextLine();

			switch (option) {
			case 1:
				operations.displayProducts();
				break;
			case 2:
				System.out.print("\nProducto a vender: ");
				String productToSell = scanner.nextLine();
				System.out.print("Cantidad: ");
				int quantityToSell = scanner.nextInt();
				operations.sellProduct(productToSell, quantityToSell);
				break;
			case 3:
				System.out.print("\nProducto a reabastecer: ");
				String productToRestock = scanner.nextLine();
				System.out.print("Cantidad a agregar: ");
				int quantityToAdd = scanner.nextInt();
				operations.restockProduct(productToRestock, quantityToAdd);
				break;

			case 4:
				operations.addNewProduct(scanner);
				break;

			case 5:
				operations.showLowStock();
				break;

			case 6:
				operations.showInventoryValue();
				break;

			case 7:
				System.out.println("\n👋 ¡Gracias por usar el sistema!");
				scanner.close();
				return;

			default:
				System.out.println("❌ Opción no válida");
			}
			System.out.print("\nPresione Enter para continuar...");
			scanner.nextLine();
		}
	}

	private static void showMenu() {
		System.out.println("\n╔════════════════════════════════╗");
		System.out.println("║     SISTEMA DE INVENTARIO      ║");
		System.out.println("╠════════════════════════════════╣");
		System.out.println("║ 1. Ver productos               ║");
		System.out.println("║ 2. Vender producto             ║");
		System.out.println("║ 3. Reabastecer producto        ║");
		System.out.println("║ 4. Agregar nuevo producto      ║");
		System.out.println("║ 5. Ver productos con bajo stock║");
		System.out.println("║ 6. Ver valor del inventario    ║");
		System.out.println("║ 7. Salir                       ║");
		System.out.println("╚════════════════════════════════╝");
		System.out.print("Seleccione opción: ");
	}

}
