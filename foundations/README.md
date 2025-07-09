# Java Programming Foundations

Este repositorio contiene ejercicios y proyectos de programación en Java, organizados por temas y niveles de dificultad.

## Estructura del Proyecto

```
└── foundations/
│
├── collections/
│   ├── arraylist/
│   │   ├── ArrayListAdvancedOperations.java
│   │   ├── ArrayListAlgorithms.java
│   │   ├── ArrayListComparison.java
│   │   ├── ArrayListCrudOperations.java
│   │   └── ArrayListIterationMethods.java
│   ├── hashmap/
│   │   ├── collections.hashmap/
│   │   │   ├── HashMapAdvancedMethods.java
│   │   │   ├── HashMapCrudOperations.java
│   │   │   ├── HashMapIterationMethods.java
│   │   │   └── TextFrequencyAnalyzer.java
│   │   ├── collections.hashmap.shop_management/
│   │   │   ├── Product.java
│   │   │   ├── Shop.java
│   │   │   ├── ShopMain.java
│   │   │   └── ShopOperations.java
│   │   ├── collections.hashmap.task_manager/
│   │   │   ├── Task.java
│   │   │   ├── TaskManager.java
│   │   │   ├── TaskManagerMain.java
│   │   │   ├── TaskRepository.java
│   │   │   └── TaskService.java
│   │   └── collections.hashmap.voting_system/
│   │       ├── Main.java
│   │       ├── Votation.java
│   │       ├── VotationCounter.java
│   │       └── VoteOption.java
│   ├── hashset/
│   │   ├── duplicate_remover/
│   │   └── unique_words/
│   └── linkedlist/
│       └── playlist_manager/
│
├── exceptions/
│   ├── bank_transaction_chain/
│   │   ├── ATMErrorException.java
│   │   ├── ATMMain.java
│   │   ├── Bank.java
│   │   ├── BankErrorException.java
│   │   ├── Database.java
│   │   ├── DatabaseErrorException.java
│   │   ├── Server.java
│   │   └── ServerErrorException.java
│   ├── basic_examples/
│   │   ├── CustomException.java
│   │   ├── Finally.java
│   │   ├── MultipleCatch.java
│   │   ├── Throw.java
│   │   ├── Throws.java
│   │   ├── TryCatch.java
│   │   └── TryWithResources.java
│   ├── basic_exception_handling/
│   │   ├── AuxiliarMethods.java
│   │   ├── Division.java
│   │   ├── DivisionCalculatorMain.java
│   │   ├── DivisionService.java
│   │   ├── DivisionValidator.java
│   │   ├── Main.java
│   │   └── Utils.java
│   ├── custom_exceptions/
│   │   ├── Flight.java
│   │   ├── FlightNotFoundException.java
│   │   ├── FlightRepository.java
│   │   ├── FlightReservationMain.java
│   │   ├── FlightService.java
│   │   ├── ReservationMain.java
│   │   ├── ReservationNotFoundException.java
│   │   └── ReservationService.java
│   ├── error_propagation/
│   │   ├── File01.java
│   │   ├── File02.java
│   │   ├── File03.java
│   │   ├── File04.java
│   │   ├── File05.java
│   │   └── Main.java
│   ├── exception_chain_propagation/
│   │   ├── Exception1.java
│   │   ├── Exception2.java
│   │   ├── Exception3.java
│   │   ├── Exception4.java
│   │   ├── File1.java
│   │   ├── File2.java
│   │   ├── File3.java
│   │   ├── File4.java
│   │   ├── File5.java
│   │   └── Main.java
│   ├── geometric_area_calculator/
│   │   ├── AreaCalculator.java
│   │   ├── GeometricCalculatorApp.java
│   │   ├── TestCalculoAreas.java
│   │   ├── UnknownShapeException.java
│   │   └── UserInterface.java
│   ├── user_repository/
│   │   ├── ArrayUserRepository.java
│   │   ├── FindUserHandler.java
│   │   ├── MainArrayUser.java
│   │   ├── UserNotFoundException.java
│   │   ├── UserRepository.java
│   │   └── UserService.java
│   └── validation_utils/
│       ├── LoginValidator.java
│       ├── Main.java
│       └── Utils.java
│
├── java_core/
│   ├── arrays/
│   │   ├── AdvancedArrayMain.java
│   │   ├── AdvancedArrayOperations.java
│   │   ├── AdvancedArrayUtils.java
│   │   ├── ArrayAdvancedOperations.java
│   │   ├── ArrayAverageCalculator.java
│   │   ├── ArrayListBasics.java
│   │   ├── ArrayManipulator.java
│   │   ├── ArrayMaxMinFinder.java
│   │   ├── ConditionalArrayFilter.java
│   │   ├── DynamicArrayInput.java
│   │   ├── FlightSeatReservation.java
│   │   ├── NumberArrayFilter.java
│   │   ├── RangeProcessor.java
│   │   └── SymmetricMatrixChecker.java
│   ├── conditionals/
│   │   ├── basic/
│   │   │   ├── AgeVerifier.java
│   │   │   ├── PasswordChecker.java
│   │   │   └── SimpleCalculator.java
│   │   ├── intermediate/
│   │   │   ├── DivisibilityChecker.java
│   │   │   ├── MonthDays.java
│   │   │   ├── NumberComparisons.java
│   │   │   ├── OddEvenClassifier.java
│   │   │   ├── OddEvenFinder.java
│   │   │   └── ThreeNumberSorter.java
│   │   └── advanced/
│   │       ├── GeometricCalculator.java
│   │       ├── GradeSystem.java
│   │       ├── LotteryPrizeManager.java
│   │       ├── PasswordValidator.java
│   │       └── SpeedTicketCalculator.java
│   ├── games/
│   │   ├── CarRaceGame.java
│   │   ├── DiceGame.java
│   │   ├── FizzBuzz.java
│   │   ├── MazeGame.java
│   │   ├── NumberGuessingGame.java
│   │   ├── RockPaperScissorsAutomata.java
│   │   ├── RockPaperScissorsGame.java
│   │   ├── TreasureHuntGame.java
│   │   ├── WordGuessingGame.java
│   │   └── WordPointsGame.java
│   ├── games.tic_tac_toe/
│   │   ├── EmpateException.java
│   │   ├── GameBoard.java
│   │   ├── TicTacToeGame.java
│   │   └── VictoriaException.java
│   ├── generics.container/
│   │   ├── Container.java
│   │   ├── Product.java
│   │   └── UseContainer.java
│   ├── intermediate/
│   │   ├── CompoundInterestCalculator.java
│   │   ├── Library_Management_System.java
│   │   ├── MatrixOperations.java
│   │   └── ParticleGame.java
│   ├── loops/
│   │   ├── EvenOddSum.java
│   │   ├── FibonacciGenerator.java
│   │   ├── LoopControlFlow.java
│   │   ├── MultiplicationTable.java
│   │   ├── MultiplicationWithLoops.java
│   │   ├── NaturalNumberSum.java
│   │   ├── NumberPrinter.java
│   │   ├── PatternPrinter.java
│   │   └── SumaMethodsDemo.java
│   ├── strings/
│   │   ├── basic/
│   │   │   ├── AcronymGenerator.java
│   │   │   ├── CharacterFinder.java
│   │   │   ├── CharacterSplitter.java
│   │   │   ├── CharacterValidator.java
│   │   │   ├── CoffeeUtilities.java
│   │   │   ├── EmployeeUsernameGenerator.java
│   │   │   ├── PalindromeChecker.java
│   │   │   ├── PrintfFormatter.java
│   │   │   ├── StringProcessor.java
│   │   │   └── StringUtilitiesDemo.java
│   │   ├── validation/
│   │   │   ├── AnagramChecker.java
│   │   │   ├── CreditCardMasker.java
│   │   │   └── PasswordValidator.java
│   │   └── advanced/
│   │       ├── MorseCodeConverter.java
│   │       ├── PalindromeChecker.java
│   │       ├── PrintfFormatter.java
│   │       ├── ReservedWordsChecker.java
│   │       └── TextProcessor.java
│   └── strings.advanced.URL_patterns/
│       ├── CommentModerator.java
│       ├── SecurityAnalyzer.java
│       ├── URLDetectorMain.java
│       ├── URLExtractor.java
│       └── URLPatterns.java
│
├── java_core_basic/
│   ├── Basic_Math_Operations.java
│   ├── Basic_NumberAnalyzerCalculator.java
│   ├── Basic_Scanner.java
│   ├── Basic_switch.java
│   ├── Exercise_Loop_Fundamentals.java
│   ├── Exercise_Number_Game.java
│   ├── File_Processing.java
│   ├── Logical_Operators.java
│   ├── String_Complete_Methods.java
│   ├── String_Manipulation_Applications.java
│   ├── String_Search_Methods.java
│   ├── String_User_Input_Comparison.java
│   ├── String_Validation_Comparison.java
│   ├── basic_algorithms/
│   │   ├── ArmstrongNumber.java
│   │   ├── DigitReverse.java
│   │   ├── DiscountCalculator.java
│   │   ├── FactorialCalculator.java
│   │   ├── NumberRangeAnalyzer.java
│   │   ├── NumberToWordsConverter.java
│   │   ├── NutritionalCalculator.java
│   │   ├── PowerCalculator.java
│   │   ├── PrimeNumberChecker.java
│   │   ├── PrimeNumberFinder.java
│   │   ├── TeaCalculator.java
│   │   └── TimeConverter.java
│   ├── basic_algorithms.armstrong_numbers/
│   │   ├── Armstrong.java
│   │   └── Main.java
│   ├── basic_operations/
│   │   ├── Basic_Operations.java
│   │   ├── NumberValidator.java
│   │   └── StatisticsCalculator.java
│   ├── core_operations/
│   │   ├── ComparisonOperations.java
│   │   ├── DateTimeOperations.java
│   │   ├── InteractiveGames.java
│   │   ├── MainController.java
│   │   ├── MathOperations.java
│   │   ├── SequenceOperations.java
│   │   └── TextConversionOperations.java
│   ├── practical_applications/
│   │   ├── CaloriesCalculator.java
│   │   ├── GradeClassifier.java
│   │   ├── SalaryCalculator.java
│   │   ├── TrafficFineCalculator.java
│   │   └── UniCalculator.java
│   ├── streams/
│   │   ├── StreamAdvanced.java
│   │   ├── StreamBasics.java
│   │   ├── StreamChallenges.java
│   │   ├── StreamCollections.java
│   │   ├── StreamController.java
│   │   ├── StreamNumbers.java
│   │   ├── StreamObjects.java
│   │   ├── StreamPerformance.java
│   │   └── StreamStrings.java
│   └── unified_operations/
│       ├── ComparisonOperations.java
│       ├── DateTimeOperations.java
│       ├── InteractiveGames.java
│       ├── MainController.java
│       ├── MathOperations.java
│       ├── SequenceOperations.java
│       └── TextConversionOperations.java
│
├── java_core_intermediate/
│   ├── exercise_Business_Applications/
│   │   └── main.java
│   └── collections_validation/
│
├── java_core_strings.advanced/
│   ├── PalindromeChecker.java
│   └── TextProcessor.java
│
└── java_oop/
    ├── advanced/
    │   └── weapon_system/
    │       ├── AmmunitionType.java
    │       ├── Main.java
    │       ├── PersonalUse.java
    │       ├── Rifle.java
    │       ├── Tank.java
    │       ├── TerrainUse.java
    │       └── Weapon.java
    ├── basics/
    │   ├── bar_order_system/
    │   │   ├── Client.java
    │   │   ├── Drink.java
    │   │   ├── DrinkManager.java
    │   │   ├── Drinks.java
    │   │   ├── MainBar.java
    │   │   └── Order.java
    │   ├── discount_system/
    │   │   ├── DiscountCalculatorInterface.java
    │   │   ├── FixedDiscountCalculator.java
    │   │   ├── PercentageDiscountCalculator.java
    │   │   └── TestMain.java
    │   ├── shape_calculator/
    │   │   ├── Circle.java
    │   │   ├── Rectangle.java
    │   │   ├── Shape.java
    │   │   ├── ShapeCalculatorMain.java
    │   │   ├── Square.java
    │   │   └── Triangle.java
    │   ├── smart_devices/
    │   │   ├── Device.java
    │   │   ├── DeviceManager.java
    │   │   ├── Main.java
    │   │   ├── MobilePhone.java
    │   │   ├── Photograph.java
    │   │   ├── Radioable.java
    │   │   ├── SmartWatch.java
    │   │   └── Trackeable.java
    │   ├── sports_equipment/
    │   │   ├── Ball.java
    │   │   ├── Basketball.java
    │   │   ├── Equipment.java
    │   │   ├── Football.java
    │   │   ├── Inflatable.java
    │   │   ├── Main.java
    │   │   └── SportsManager.java
    │   ├── student_system_1/
    │   │   ├── Coche.java
    │   │   ├── Estudiante.java
    │   │   ├── Main.java
    │   │   ├── MiembroUPV.java
    │   │   ├── Persona.java
    │   │   ├── Printable.java
    │   │   └── Printer.java
    │   ├── student_system_2.exceptions/
    │   │   └── PersonExist.java
    │   ├── student_system_2.main/
    │   │   └── Main.java
    │   ├── student_system_2.management/
    │   │   ├── ListOfPeople.java
    │   │   └── StudentMenuManagement.java
    │   ├── student_system_2.people/
    │   │   ├── Car.java
    │   │   ├── Person.java
    │   │   └── Student.java
    │   └── tienda_productos_system/
    │       ├── TiendaProductosMain.java
    │       ├── interfaces/
    │       │   ├── Joya.java
    │       │   ├── Juguete.java
    │       │   └── Producto.java
    │       ├── productos.joyas/
    │       │   ├── AnilloConDiamantes.java
    │       │   └── CollarConPerlas.java
    │       ├── productos.juguetes/
    │       │   ├── JugueteElectronico.java
    │       │   └── JuguetePeluche.java
    │       └── productos.tecnologias/
    │           └── ProductoTecnologia.java
    └── medium/
        └── email_generator/
            ├── AbstractEmailGenerator.java
            ├── EmailGeneratorInterface.java
            ├── EmailGeneratorMain.java
            ├── User.java
            ├── UserEmailGenerator.java
            └── generators/
                ├── AcronymGenerator.java
                ├── FullNameWithDotsGenerator.java
                ├── InitialWithSurnamesGenerator.java
                ├── NameWithSurnameInitialsGenerator.java
                └── SurnamesFirstGenerator.java
```
## Descripción de las Secciones

### Collections
Ejercicios sobre las estructuras de datos fundamentales de Java:
- **ArrayList**: Operaciones CRUD, algoritmos, iteración y comparación
- **HashMap**: Sistema de votación, gestión de tienda y tareas
- **HashSet**: Eliminación de duplicados y palabras únicas
- **LinkedList**: Gestor de listas de reproducción

### Exceptions
Manejo completo de excepciones en Java:
- **Basic Examples**: Ejemplos fundamentales de try-catch, throw, finally
- **Custom Exceptions**: Creación de excepciones personalizadas
- **Error Propagation**: Propagación de errores entre clases
- **Real Applications**: Sistemas bancarios, repositorios de usuarios

### Java Core
Fundamentos del lenguaje:
- **Arrays**: Manipulación y operaciones avanzadas
- **Conditionals**: Ejercicios básicos, intermedios y avanzados
- **Games**: Implementaciones de juegos clásicos
- **Loops**: Estructuras repetitivas y patrones
- **Strings**: Procesamiento y validación de texto

### Java OOP
Programación Orientada a Objetos:
- **Basics**: Sistemas simples con herencia e interfaces
- **Medium**: Patrón Strategy con generador de emails
- **Advanced**: Sistema de armas con herencia compleja

## Tecnologías Utilizadas
- Java 8+
- Paradigma de Programación Orientada a Objetos
- Manejo de Excepciones
- Colecciones de Java
- Patrones de Diseño

## Cómo Usar Este Repositorio
1. Clona el repositorio
2. Importa el proyecto en tu IDE favorito (Eclipse, IntelliJ IDEA, VS Code)
3. Navega por las carpetas según el tema que quieras estudiar
4. Cada clase contiene ejemplos ejecutables con su método main()

## Autor
IsmaelNV

## Licencia
Este proyecto está bajo la Licencia MIT - mira el archivo LICENSE para más detalles.