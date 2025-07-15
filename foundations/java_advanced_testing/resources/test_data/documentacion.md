# Test Data Classes - Documentación

## Descripción General

Las **Test Data Classes** son clases utilitarias diseñadas para crear objetos de prueba de manera consistente y reutilizable en el desarrollo de tests unitarios y de integración. Estas clases siguen el patrón **Object Mother** y **Test Data Builder**, facilitando la creación de datos de prueba predecibles y mantenibles.

## Estructura del Proyecto

```
java_advanced_testing/resources/test_data/
├── TestDataConstants.java     # Constantes centralizadas
├── BookTestData.java         # Factory para objetos Book
├── CustomerTestData.java     # Factory para objetos Customer
├── EmployeeTestData.java     # Factory para objetos Employee
└── ProjectTestData.java      # Factory para objetos Project
```

## Clases Principales

### 1. TestDataConstants.java

**Propósito**: Centralizar todas las constantes utilizadas en los tests para evitar la duplicación de código y facilitar el mantenimiento.

**Características**:
- Contiene valores predefinidos para todos los objetos de dominio
- Facilita la modificación de datos de prueba desde un punto central
- Mejora la consistencia entre diferentes tests

**Ejemplo de uso**:
```java
String expectedTitle = TestDataConstants.BOOK_TITLE; // "El Quijote"
```

### 2. BookTestData.java

**Propósito**: Crear instancias de `Book` para diferentes escenarios de prueba.

**Métodos disponibles**:
- `createValidBook()` - Libro con datos válidos estándar
- `createBookWithoutTitle()` - Libro sin título (para tests de validación)
- `createExpensiveBook()` - Libro con precio alto
- `createFreeBook()` - Libro gratuito

**Casos de uso**:
- Tests de validación de campos obligatorios
- Tests de cálculos de precio
- Tests de reglas de negocio relacionadas con libros

### 3. CustomerTestData.java

**Propósito**: Generar objetos `Customer` para diferentes perfiles de usuarios.

**Métodos disponibles**:
- `createValidCustomer()` - Cliente adulto estándar
- `createMinorCustomer()` - Cliente menor de edad
- `createSeniorCustomer()` - Cliente de tercera edad
- `createCustomerWithInvalidEmail()` - Cliente con email inválido

**Casos de uso**:
- Tests de validación de edad
- Tests de restricciones por edad
- Tests de validación de email
- Tests de segmentación de clientes

### 4. EmployeeTestData.java

**Propósito**: Crear empleados con diferentes perfiles salariales y departamentales.

**Métodos disponibles**:
- `createValidEmployee()` - Empleado estándar
- `createHighSalaryEmployee()` - Empleado con salario alto
- `createInternEmployee()` - Empleado en prácticas
- `createEmployeeWithoutEmail()` - Empleado sin email

**Casos de uso**:
- Tests de cálculos salariales
- Tests de políticas de empresa
- Tests de validación de datos de empleados
- Tests de jerarquías organizacionales

### 5. ProjectTestData.java

**Propósito**: Crear proyectos con diferentes estados y configuraciones.

**Métodos disponibles**:
- `createValidProject()` - Proyecto estándar de 90 días
- `createShortProject()` - Proyecto de corta duración (7 días)
- `createProjectWithTeam()` - Proyecto con equipo asignado
- `createExpiredProject()` - Proyecto ya finalizado

**Casos de uso**:
- Tests de gestión de tiempo
- Tests de asignación de equipos
- Tests de estados de proyecto
- Tests de cálculos de duración

## Ventajas de este Enfoque

### 1. **Reutilización**
- Los mismos objetos de prueba se pueden usar en múltiples tests
- Evita la duplicación de código de creación de objetos

### 2. **Mantenibilidad**
- Cambios en la estructura de datos solo requieren actualizar las factory classes
- Constantes centralizadas facilitan modificaciones globales

### 3. **Legibilidad**
- Los nombres de métodos son autodescriptivos
- Es fácil entender qué tipo de objeto se está creando

### 4. **Consistencia**
- Todos los tests utilizan los mismos datos base
- Reduce la variabilidad no deseada en las pruebas

## Casos de Uso Comunes

### Testing de Validaciones
```java
@Test
public void testBookValidation() {
    Book invalidBook = BookTestData.createBookWithoutTitle();
    // Test que el libro sin título falle la validación
}
```

### Testing de Reglas de Negocio
```java
@Test
public void testDiscountForSeniors() {
    Customer senior = CustomerTestData.createSeniorCustomer();
    // Test que clientes mayores reciban descuento
}
```

### Testing de Cálculos
```java
@Test
public void testSalaryCalculation() {
    Employee highSalary = EmployeeTestData.createHighSalaryEmployee();
    // Test cálculos con salarios altos
}
```

### Testing de Estados
```java
@Test
public void testExpiredProject() {
    Project expired = ProjectTestData.createExpiredProject();
    // Test comportamiento con proyectos vencidos
}
```

## Mejores Prácticas

1. **Usar nombres descriptivos**: Los métodos deben indicar claramente qué tipo de objeto crean
2. **Mantener simplicidad**: Cada método debe crear un objeto con un propósito específico
3. **Evitar lógica compleja**: Las factory classes deben ser simples y directas
4. **Centralizar constantes**: Usar `TestDataConstants` para todos los valores reutilizables
5. **Documentar casos especiales**: Comentar objetos que representen casos edge o estados específicos

## Extensibilidad

Para agregar nuevos tipos de objetos de prueba:

1. Crear una nueva clase `XxxTestData.java`
2. Agregar las constantes necesarias en `TestDataConstants.java`
3. Implementar métodos factory siguiendo las convenciones existentes
4. Documentar los casos de uso específicos

Esta estructura proporciona una base sólida para el testing, facilitando la creación de tests más robustos y mantenibles.