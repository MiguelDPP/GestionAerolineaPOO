# Sistema de Gestión de Asientos y Comidas de un Avión

## Descripción General

Este proyecto consiste en el desarrollo de una aplicación de consola orientada a objetos para la gestión de aviones, venta de asientos y administración de pedidos de comida realizados por los pasajeros durante un vuelo.

El sistema permite registrar múltiples aviones, controlar la ocupación de los asientos, administrar un menú de comidas y consultar el valor total consumido por cada pasajero, incluyendo el costo del asiento y los productos solicitados.

## Objetivos

- Gestionar la información de diferentes aviones.
- Controlar la disponibilidad y venta de asientos.
- Administrar un menú de comidas para los pasajeros.
- Registrar pedidos asociados a cada pasajero.
- Calcular el total consumido por un pasajero.
- Aplicar conceptos de Programación Orientada a Objetos mediante el uso de clases, atributos, relaciones entre objetos y estructuras de almacenamiento.

## Funcionalidades

### Añadir avión

Permite registrar nuevos aviones en el sistema almacenando información como:

- Nombre del piloto.
- Placa o identificación del avión.
- Precio del asiento.
- Destino del vuelo.
- Cantidad de filas y columnas de la silletería.

Además, el sistema muestra la lista de todos los aviones registrados junto con su información principal.

### Vender asiento

Permite seleccionar un avión y vender uno de sus asientos disponibles.

El sistema muestra gráficamente la distribución de la silletería, indicando los asientos libres y ocupados. Una vez seleccionado un asiento disponible, se registra la información del pasajero y el asiento pasa a estado ocupado.

### Añadir comida al menú

Permite registrar nuevos productos o platos que estarán disponibles para los pasajeros durante el vuelo.

Cada comida almacena su nombre y precio. El sistema mantiene un listado actualizado de todas las opciones disponibles en el menú.

### Hacer pedido de comida

Permite registrar pedidos de comida para un pasajero específico.

Para realizar el pedido se selecciona una comida del menú, el avión correspondiente y posteriormente el asiento del pasajero. Las comidas solicitadas quedan asociadas al asiento para mantener un historial de consumo individual.

### Consultar total por pasajero

Permite obtener el detalle de consumo de un pasajero determinado.

La consulta incluye:

- Información del pasajero.
- Precio del asiento adquirido.
- Listado de comidas solicitadas.
- Valor individual de cada producto.
- Total acumulado a pagar.

### Salir del programa

Finaliza la ejecución de la aplicación.

## Estructura del Sistema

### Gestión de Aviones

Es el componente encargado de administrar los aviones registrados y el menú de comidas disponible para los pasajeros.

### Avión

Representa cada aeronave registrada en el sistema y almacena información relacionada con:

- Nombre del piloto.
- Precio del asiento.
- Placa.
- Destino.
- Cantidad de filas.
- Cantidad de columnas.
- Distribución de asientos.

### Asiento

Representa cada posición disponible dentro de la aeronave.

Cada asiento almacena:

- Número identificador.
- Estado de ocupación.
- Nombre del pasajero.
- Edad del pasajero.
- Historial de comidas solicitadas.

### Comida

Representa un producto disponible en el menú del avión.

Cada comida almacena:

- Nombre.
- Precio.

## Conceptos Aplicados

Durante el desarrollo de este proyecto se implementan conceptos fundamentales de Programación Orientada a Objetos, entre ellos:

- Encapsulamiento.
- Composición entre clases.
- Gestión de objetos.
- Arreglos bidimensionales.
- Colecciones dinámicas.
- Relaciones entre entidades.
- Menús interactivos por consola.
- Administración de datos estructurados.