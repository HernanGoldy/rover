## Rover en Marte

Proyecto creado para el examen final del bootcamp de ATL Academy.

### Pasos en la creación del proyecto:

#### ✔ 1ra Etapa - Creación y desarrollo del proyecto
1. Se crea la _«estructura de carpetas»_ del proyecto.
    * models
    * controllers
    * services
    * dto
    * repository
2. Se crea los modelos y se le asigna sus propiedades

| Rover (@Data)            |Orientacion (enum)|Obstaculo (@Data)| MapaDeMarte                 |
|--------------------------|------------------|-----------------|-----------------------------|
| Long id;                 |NORTE,            |Long id;         | Rover rover;                |
| Integer x;               |ESTE,             |Integer x;       | List<Obstaculo> obstaculos; |
| Integer y;               |SUR,              |Integer y;       |                             |
| Orientacion orientacion; |OESTE;            |                 |                             |

3. Se crean los DTo (para endpoints robustos)

| RoverDto                 | ObstaculoDto | ComandosDto            |
|--------------------------|--------------|------------------------|
| Integer x;               | Integer x;   | List<String> comandos; |
| Integer y;               | Integer y;   | Integer x;             |
| Orientacion orientacion; |              | Integer y;             |
4. Se crean los endpoints (controllers)
    * RoverController (@RestController)
        * @PostMapping("api/rover/")
            * crear
        * @GetMapping("api/rover/")
            * Rover obtener
        * @PostMapping("api/rover/command/")
            * enviarComandos
    * ObstaculoController (@RestController)
        * @PostMapping("api/obstacle/")
            * crear
        * @GetMapping("api/obstacle/")
            * List<Obstaculo> mostrarObstaculos
5. En los modelos, se crean las tablas para la base de datos
   >**NOTA:** En el archivo _pom.xml_ se carga la dependencia de _spring-boot-starter-data-jpa_ y se configura la 
   base de datos en el archivo _application.properties_.

| **Rover** (@Entity)(@Table(name = "rover"))         | **Obstaculo** (@Entity)(@Table(name = "obstaculo")) |
|-----------------------------------------------------|-----------------------------------------------------|
| @Id                                                 | @Id                                                 |
| @GeneratedValue(strategy = GenerationType.IDENTITY) | @GeneratedValue(strategy = GenerationType.IDENTITY) |
| @Column(name = "id")                                | @Column(name = "id")                                |
| @Column(name = "posx")                              | @Column(name = "posx")                              |
| @Column(name = "posy")                              | @Column(name = "posy")                              |
| @Enumerated(EnumType.STRING)                        |                                                     |
| @Column(name = "orientation")                       |                                                     |
6. Se conecta con la base de datos
   >**NOTA:** _JpaRepository_ nos va a hacer automáticamente las altas, las bajas, las modificiones y las
      búsquedas, entre tantas otras funcionalidades.

    * interface RoverRepository extends JpaRepository<>
    * interface ObstaculoRepository extends JpaRepository<>
7. Se crean los servicios para conectar la base de datos

| **interface RoverService** | **RoverServiceImp implements RoverService** |
|----------------------------|---------------------------------------------|
| Rover obtener()            | @Service                                    |
|                            | @Override                                   |

| **interface ObstaculoService**    | **ObstaculoServiceImp implements ObstaculoService** |
|-----------------------------------|-----------------------------------------------------|
| List<Obstaculo> mostrarObstaculos | @Service                                            |
|                                   | @Override                                           |
8. Desde el controller, llamamos al servicio
    * RoverController
        * @Autowired
        * RoverService service
    * ObstaculoController
        * @Autowired
        * ObstaculoService service

#### ✔ 2da Etapa - Testing
1. Se crea la _«estructura de carpetas»_ para los test.
    * controllers
    * services
2. Se agrega (en el archivo _«pom.xml»_) las dependencias de _junit_.
3. Se crea los test unitarios
    * RoverControllerTest (@SpringBootTest)
        * alEnviarComando_llamarAlServicio (@Test)(@DisplayName)
        * alEnviarComandos_FRF_llamarAlServicio (@Test)(@DisplayName)
    * RoverServiceImpTest (@SpringBootTest)
        * alEnviarComando_llamarAlServicio (@Test)(@DisplayName)
