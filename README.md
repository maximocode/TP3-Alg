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
# Tabla Hash - Índice de Estudiantes

## Función de dispersión

```
hash(legajo) = sumaASCII(legajo) % 17
```

Cada carácter del legajo se convierte a su valor ASCII, se suman todos y se aplica módulo 17.

---

## Proceso de inserción

| Legajo | Estudiante | Suma ASCII | Hash inicial | Pos. final | ¿Colisión? |
|---|---|---|---|---|---|
| S001 | Nuñez Lihue | 228 | 7 | 7 | No |
| A023 | Gonzalez Santiago | 214 | 10 | 10 | No |
| B045 | Rodriguez Maria | 219 | 15 | 15 | No |
| C012 | Lopez Juan | 214 | 10 | 11 | Sí → +1² = pos 11 |
| D078 | Garcia Ana | 227 | 6 | 6 | No |
| E034 | Martinez Carlos | 220 | 16 | 16 | No |
| F056 | Fernandez Laura | 225 | 4 | 4 | No |
| G089 | Perez Diego | 232 | 11 | 12 | Sí → +1² = pos 12 |
| H011 | Sanchez Valentina | 218 | 14 | 14 | No |
| I067 | Torres Facundo | 230 | 9 | 9 | No |
| J090 | Romero Camila | 227 | 6 | 5 | Sí → +1² ocupado → +2² = pos 5 |

---

## Estado final de la tabla

| Índice | Legajo | Estudiante |
|---|---|---|
| 0 | null | — |
| 1 | null | — |
| 2 | null | — |
| 3 | null | — |
| 4 | F056 | Fernandez Laura |
| 5 | J090 | Romero Camila |
| 6 | D078 | Garcia Ana |
| 7 | S001 | Nuñez Lihue |
| 8 | null | — |
| 9 | I067 | Torres Facundo |
| 10 | A023 | Gonzalez Santiago |
| 11 | C012 | Lopez Juan |
| 12 | G089 | Perez Diego |
| 13 | null | — |
| 14 | H011 | Sanchez Valentina |
| 15 | B045 | Rodriguez Maria |
| 16 | E034 | Martinez Carlos |

---

## Detalle de colisiones

### Colisión 1 — C012 Lopez Juan
- Hash inicial: `214 % 17 = 10` → ocupada por A023
- Intento i=1: `(10 + 1²) % 17 = 11` → libre ✓

### Colisión 2 — G089 Perez Diego
- Hash inicial: `232 % 17 = 11` → ocupada por C012
- Intento i=1: `(11 + 1²) % 17 = 12` → libre ✓

### Colisión 3 — J090 Romero Camila
- Hash inicial: `227 % 17 = 6` → ocupada por D078
- Intento i=1: `(6 + 1²) % 17 = 7` → ocupada por S001
- Intento i=2: `(6 + 2²) % 17 = 10` → ocupada por A023
- Intento i=3: `(6 + 3²) % 17 = 15` → ocupada por B045
- Intento i=4: `(6 + 4²) % 17 = 5` → libre ✓
