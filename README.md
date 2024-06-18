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
![DB_Restaurante](https://github.com/AlexandrHM/apiRestaurant/assets/44487342/062aebeb-12fc-4fa4-a8c5-88ec4e41017b)

<p>Esquema de las tablas</p>

![image](https://github.com/AlexandrHM/apiRestaurant/assets/44487342/9d0df62f-d382-4687-ab38-5499ac51e43a)

![image](https://github.com/AlexandrHM/apiRestaurant/assets/44487342/23536b3f-25c3-40c1-9982-f87283266183)

![image](https://github.com/AlexandrHM/apiRestaurant/assets/44487342/277b6364-4b08-46d5-874b-36f0c012bb46)


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

> [!NOTE]
> Apartado del Front-End (Página Web)

<p>Para este proyecto es necesario que se ejecute la interfaz el cual 
se encuentra en el siguiente repositorio</p>

[Repositorio-FrontEnd](https://github.com/AlexandrHM/restaurantReactJS "Repositorio-FrontEnd")

#### Licencia (MIT License)