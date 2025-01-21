# Challenge_ONE_ForoHub
Challenge ForoHub, realizado para el programa ONE de Oracle y AluraLATAM.

- Estado del proyecto: Finalizado con opción de actualización.
  # Se desarrolló una aplicación API REST en el Framework Spring Boot 3, para un foro, con la cual a través del modelo "CRUD" se pueden realizar registros, consultas, actualización y eliminación de Tópicos en el foro "ForoHub".
  - En total, la aplicación está compuesta por los siguientes paquetes con las siguientes entidades:

    - controller.
      - AutenticacionController.java.
      - TopicoController.java.
    - domain.
      - curso.
        - Categoria.java.
        - Curso.java.
        - DatosCurso.java.
      - topico.
        - DatosActualizarTopico.java.
        - DatosListadoTopico.java.
        - DatosRegistroTopico.java.
        - DatosRespuestaTopico.java.
        - Status.java.
        - Topico.java.
        - TopicoRepository.java.
      - usuarios.
        - DatosAutenticacionUsuario.java.
        - Usuario.java.
        - UsuarioRepository.java.
      - ValidacionException.java.
    - infra.
      - errores.
        - TratadorDeErrores.java.
      - security.
        - AutenticacionService.java.
        - DatosJWTToken.java.
        - SecurityConfigurations.java.
        - SecurityFilter.java.
        - TokenService.java.
      - springdoc.
        - SpringDocConfiguration.java.
      - ForohubApplication.java.
    - resources.
      - db.
        - migration
          - V1__create-table-usuarios.sql.
          - V2__create-table-topicos.sql.
          - V3__alter-table-topicos-add-activo.sql.
      - application.properties.


  ## Funcionalidades del proyecto.

- Package controller.
  - Clase AutenticacionController:
    - `Funcionalidad 1`: Gestionar la parte de autenticación.
    - `Funcionalidad 2`: Se inyecta el AuthenticationManager.
    - `Funcionalidad 3`: Se inyecta la entidad TokenService.
    - `Funcionalidad 4`: A través del método autenticarUsuario se autentican los datos entregados por el paquete de security.
  - Clase TopicoController:
    - `Funcionalidad 1`: Gestionar todas las requisiciones realizadas.
    - `Funcionalidad 2`: Se inyecta la entidad TopicoRepository.
    - `Funcionalidad 3`: Se crea el método registrarTopico para realizar el registro de un nuevo tópico.
    - `Funcionalidad 4`: Se crea el método listadoTopicos para realizar el listado del total de los tópicos.
    - `Funcionalidad 5`: Se crea el método actualizarTopico para realizar un update en un método específico.
    - `Funcionalidad 6`: Se crea el método eliminarTopico para eliminar un tópico seleccionado.
    - `Funcionalidad 7`: Se crea el método retornarDatosTopico para realizar el mapeo de la información de cada requisición.
- Package domain.
  - Package curso.
    - Enum Categoria:
      - `Funcionalidad 1`: Se guardan los datos sobre el tipo de categoría de cada curso.
    - Clase Curso:
      - `Funcionalidad 1`: Se crean los atributos nombreCurso y categoriaCurso.
      - `Funcionalidad 2`: Se crean los métodos Curso y actualizarDatos para retornar la información hacia otras entidades.
    - Clase DatosCurso:
      - `Funcionalidad 1`: Se crea el DTO de curso con los parámetros de nombreCurso y categoriaCurso. 
  - Package topico.
    - Record DatosActualizarTopico:
      - `Funcionalidad 1`: Se crea el DTO con los parámetros id, título y mensaje para realizar el mapeo de los datos que se editarían al realizar la requisición update.
    - Record DatosListadoTopico:
      - `Funcionalidad 1`: Se crea el DTO con los parámetros id, título, mensaje, fechaDeCreacion, autor, nombreCurso y categoriaCurso, para realizar el retorno de los datos de cada tópico secuencialmente.
    - Record DatosRegistroTopico:
      -  `Funcionalidad 1`: Se crea el DTO con los parámetros de título, mensaje, fechaDeCreacion, status, autor y curso, para realizar el registro de un nuevo tópico.
    - Record DatosRespuestaTopico:
      -  `Funcionalidad 1`: Se crea el DTO con los parámetros de id, título, mensaje, fechaDeCreacion, autor y curso, para realizar el mapeo de los datos y poderlos enviar devuelta a las demás requisiciones.
    - Enum Status:
      -  `Funcionalidad 1`: Se guardan los datos sobre el tipo de estatus de cada requisición realizada.
    - Clase Topico:
      -  `Funcionalidad 1`: Se ingresan como parámetros id, título, mensaje, fechaDeCreacion, status, autor, activo y curso.
      -  `Funcionalidad 2`: Se crea el método actualizarDatos para realizar la consulta y el envío de los datos informados.
      -  `Funcionalidad 3`: Se crea el método desactivarToico para realizar el delete lógico en la base de datos del tópico seleccionado.
    - Interface TopicoRepository:
      -  `Funcionalidad 1`: Se crea el Repository con extensión a JPA.
      -  `Funcionalidad 2`: Se crea el método findByActivoTrue para realizar la consulta en el repositorio y desactivar el tópico de la base de datos.
  - Package usuarios.
    - Record DatosAutenticacionUsuario:
      - `Funcionalidad 1`: Se crea el DTO de Usuario con los parámetros login y clave.
    - Clase Usuario:
      - `Funcionalidad 1`: Se crean los atributos id, login, clave.
      - `Funcionalidad 2`: Se sobreescriben los métodos correspondientes para la autenticación.
    - Interface UsuarioRepository:
      - `Funcionalidad 1`: Se crea el Repository con extensión a JPA.
      - `Funcionalidad 2`: Se crea el método findByLogin para buscar el usuario en la base de datos.
  - Clase ValidacionException:
    - `Funcionalidad 1`: Se crea la clase con extensión a RuntimeException.
    - `Funcionalidad 2`: Se crea el método ValidacionException para recibir el mensaje indicando el tipo de excepción.
- Package infra.
  - Package errores.
    - Clase TratadorDeErrores:
      - `Funcionalidad 1`: Se crean los métodos para tratar los errores con ExceptionHandler.
      - `Funcionalidad 2`: Se crea un record DatosErrorValidacion, para validar el mensaje, a su vez se crea el método DatosErrorValidacion para enviar el mensaje de error por defecto. 
  - Package security.
    - Clase AutenticacionService:
      - `Funcionalidad 1`: Se crea la clase AutenticacionService implementando UserDetailsService.
      - `Funcionalidad 2`: Se inyecta el repositorio UsuarioRepository.
      - `Funcionalidad 3`: Se crea el método loadUserByUsername para buscar el registro en la base de datos.
    - Record DatosJWTToken:
      - `Funcionalidad 1`: Se crea el DTO DatosJWTToken con jwTtoken como parámetro.
    - Clase SecurityConfigurations:
      - `Funcionalidad 1`: Se inyecta el filtro a través de SecurityFilter.
      - `Funcionalidad 2`: Se crea el filtro securityFilterChain para gestión del acceso de usuario.
      - `Funcionalidad 3`: Se crea el authenticationManager.
      - `Funcionalidad 4`: Se crea el passwordEncoder para la gestión del algoritmo BCrypt.
    - Clase SecurityFilter:
      - `Funcionalidad 1`: Se crea la clase con extensión a OncePerRequestFilter.
      - `Funcionalidad 2`: Se inyecta el TokenService.
      - `Funcionalidad 3`: Se inyecta el UsuarioRepository.
      - `Funcionalidad 4`: Se crea el filtro doFilterInternal, para realizar la autorización del usuario usando Bearer.
    - Clase TokenService:
      - `Funcionalidad 1`: Se crea el servicio TokenService para validar los datos de usuario.
      - `Funcionalidad 2`: Se inyecta la llave para realizar la comprobación.
      - `Funcionalidad 3`: Se crea el método generarToken, para verificar la llave con JWT.
      - `Funcionalidad 4`: Se crea el método getSubject, para validar la firma.
      - `Funcionalidad 5`: Se crea el método generarFechaExpiracion, para determinar la fecha de expiración del token generado.
  - Package springdoc.
    - Clase SpringDocConfiguration:
      - `Funcionalidad 1`: Se crea el método customOpenAPI, para gestionar el bearer-key a través de JWT de OpenAPI.
  - Clase ForohubApplication:
    - `Funcionalidad 1`: Se crea la clase ForohubApplication para la ejecución de la aplicación.
    - `Funcionalidad 2`: Se crea el método main de la clase ForohubApplication.
- Package resources.
  - Package db.
    - Package migration
      - V1__create-table-usuarios
        - `Funcionalidad 1`: Se crea la primera migration para crear la tabla usuarios.
      - V2__create-table-topicos
        - `Funcionalidad 1`: Se crea la segunda migration para crear la tabla topicos.
      - V3__alter-table-topicos-add-activo
        - `Funcionalidad 1`: Se crea la tercera migration para modificar la tabla topicos, y agregar la columna activo.
  - application.properties:
    - `Funcionalidad 1`: Se realiza la conexión con la base de datos.
    - `Funcionalidad 2`: Se adicionan las propiedades de hibernate para SQL.
    - `Funcionalidad 3`: Se agrega el stacktrace.
    - `Funcionalidad 4`: Se agrega la llave para JWT, a través de api.security.secret.
- Capturas del proyecto.
  -  ![1](https://github.com/user-attachments/assets/f496af91-9ce4-4a52-9130-9e1d4a7dad91)
  -  ![2](https://github.com/user-attachments/assets/423007ec-fc5b-4559-a594-931af7f331bc)
  -  ![3](https://github.com/user-attachments/assets/6b030463-40d2-40f0-a23b-685fb4d358ba)
  -  ![4](https://github.com/user-attachments/assets/311f8188-752c-41b7-b802-ffb0eb6cedcb)
  -  ![5](https://github.com/user-attachments/assets/08a627c2-dcf9-4f4d-a232-ed0a5531b00f)
  -  ![6](https://github.com/user-attachments/assets/0a148cb0-94cc-4466-830a-93b975b7bf37)
  -  ![7](https://github.com/user-attachments/assets/3b72305d-9205-46b7-94ea-a4e66761abc0)
  -  ![8](https://github.com/user-attachments/assets/a256e902-47c0-4d9d-a6f2-bb274a072b59)
  -  ![9](https://github.com/user-attachments/assets/2ab0ae61-f3eb-429b-b15b-7b8dab19ea42)
  -  ![10](https://github.com/user-attachments/assets/13eab668-1a68-47cd-a66d-f9789b81e525)
  -  ![11](https://github.com/user-attachments/assets/7a92635a-0c35-4449-93a6-faee48954830)
  -  ![12](https://github.com/user-attachments/assets/b6ebcc11-77e8-400c-815b-48fbe0a9de83)
  -  ![13](https://github.com/user-attachments/assets/43d18099-c148-46a8-8818-57caba20b553)
  -  ![14](https://github.com/user-attachments/assets/df981061-60d5-49fc-947c-4b4e76a943f1)
  -  ![15](https://github.com/user-attachments/assets/a4784cbd-eb55-4bf6-b0a9-5560c6b6ea02)
- Ejecución del proyecto:


