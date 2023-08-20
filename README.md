# Backend para obtener el stock de productos de una API
El proyecto se desarrolla en java con Springboot y Maven. Se consume una API con autenticación básica. 
### Se obtiene y se muestra mediante archivos html:
- Cantidad total de registros.
- Cantidad total de productos diferentes en el stock (agrupados por la propiedad "product").
- Lista de productos cuya unidad de medida (uOM$_identifier) es diferente a "UNIDAD" (se diferencia entre mayúsculas y minúsculas).
- Lista de los 10 productos con mayor stock ordenados de mayor a menor.

### Instrucciones de funcionamiento:
- Luego de correr el proyecto en local, se debe utilizar  http://localhost:8080/ para acceder al login.
- Ingresar las credenciales. Username: Openbravo   Password: 1234
- Y se mostrarán los items.

#### Adicional se realizó una RESTAPI
La cual permite obtener los en formato json: 
- Una lista de todos los registros: http://localhost:8080/v1/todo
- Cantidad total de registros y la antidad total de productos diferentes en el stock: http://localhost:8080/v1/cantidad-productos
- Lista de productos cuya unidad de medida es diferente a "UNIDAD": http://localhost:8080/v1/diferente-UNIDAD
- Lista de los 10 productos con mayor stock ordenados de mayor a menor: http://localhost:8080/v1/mayor-stock
El Username y el Password están quemados en el Controlador de la restapi, por lo que no es necesario ingresar estos datos para consumir la api.


