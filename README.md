![apibanner](https://github.com/AlexandrHM/devChallenges-JavaScriptPath/assets/44487342/6c38b8f4-d185-42e8-b809-a32691393a9d)


##  Backend API Rest - Restaurante

#### Descripción
<p>API Rest creada con Spring & PostgreSQL</p>

#### Estado del Proyecto
+ En desarollo 

> [!IMPORTANT]
> Antes de ejecutar tome en cuenta

#### Front-end & Puertos
<p>Es importante tomar en cuenta los puertos de ejecucion de cada proyecto
ya que de lo contrario surgiran problemas de ocupacion de puerto. Se recomienda ejecurtar primero la parte del fron-end, obtener el puerto y verificar que no coincida con el puerto de la API en el archivo "CorsConfig"</p>

 `<pre>`
 
    @Configuration
    public class CorsConfig implements WebMvcConfigurer {

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/api/v1/restaurant/**") // Ruta de la API
                    .allowedOrigins("http://localhost:3000") // <-- Origen permitido
                    .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE"); // Métodos permitidos
        }
    }
    
`<pre>`

#### Base de datos
<p>Asegúrate de haber creado tu base de datos "sin tablas" en tu gestor de preferencia,
para este caso en concreto se hace uso de PostgreSQL.</p>

<p>Para una nocion acerca de la api se presenta la idea sencilla de la tabla y su logica
de las mismas</p>

- Cada cliente puede escribir múltiples reseñas, pero cada reseña pertenece a un solo cliente.
- Cada platillo puede tener múltiples reseñas, pero cada reseña pertenece a un solo platillo
![DB_Restaurante](https://github.com/AlexandrHM/restauranteApi/assets/44487342/7c50bc3b-74f4-4212-a92f-8459567af9e6)

<p>Esquema de las tablas</p>

![image](https://github.com/AlexandrHM/restauranteApi/assets/44487342/d6bcb7e0-ce13-4683-9c67-21938e7fb180)
![image](https://github.com/AlexandrHM/restauranteApi/assets/44487342/f540d7ec-db8c-44a4-82d9-1ebfdcf9887c)
![image](https://github.com/AlexandrHM/restauranteApi/assets/44487342/a6da2e30-53a3-4e53-900d-6817fb2256ca)

`$ CREATE DATABASE restaurante; `

```bash
CREATE TABLE Clientes (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    correo VARCHAR(100) NOT NULL UNIQUE,
    telefono VARCHAR(15),
    direccion VARCHAR(100)
);

CREATE TABLE Platillos (
    id_platillo INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    precio DECIMAL(10, 2) NOT NULL,
    categoria VARCHAR(50),
);

CREATE TABLE Resenas (
    id_resena INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT NOT NULL,
    id_platillo INT NOT NULL,
    calificacion INT NOT NULL CHECK (calificacion BETWEEN 1 AND 5),
    comentario TEXT,
    FOREIGN KEY (id_cliente) REFERENCES Clientes(id),
    FOREIGN KEY (id_platillo) REFERENCES Platillos(id)
);

```
#### Configuración
<p>No te olvides de cambiar los parametros del archivo "aplication.properties" de la ruta
'/src/main/resources/'
</p>

```bash

 #Configuración de conexión a PostgreSQL
 spring.datasource.url=jdbc:postgresql://localhost:5432/restaurante
 spring.datasource.username= user
 spring.datasource.password= password
 spring.datasource.driver-class-name=org.postgresql.Driver

```
<p>Una vez finalizada la configuracion puede ejecutar el archivo "Application.java" </p>

#### Pruebas
<p>Para hacer pruebas con Postman necesitaras llenar la base de datos por lo tanto dejaré a disposición
estas operaciones de inserccion para mayor facilidad</p>

```bash
INSERT INTO Platillos (nombre, descripcion, precio, categoria)
VALUES ('Tacos al Pastor', 'Tacos tradicionales', 150, 'FU');

INSERT INTO Platillos (nombre, descripcion, precio, categoria)
VALUES ('Guacamole', 'Aguacate con totopos', 80, 'AP');

INSERT INTO Platillos (nombre, descripcion, precio, categoria)
VALUES ('Churros', 'Dulce fritura', 50, 'PO');

INSERT INTO Platillos (nombre, descripcion, precio, categoria)
VALUES ('Margarita', 'Cóctel clásico', 100, 'BE');

INSERT INTO Platillos (nombre, descripcion, precio, categoria)
VALUES ('Ensalada César', 'Ensalada con pollo', 120, 'AP');

INSERT INTO Platillos (nombre, descripcion, precio, categoria)
VALUES ('Bistec a la Parrilla', 'Carne de res a la parrilla', 200, 'FU');

INSERT INTO Platillos (nombre, descripcion, precio, categoria)
VALUES ('Flan', 'Postre de caramelo', 70, 'PO');

INSERT INTO Platillos (nombre, descripcion, precio, categoria)
VALUES ('Limonada', 'Bebida refrescante', 50, 'BE');

INSERT INTO Platillos (nombre, descripcion, precio, categoria)
VALUES ('Camarones al Ajillo', 'Mariscos con ajo', 180, 'FU');

INSERT INTO Platillos (nombre, descripcion, precio, categoria)
VALUES ('Nachos', 'Totopos con queso', 90, 'AP');

INSERT INTO Platillos (nombre, descripcion, precio, categoria)
VALUES ('Brownie', 'Pastel de chocolate', 60, 'PO');

INSERT INTO Platillos (nombre, descripcion, precio, categoria)
VALUES ('Mojito', 'Cóctel de menta', 120, 'BE');

```

> [!NOTE]
> Apartado del Front-End (Página Web)

<p>Para este proyecto es necesario que se ejecute la interfaz el cual 
se encuentra en el siguiente repositorio</p>

[Repositorio-FrontEnd](https://github.com/AlexandrHM/restaurantReactJS "Repositorio-FrontEnd")

#### Licencia (MIT License)
