# TestTecnico
 Git Creado para entrega de Git tecnico


# Para Iniciar el proyecto.
Paso 1
Abrir Spring-tool / eclipse
ir a File Import, dirigirse a la opción Gradle y pinchar en Existing Gradle Project.

Buscar la ruta donde se clonó el repositorio e importar éste.

Paso 2
Clickear con el botón derecho sobre el proyecto recien importado,
dirigirse a la opcion run As y seleccionar SpringBootApp.

Esperar unos segundos hasta que se compile y suba el proyecto en local.
No se necesario generar ningun tipo de script ya que el servidor de base de datos se genera al encender el proyecto.


#Probar el proyecto a travez de PostMan
Abrir Postman y importar el siguiente Curl

------------------------------------------------------------------------------------

curl --location --request POST 'localhost:8080/ejercicioback' \
--header 'Content-Type: application/json' \
--data-raw '{
  "name": "Juan Rodriguez",
  "email": "juan@rodrigue2z.org",
  "password": "Hunter22",
  "phones": [
    {
      "number": "1234567",
      "citycode": "1",
      "contrycode": "57"
    },
    {
      "number": "1234567",
      "citycode": "1",
      "contrycode": "57"
    }
  ]
}'

-----------------------------------------------------------------------------------------

Una vez importado el Curl y el proyecto esté funcionando, hacer click a enviar y los datos se guardarán en la base de datos.
!!!!DATO IMPORTANTE!!!
La BD se reiniciará y borrará todos los datos cuando el proyecto se reinicie o apague.


#Revision de la DB

Dirigirse a el siguiente link : http://localhost:8080/h2-console
Credenciales 
JDBC URL: jdbc:h2:mem:testdb
User Name : sa
Password : Password

Luego de verificar dichas credenciales clickear en connect en donde se verán las tablas USUARIO Y PHONES

Dejo Query SQL para verificar las inserciones 

SELECT * FROM PHONES;


SELECT * FROM USUARIO;


##Explicación de funcionamiento de API REST  ##
La aplicacion al ponerla en ejecucion realiza primeramente un Select a travez del correo verificando que el usuario ya no exista en los registros de la base de datos, luego 
si el correo no existe se realiza la validacion de que la contraseña y el correo cumplan los caracteres solicitados en el documento. si estos no cumplen enviarán un mensaje
indicando que estos estan erroneos o no corresponden a los solicitados. si éstos ultimos son validos, se realizará el insert a la base de datos de Usuario y PHONES correspondiente a cada una. luego de realizado el insert se realizará una busqueda para rescatár los datos de la respuesta solicitada.

Todo este flujo lo realiza de manera automatica.








