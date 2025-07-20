# Flujo del Ejercicio: Sistema de Gestión de Experimentos Científicos
## Propósito
Sistema para gestionar experimentos científicos (físicos y biológicos) en un proyecto, demostrando POO avanzada: herencia, interfaces, excepciones personalizadas y patrón Strategy.

## Clases y Roles

- Analizable.java: Interfaz para estrategias de análisis (analizarResultados()).
- AnalisisEstandar.java: Estrategia de análisis estándar.
- AnalisisAvanzado.java: Estrategia de análisis avanzado.
- ExperimentoFallidoException.java: Excepción para experimentos fallidos.
- Experimento.java: Clase abstracta base (atributos: nombre, descripcion, estrategiaAnalisis).
- ExperimentoConOrganismo.java: Clase abstracta intermedia (atributos: organismo, nivelAmenaza; valida entrada).
- ExperimentoFisico.java: Experimento físico, personaliza análisis.
- ExperimentoBiologico.java: Experimento biológico, personaliza análisis.
- ProyectoInvestigacion.java: Gestiona colección de experimentos (List<Experimento>).
- MainExperimentos.java: Clase principal, prueba el sistema.

## Flujo de Ejecución

Inicio (MainExperimentos):

Crea estrategias (AnalisisEstandar, AnalisisAvanzado).
Crea experimentos (ExperimentoFisico, ExperimentoBiologico) con validación.
Crea ProyectoInvestigacion y agrega experimentos.

Ejecución (ProyectoInvestigacion.ejecutarExperimentos()):

Para cada experimento:
Llama ejecutarExperimento() (valida entrada si/no).
Si falla, lanza ExperimentoFallidoException (capturada y mostrada).

Análisis (ProyectoInvestigacion.analizarResultados()):

Para cada experimento:
Llama analizarResultados() (usa estrategia Analizable).
Muestra resultados específicos (físico/biologico) + análisis.

Fin: Muestra resultados o errores.


´´´
Diagrama Textual
MainExperimentos
  ├── Crea: AnalisisEstandar, AnalisisAvanzado
  ├── Crea: ExperimentoFisico, ExperimentoBiologico
  ├── Crea: ProyectoInvestigacion
  │   ├── Agrega experimentos
  │   ├── ejecutarExperimentos()
  │   │   ├── ExperimentoConOrganismo.ejecutarExperimento()
  │   │   │   ├── esExitoso() (entrada si/no)
  │   │   │   ├── Lanza ExperimentoFallidoException si "no"
  │   │   ├── Captura excepción
  │   ├── analizarResultados()
  │   │   ├── Experimento.analizarResultados()
  │   │   │   ├── Analizable.analizarResultados()
  │   │   │   ├── Resultados específicos (físico/biologico)
  └── Fin
´´´

# Ejemplo de Salida
Ejecutando experimentos del proyecto 'Proyecto Alfa':
Ejecutando experimento 'ExpFisico1' con organismo: Partícula X
¿El experimento 'ExpFisico1' ha tenido éxito? (si/no) -> si
Ejecutando experimento 'ExpBio1' con organismo: Bacteria Y
¿El experimento 'ExpBio1' ha tenido éxito? (si/no) -> no
Error: El experimento 'ExpBio1' ha fallado.

Analizando resultados del proyecto 'Proyecto Alfa':
Análisis específico para experimento físico 'ExpFisico1':
Organismo: Partícula X, Nivel de amenaza: 1
Análisis estándar para 'ExpFisico1':
Descripción: Estudio de partículas
Resultados: Datos recopilados según protocolo estándar.
