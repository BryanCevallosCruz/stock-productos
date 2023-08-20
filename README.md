# Backend para obtener el stock de productos de una API
El proyecto se desarrolla en java con Springboot y Maven. Se consume una API con autenticación básica. 
### Se obtiene y se muestra mediante archivos html:
- Cantidad total de registros.
- Cantidad total de productos diferentes en el stock (agrupados por la propiedad "product").
- Lista de productos cuya unidad de medida (uOM$_identifier) es diferente a "UNIDAD" (se diferencia entre mayúsculas y minúsculas).
- Lista de los 10 productos con mayor stock ordenados de mayor a menor.

#### Adicional se realiza una RESTAPI para los puntos anterior
