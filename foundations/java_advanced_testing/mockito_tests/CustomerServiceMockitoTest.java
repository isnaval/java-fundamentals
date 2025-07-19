package java_advanced_testing.mockito_tests;

//==========================================
//FALTA IMPLEMENTAR LAS DEPENDENCIAS MOCK 
//==========================================

/**
 * import static org.junit.Assert.assertNull; import static
 * org.junit.jupiter.api.Assertions.assertEquals; import static
 * org.junit.jupiter.api.Assertions.assertNotNull; import static
 * org.junit.jupiter.api.Assertions.assertTrue;
 * 
 * import org.junit.jupiter.api.BeforeEach;
 * 
 * import java_advanced_testing.model.Customer;
 * 
 * public class CustomerServiceMockitoTest {
 * 
 * @Mock private CustomerService customerService;
 * 
 *       private Customer testCustomer;
 * 
 * @BeforeEach public void setUp() { MockitoAnnotations.openMocks(this);
 *             testCustomer = new Customer("John Doe", "john@example.com",
 *             "+1234567890", 30); }
 * 
 * @Test public void testFindCustomerById() { // Configurar el mock para que
 *       devuelva nuestro customer
 *       when(customerService.findCustomerById(1L)).thenReturn(testCustomer);
 * 
 *       // Ejecutar el método Customer result =
 *       customerService.findCustomerById(1L);
 * 
 *       // Verificar el resultado assertNotNull(result); assertEquals("John
 *       Doe", result.getName()); assertEquals("john@example.com",
 *       result.getEmail());
 * 
 *       // Verificar que el método fue llamado
 *       verify(customerService).findCustomerById(1L); }
 * 
 * @Test public void testSaveCustomer() { // Configurar el mock para simular
 *       guardado exitoso
 *       when(customerService.saveCustomer(any(Customer.class))).thenReturn(true);
 * 
 *       // Ejecutar el método boolean result =
 *       customerService.saveCustomer(testCustomer);
 * 
 *       // Verificar el resultado assertTrue(result);
 * 
 *       // Verificar que el método fue llamado con el customer correcto
 *       verify(customerService).saveCustomer(testCustomer); }
 * 
 * @Test public void testCustomerNotFound() { // Configurar el mock para simular
 *       customer no encontrado
 *       when(customerService.findCustomerById(999L)).thenReturn(null);
 * 
 *       // Ejecutar el método Customer result =
 *       customerService.findCustomerById(999L);
 * 
 *       // Verificar que no se encontró assertNull(result);
 * 
 *       // Verificar que el método fue llamado
 *       verify(customerService).findCustomerById(999L); }
 * 
 *       }
 */
