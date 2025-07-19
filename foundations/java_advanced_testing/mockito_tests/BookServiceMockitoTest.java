package java_advanced_testing.mockito_tests;

// ==========================================

// FALTA IMPLEMENTAR LAS DEPENDENCIAS MOCK 
// ==========================================

/**
 * import static org.junit.jupiter.api.Assertions.assertEquals; import static
 * org.junit.jupiter.api.Assertions.assertFalse; import static
 * org.junit.jupiter.api.Assertions.assertNotNull; import static
 * org.junit.jupiter.api.Assertions.assertTrue; import static
 * org.mockito.Mockito.*;
 * 
 * import org.junit.jupiter.api.BeforeEach; import org.junit.jupiter.api.Test;
 * import org.mockito.Mock; import org.mockito.MockitoAnnotations;
 * 
 * import java_advanced_testing.model.Book; import
 * java_advanced_testing.resources.test_data.BookTestData;
 * 
 * public class BookServiceMockitoTest {
 * 
 * @Mock private BookRepository bookRepository;
 * 
 *       private BookService bookService; private Book testBook;
 * 
 * @BeforeEach public void setUp() { MockitoAnnotations.openMocks(this);
 *             bookService = new BookService(bookRepository); testBook =
 *             BookTestData.createValidBook(); }
 * 
 * @Test public void testGetBookByIsbn() { // Configurar el mock
 *       when(bookRepository.findByIsbn("978-84-376-0494-7")).thenReturn(testBook);
 * 
 *       // Ejecutar Book result =
 *       bookService.getBookByIsbn("978-84-376-0494-7");
 * 
 *       // Verificar assertNotNull(result); assertEquals(testBook.getTitle(),
 *       result.getTitle()); assertEquals(testBook.getAuthor(),
 *       result.getAuthor());
 * 
 *       // Verificar interacción
 *       verify(bookRepository).findByIsbn("978-84-376-0494-7"); }
 * 
 * @Test public void testCreateBookSuccess() { // Configurar el mock para
 *       simular guardado exitoso
 *       when(bookRepository.save(any(Book.class))).thenReturn(true);
 * 
 *       // Ejecutar boolean result = bookService.createBook(testBook);
 * 
 *       // Verificar assertTrue(result); verify(bookRepository).save(testBook);
 *       }
 * 
 * @Test public void testCreateBookWithNegativePrice() { // Crear libro con
 *       precio negativo Book invalidBook = new Book("Test", "Author", "123",
 *       -10.0);
 * 
 *       // Ejecutar boolean result = bookService.createBook(invalidBook);
 * 
 *       // Verificar que falló sin llamar al repository assertFalse(result);
 *       verify(bookRepository, never()).save(any(Book.class)); }
 * 
 *       }
 **/