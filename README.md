# Gestión de Blogs con Java Spring Boot

Este proyecto es una aplicación de gestión de blogs desarrollada en Java utilizando Spring Boot y una base de datos en memoria H2. A continuación, se describen las estrategias, tecnologías y frameworks utilizados en la implementación de la solución.

## Estrategia de Implementación

La aplicación está diseñada para permitir la creación y gestión de blogs, así como la interacción con comentarios asociados a cada blog. La solución se estructura en base a los siguientes componentes principales:

1. **Modelos**: Representan las entidades del dominio de la aplicación, incluyendo `Autor`, `Blog` y `Comentario`. Estos modelos son gestionados mediante JPA (Java Persistence API) para la persistencia en la base de datos.

2. **Repositorios**: Utilizan Spring Data JPA para manejar las operaciones CRUD (crear, leer, actualizar y eliminar) sobre las entidades del dominio. Los repositorios simplifican la interacción con la base de datos mediante el uso de métodos de consulta predefinidos y personalizados.

3. **Servicios**: Encapsulan la lógica de negocio de la aplicación. Los servicios gestionan la creación, actualización y consulta de blogs y comentarios, y proporcionan funcionalidades adicionales como el cálculo de estadísticas de puntuación para los blogs.

4. **Controladores**: Exponen las funcionalidades de la aplicación a través de APIs REST. Los controladores manejan las solicitudes HTTP y responden con datos en formato JSON. Cada controlador corresponde a un recurso específico (Autores, Blogs y Comentarios) y define las rutas y métodos HTTP necesarios para interactuar con el servicio correspondiente.

5. **Manejo de Errores**: Utiliza `@ControllerAdvice` para proporcionar un manejo centralizado de excepciones y errores, garantizando respuestas consistentes y apropiadas para diferentes tipos de errores.

## Tecnologías y Frameworks Utilizados

### Spring Boot

**Spring Boot** es un framework basado en Spring que simplifica la configuración y el desarrollo de aplicaciones Java. Proporciona una configuración automática y una serie de dependencias preconfiguradas, lo que acelera el proceso de desarrollo. En este proyecto, Spring Boot se utiliza para crear la estructura de la aplicación y manejar las operaciones de backend.

### Spring Data JPA

**Spring Data JPA** es una extensión de Spring que facilita la interacción con bases de datos a través de la implementación de JPA. Proporciona una capa de abstracción sobre JPA, simplificando la implementación de repositorios y la realización de consultas. En este proyecto, se utiliza para definir repositorios que interactúan con las entidades `Autor`, `Blog` y `Comentario`.

### H2 Database

**H2** es una base de datos en memoria que se utiliza para la persistencia de datos en este proyecto. Es ideal para pruebas y desarrollo debido a su naturaleza ligera y fácil configuración. Se configura en el archivo `application.properties` para proporcionar una base de datos en memoria que no requiere instalación adicional.

### Lombok (Opcional)

**Lombok** es una biblioteca que reduce la cantidad de código boilerplate en Java mediante la generación automática de métodos como getters, setters y constructores. Aunque opcional, se utiliza para simplificar el código en los modelos.

## Resumen de Funcionalidades

- **Creación y Gestión de Autores**: Permite crear y listar autores con información personal detallada.
- **Creación y Gestión de Blogs**: Permite crear, actualizar y consultar blogs con información sobre el título, tema, contenido, periodicidad y configuración de comentarios.
- **Registro de Comentarios**: Permite agregar comentarios a blogs que permiten comentarios, incluyendo la puntuación del blog.
- **Consulta de Blogs**: Permite consultar blogs por ID, mostrando detalles del autor, del blog y un resumen de puntuaciones (mínimo, máximo y promedio) de los comentarios asociados.

Para más información sobre la configuración y uso del proyecto, consulta la documentación en el repositorio o los comentarios en el código fuente.

---

Este `README.md` proporciona una visión general de la aplicación, su estructura y las tecnologías utilizadas para su desarrollo. Asegúrate de ajustar y completar la documentación según las necesidades específicas del proyecto.
