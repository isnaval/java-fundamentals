# DOCUMENTACIÓN DE TESTING 


- **Tests unitarios** que verifican que cada clase funciona correctamente
- **Tests de integración** que prueban que múltiples clases trabajen juntas
- **Tests mock** que simulan respuestas de APIs externas
- **Tests profesionales** usando frameworks JUnit y Mockito


##  TESTS UNITARIOS

### ¿Qué son?
Los **tests unitarios** prueban **una clase a la vez** para verificar que funciona correctamente de forma aislada.

### ¿Qué probamos?
- **Constructores:** ¿Se crean los objetos correctamente?
- **Getters/Setters:** ¿Funcionan bien para obtener y establecer valores?
- **Métodos:** ¿Los métodos devuelven lo que esperamos?
- **Validaciones:** ¿Se comportan bien con datos válidos e inválidos?

##  TESTS MOCK

### ¿Qué son?
Los **tests mock** simulan respuestas de **servicios externos** (como APIs, bases de datos) sin llamarlos realmente.

### ¿Por qué los usamos?
- **No dependemos** de servicios externos para probar nuestro código
- **Controlamos** exactamente qué respuesta recibimos
- **Tests más rápidos** porque no hacemos llamadas reales
- **Podemos simular errores** que serían difíciles de reproducir

### ¿Qué simulamos?
- **Respuestas JSON** de APIs de clientes
- **Respuestas de productos** con diferentes precios
- **Errores HTTP** (404, 500, etc.)
- **Casos especiales** como clientes menores de edad


## TESTS DE INTEGRACIÓN

### ¿Qué son?
Los **tests de integración** prueban que **múltiples clases funcionan juntas** correctamente.

### Tipos implementados:

#### Component Integration
Prueba **2-3 clases** trabajando juntas:
- **Book + Customer:** ¿Un cliente puede comprar un libro?
- **Employee + Project:** ¿Un empleado se puede asignar a un proyecto?
- **Customer + Employee:** ¿Un empleado puede atender a un cliente?

#### System Integration
Prueba **todo el sistema** funcionando como conjunto:
- **Workflow completo:** Cliente → Empleado → Libro → Proyecto → Producto
- **Operaciones empresariales:** Toda la empresa funcionando
- **Integridad de datos:** Toda la información es consistente


## TESTS JUNIT

### ¿Qué son?
**JUnit** es un framework profesional que hace los tests más **organizados y potentes** que nuestros tests manuales.

## 🎭 TESTS MOCKITO

### ¿Qué son?
**Mockito** es un framework que crea **objetos simulados automáticamente** y verifica **cómo interactúan** con nuestro código.

### Ventajas de Mockito:
- **Mocks automáticos** - No crear respuestas JSON manualmente
- **Verificación de llamadas** - ¿Se llamó el método correcto?
- **Comportamiento dinámico** - Diferentes respuestas según parámetros
- **Inyección automática** - Los mocks se crean solos

### Anotaciones principales:
- **`@Mock`** - Crea objeto simulado automáticamente
- **`@InjectMocks`** - Inyecta mocks en el objeto a probar
- **`when().thenReturn()`** - Configura qué devuelve el mock
- **`verify()`** - Verifica que se llamó un método

