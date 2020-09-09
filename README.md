# CatApp Frontend Asíncrono.

Proyecto Java que consume un API publica la cual puede encontrarse en [El siguiente Link](https://thecatapi.com/). Esta trae información relacionada con imágenes de gatos. Para esto se realizan **peticiones HTTP** y gestión de **operaciones Asíncronas** para no afectar el flujo de la aplicación.

La aplicación pretende mostrar la representación de una fundación en la que se puede ver imágenes de gatos por medio de la Api publica y escoger las imágenes favoritas, al igual que eliminar las imágenes de la lista de favoritos.

## Descripción

En el ejemplo se presenta: 
* Uso de **OkHttpClient** como dependencia para realizar peticiones HTTP a un API externa.
* Peticiones HTTP como **GET, POST, DELETE** para gestionar información proporcionada por el API publica.
* Autenticación por medio de token para envió de peticiones HTTP.
* Uso de **SwingWorker** para control de operaciones asíncronas dentro del EDT de  Java Swing.
* Interfaz de usuario desde código Java (sin utilizar asistentes de GUI).
* Enfoque de **ComponentesGráficos** para modularización de responsabilidades.
* **Modularización de código** separando la creación de objetos gráficos.
* Optimizacion de recursos para aplicaciones a traves de **servicios**.
* Optimización de código a traces de **servicios**.
* Personalización avanzada a traves de **servicio**.
* Uso de eventos a traves de **ActionListener, MouseListener, FocusListener**.
* Uso de ScrollPane para navegación de interfaz.

## Demostración

<div align='center'>
    <img  src='./CatApp.gif'>
    <p>Demostración CatApp.</p>
</div>