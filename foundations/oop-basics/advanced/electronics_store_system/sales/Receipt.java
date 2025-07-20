package java_oop.advanced.electronics_store_system.sales;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipt {
	private String receiptNumber;
	private Sale sale;
	private LocalDateTime printDateTime;
	private String storeName;
	private String storeAddress;
	private String storeTaxId;
	private boolean isPrinted;

	public Receipt(Sale sale) {
		this.sale = sale;
		this.receiptNumber = generateReceiptNumber();
		this.printDateTime = LocalDateTime.now();
		this.storeName = "TechWorld Electronics";
		this.storeAddress = "Calle Tecnología 123, 28001 Madrid";
		this.storeTaxId = "B-12345678";
		this.isPrinted = false;
	}

	private String generateReceiptNumber() {
		return "REC-" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
	}

	public void printReceipt() {
		isPrinted = true;

		System.out.println("\n" + "=".repeat(50));
		System.out.println("                  " + storeName);
		System.out.println("              " + storeAddress);
		System.out.println("                NIF: " + storeTaxId);
		System.out.println("=".repeat(50));
		System.out.println("               TICKET DE VENTA");
		System.out.println("=".repeat(50));

		System.out.println("Recibo Nº: " + receiptNumber);
		System.out.println("Venta Nº: " + sale.getSaleId());
		System.out.println("Fecha: " + sale.getSaleDateTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
		System.out.println("Atendido por: " + sale.getEmployee().getName());

		if (sale.getCustomer() != null) {
			System.out.println("Cliente: " + sale.getCustomer().getName());
		}

		System.out.println("-".repeat(50));
		System.out.println("CANT  DESCRIPCIÓN                    IMPORTE");
		System.out.println("-".repeat(50));

		for (SaleItem item : sale.getItems()) {
			String description = String.format("%s %s", item.getProduct().getBrand(), item.getProduct().getModel());
			if (description.length() > 25) {
				description = description.substring(0, 25);
			}

			System.out.printf("%-4d  %-25s  %8.2f€%n", item.getQuantity(), description, item.getLineTotal());

			if (item.getDiscountAmount() > 0) {
				System.out.printf("      Descuento %.1f%%           %8.2f€%n", item.getDiscountPercentage(),
						-item.getDiscountAmount());
			}
		}

		System.out.println("-".repeat(50));
		System.out.printf("SUBTOTAL:                        %8.2f€%n", sale.getSubtotal());
		System.out.printf("IVA (%.1f%%):                       %8.2f€%n", sale.getTaxPercentage(), sale.getTaxAmount());
		System.out.println("=".repeat(50));
		System.out.printf("TOTAL:                           %8.2f€%n", sale.getTotal());
		System.out.println("=".repeat(50));

		if (sale.getPaymentMethod() != null) {
			System.out.println("Método de pago: " + sale.getPaymentMethod().getName());
		}

		System.out.println("\n           ¡Gracias por su compra!");
		System.out.println("      Conserve este ticket para garantías");
		System.out.println("=".repeat(50));

		System.out.println("✅ Recibo impreso: " + receiptNumber);
	}

	public void emailReceipt(String emailAddress) {
		System.out.printf("📧 Recibo enviado por email a: %s%n", emailAddress);
		System.out.println("   Asunto: Recibo de compra - " + receiptNumber);
	}

	public String generateReceiptText() {
		StringBuilder receipt = new StringBuilder();

		receipt.append(storeName).append("\n");
		receipt.append(storeAddress).append("\n");
		receipt.append("NIF: ").append(storeTaxId).append("\n\n");
		receipt.append("TICKET DE VENTA\n");
		receipt.append("Recibo Nº: ").append(receiptNumber).append("\n");
		receipt.append("Venta Nº: ").append(sale.getSaleId()).append("\n");
		receipt.append("Fecha: ").append(sale.getSaleDateTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")))
				.append("\n");
		receipt.append("Empleado: ").append(sale.getEmployee().getName()).append("\n");

		if (sale.getCustomer() != null) {
			receipt.append("Cliente: ").append(sale.getCustomer().getName()).append("\n");
		}

		receipt.append("\nARTÍCULOS:\n");
		for (SaleItem item : sale.getItems()) {
			receipt.append(String.format("%dx %s %s - €%.2f\n", item.getQuantity(), item.getProduct().getBrand(),
					item.getProduct().getModel(), item.getLineTotal()));
		}

		receipt.append(String.format("\nSubtotal: €%.2f\n", sale.getSubtotal()));
		receipt.append(String.format("IVA (%.1f%%): €%.2f\n", sale.getTaxPercentage(), sale.getTaxAmount()));
		receipt.append(String.format("TOTAL: €%.2f\n", sale.getTotal()));

		return receipt.toString();
	}

	// Getters
	public String getReceiptNumber() {
		return receiptNumber;
	}

	public Sale getSale() {
		return sale;
	}

	public LocalDateTime getPrintDateTime() {
		return printDateTime;
	}

	public String getStoreName() {
		return storeName;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public String getStoreTaxId() {
		return storeTaxId;
	}

	public boolean isPrinted() {
		return isPrinted;
	}

	// Setters
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public void setStoreTaxId(String storeTaxId) {
		this.storeTaxId = storeTaxId;
	}

	public boolean isHasImageStabilization() {
		return isHasImageStabilization();
	}
}