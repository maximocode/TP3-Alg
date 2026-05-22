# TRABAJO PRÁCTICO N°3

## Implementación de Tablas Hash
<p>
Partiendo desde el codigo del TP. N°2 se hicieron mejoras para poder soportar una mayor cantidad de estudiantes, al momento de meterlos en el sistema y luego buscarlos.
Estos se logro gracias a:
</p>

- Función de Dispersión.
- Almacenamiento en un arraylist.
- Exploració Cuadrática.

## ¿Qué se buscaba?
Crear y hacer uso de una nueva estructura "**IndiceEstudiantes**" que nos permitiera:

- Insertar estudiantes por su legajo.
- Buscar estudiantes por su legajo.
- Resolver colisiones con exploración cuadrática.
- Respetar un factor de carga máximo.

## Reflexión
> respuestas de las preguntas dadas

##### ¿Dónde hubo más colisiones?
Las colisiones se dierón cuando la función hash generó la misma posición para distintos legajos. En nuestra implementación la función hash suma los valores ASCII de cada carácter del legajo y aplica el módulo del tamaño de la tabla.
Los legajos con caracteres similares o que sumen lo mismo generan más colisiones. Por ejemplo legajos como "AB12" y "ZX90" pueden dar la misma suma ASCII y por lo tanto la misma posición.
También cuando la tabla empieza a llenarse y se acerca al factor de carga máximo de 0.7, las colisiones aumentan porque hay menos posiciones libres disponibles.

##### ¿Qué tan eficiente fue la exploración cuadrática?
La exploración cuadrática resultó más eficiente que la exploración lineal porque distribuye mejor los elementos en la tabla. La exploración lineal genera agrupamientos, por ende hay zonas de la tabla muy llenas mientras otras quedan vacías.
La exploración cuadrática los evita porque los saltos crecen en tamaño distribuyendo los elementos más uniformemente.
Sin embargo tiene una limitación: si el factor de carga supera el 0.7 la exploración cuadrática no nos garantiza encontrar una posición libre aunque existan posiciones disponibles en la tabla. Por eso implementamos el control del factor de carga antes de cada inserción.
##### ¿Qué pasaría si el tamaño no fuera primo?
Como vimos en teoria el tamaño de la tabla tiene que ser un número primo para evitar generar colisiones.
Esto ocurre porque los números no primos tienen más divisores, y cuando la suma ASCII de un legajo es múltiplo de alguno de esos divisores, el resultado del módulo siempre cae en las mismas posiciones.
