## Rover en Marte

---

Proyecto creado para el examen final del bootcamp de ATL Academy.

### Pasos para la creación del proyecto:

#### ✔ 1ra Etapa - Creación y desarrollo del proyecto
1. Crear la _«estructura de carpetas»_ del proyecto.
    * models
    * controllers
    * services
    * dto
    * repository
2. Crear los modelos y asignarle sus propiedades
    * Rover (@Data)
        * Long id;
        * Integer x;
        * Integer y;
        * Orientacion orientacion;
    * Orientacion (enum)
        * NORTE,
        * ESTE,
        * SUR,
        * OESTE;
    * Obstaculo (@Data)
        * Long id;
        * Integer x;
        * Integer y;
    * MapaDeMarte
        * Rover rover;
        * List<Obstaculo> obstaculos;
3. Crear los DTo (para endpoints robustos)
    * RoverDto
        * Integer x;
        * Integer y;
        * Orientacion orientacion;
    * ObstaculoDto
        * Integer x;
        * Integer y;
    * ComandosDto
        * List<String> comandos;
4. Crear los endpoints (controllers)
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
5. En los modelos, crear las tablas para la base de datos
    * **NOTA:** En el archivo _pom.xml_ cargar la dependencia de _spring-boot-starter-data-jpa_ y configurar la base de
      datos en el archivo _application.properties_.
    * Rover
        * @Entity
        * @Table(name = "rover")
            * @Id
            * @GeneratedValue(strategy = GenerationType.IDENTITY)
            * @Column(name = "id")
            * @Column(name = "posx")
            * @Column(name = "posy")
            * @Enumerated(EnumType.STRING)
            * @Column(name = "orientation")
    * Obstaculo
        * @Entity
        * @Table(name = "obstaculo")
            * @Id
            * @GeneratedValue(strategy = GenerationType.IDENTITY)
            * @Column(name = "id")
            * @Column(name = "posx")
            * @Column(name = "posy")
6. Conectar con la base de datos
    * **NOTA:** _JpaRepository_ nos va a hacer automáticamente las altas, las bajas, las modificiones y las
      búsquedas, entre tantas otras funcionalidades.
    * interface RoverRepository extends JpaRepository<>
    * interface ObstaculoRepository extends JpaRepository<>
7. Crear los servicios para conectar la base de datos
    * interface RoverService
        * Rover obtener()
    * RoverServiceImp implements RoverService
        * @Service
            * @Override
    * interface ObstaculoService
        * List<Obstaculo> mostrarObstaculos
    * ObstaculoServiceImp implements ObstaculoService
        * @Service
            * @Override
8. Desde el controller, llamamos al servicio
    * RoverController
        * @Autowired
        * RoverService service
    * ObstaculoController
        * @Autowired
        * ObstaculoService service

#### ✔ 2da Etapa - Testing
1. Crear la _«estructura de carpetas»_ para los test.
    * controllers
2. Agregar (en el archivo _«pom.xml»_) las dependencias de _junit_ y _junit-jupiter_ para utilizar **Mockito**.
3. Crear los test unitarios y configurar Moquito
    * RoverControllerTest (@RunWith(MockitoJUnitRunner.class))
        * alEnviarComando_llamarAlServicio (@Test)
