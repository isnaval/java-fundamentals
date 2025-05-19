1.
Lo primero que hago es definir una interface DiscountCalculatorInterface para realizar el calculo del descuento sobre un precio original 
 - genero un metodo  calculateDiscount y uso argumento originalPrice

 2. 
 Creo una clase FixedDiscountCalculatorpara ajustar el descuento donde implemento el interface
 - genero la variable de precio fijo fixedDiscount
 - genero un constructor FixedDiscountCalculator con el argumento fixedDiscount
 - sobrescribo un metodo calculateDiscount con el argumento originalPrice y me devuelve el precio ajustado restando sobre el rpecio inicial menos el descuento 
 
 3. 
 Creo una clase para calcular el descuento implemento el interface
 - declaro la variable percentageDiscount
 - genero un constructor PercentageDiscountCalculator con el argumento percentageDiscount 
 - genero otra metodo calculateDiscount con el armento originalPrice que en caso que el precio origianl sea superior a 0, y me devuelve el precio final  

4. 
Genero una clase de control de test para saber que funcionan bien 3 metodos


=== 
Este ejercicio aplica los principios SOLID: 
O (abierto/cerrado) porque puedo añadir nuevos tipos de descuentos sin modificar el código existente gracias a la interfaz; 
D (inversión de dependencias) porque las clases dependen de la abstracción y no de implementaciones concretas; 
y S (responsabilidad única) porque cada clase tiene una sola función. 
Esto permite reutilizar el sistema en otras aplicaciones de cálculo de descuentos.