# Proyecto final de Metodos numéricos
Algoritmos para la materia "Métodos numéricos".
(Los algoritmos de las unidades 1 y 3 estan en la carpeta src, mientras el resto estan en la carpeta "unidades 2,4 y 5")


## Unidad 1
Para la primera unidad tomamos en cuenta la situacion de que todos los algoritmos estan basados en  matrices, asi que, para resolverlos, usaremos programacion orientada a objetos.

Para ejecutar los algoritmos, tenemos que crear un arreglo de floats que contenga la matriz. Ejemplo:

```java
float[][] valores= {{2,-3,5},{6,-1,3},{-4,1,-2}};
```
Con este array creamos un objeto matriz:
```java
matriz m=new matriz(valores);
```

Y podemos empezar a iterar en ella.

Igualmente, tenemos funciones estaticas para funciones donde no se pueda realizar con POO; como es el primer ejercicio

### Metodo de GAUSS
Esta funcion recibe dos parametros, siendo la matriz A y la matriz B. Retorna un tipo de dato matriz y ademas esta guardado en una funcion estatica, por lo que se llamaria de esta forma (asumiendo que las matrices A y B ya fueron declaradas)
```java
matriz resultadoGauss = matriz.metodoGauss(A,B);
```
### LU y PLU

Estos algoritmos pueden ser ejecutados con el objeto matriz. la funcion es tipo void, por lo cual 
no se tiene que crear una variable
```java
m.LU();
m.PLU();
```

El objeto matriz tiene internamente submatrices donde se almacenaran los resultados (las matrices P, L Y U). Al ser atributos de la matriz, acceder a ellas se hace de la siguiente forma (en este ejemplo, guardar la matriz L en una nueva variable):
```java
matriz L=m.L;
```

### Inversa de una matriz:

Podemos calcular la inversa de una matriz utilizando la formula A-1 = (Adj(At)) / |A|. Asi que tenemos que crear una funcion para calcular la adjunta y la transpuesta de una matriz, ademas de una funcion para multiplicar una matriz por un escalar.

Teniendo estas funciones armamos el codigo correspondiente, resultando en un metodo de la matriz que no requiere argumentos y devuelve la matriz inversa como resultado (o imprime un mensaje de error en caso de no ser posible realizar la operacion)
```java
matriz resultado=m.inversa();
```

### Determinante

Para calcular el determinante podemos utilizar el metodo de cofactores. En el ejercicio anterior se realizo un metodo para calcular la matriz adjunta, por lo
que podemos usar el codigo para calcular cofactores en este metodo. Resultando en un codigo que no requiere argumentos y devuelve un tipo de dato float
```java
float determinante=m.determinante();
```

### Gauss Seidel

la funcion de gauss seidel es una funcion estatica que nos pide como parametros una matriz A de nxn y una matriz B de 1xn, ademas del numero de iteraciones a realizar.
Devuelve una matriz con los valores de las incognitas como resultado
```java
matriz incognitas=matriz.GaussSeidel(A,B,100);
```

## Unidad 2
En los algoritmos de la unidad 2 basta con ejecutar la funcion main de cada clase para abrir el formulario donde se ingresarán los datos

### metodos de biseccion:
Es un algoritmo de busqueda de raices de trabaja diviendo el intervalo a la mitad y seleccionando el subintervalo que tiene la raiz.
En nuestro programa nos pide ingresar la funcion, el limite inferior, limite superior y tolerancia para que nos muestra la raiz le damos en calcular y listo

### metodo de falsa posicion:
Es un metodo iterativo de resolucion numerica de ecuaciones no lineales, el metodo es una combinacion de metodo de biseccion y el metodo de su secante.
En nuestro programa nos muestra un ejemplo al inicio y despues nos pide ingresar el valor de a, el de b, y nos arroja el resultado.

### newton raphson:
Es un metodo para encontrar aproximacion de los ceros o raices de una funcion real, tambien puede ser usado para encontrar el maximo o minimo de una funcion encontrando los ceros de su primera derivada.
En nuestro programa tenemos una interfaz en donde al usuario le van pidiendo ciertos datos para poder arrojar el resultado


## Unidad 3

Dentro de la clase de cada algoritmo se encuentra el algoritmo en la funcion main, solo basta con ejecutarla para llamar al mismo

### Interpolación Lagrange
La interpolación de Lagrange es un método numérico de aproximación de funciones, el cual hace uso de un polinomio que pasa por ciertos puntos conocidos de la función que se pretende aproximar.
En este código se ingresan puntos del 2-4, estos deben ser enteros, después se ingresan pares de números, primero se introduce x y después  f(x) al final solo de da un valor para interpolar y listo ya esta el resultado de f(x).

### Interpolación de Newton
Es un método de interpolación polinómica. Aunque sólo existe un único polinomio que interpola una serie de puntos, existen diferentes formas de calcularlo.
Se comienza ingresando los puntos de x y f(x) serán 5 puntos por x y 5 puntos por f(x) y al final solo se ingresa un valor para interpolar.

### Ajuste polinomio por mínimos cuadrados.
El método de mínimos cuadrados minimiza la varianza de los estimadores no sesgados de los coeficientes
En este código se comienza ingresando  el numero de puntos, y como una forma diferente de hacerlo primero se agregaron las x  en total 6 y 6 de f(x) por ultimo se ingresa el valor del polinomio  y se obtienen los coeficientes del mismo

## Unidad 4

### Derivadas: 
Es la razon o velocidad de cambio de una funcion en un determinado punto es decir que tan rapido se esta producion una variacion.
en nuestro programa nos pide ingresar la funcion y nos arroja el resultado

### Integrales:
Constituye una amplia gama de algoritmos para calcular el valor numerico de una integral definida y por extension el termino se usa a veces para describir algoritmos numericos para resolver ecuaciones diferenciales
En nuestro programa tenemos una interfaz que nos pide el grado de la funcion, los coeficientes, despues de ingresarlos nos aparecera en un renglon que tenemos abajo le pondres los limites de nuestra integral y tenemos 4 metodos
izquierdo, derecho, trapecio y simpson el usuario elegira dandole click al que decee

## Unidad 5
### Euler:
Es una generalizacion del pequeño teorema de fermat y como tal afirma una proposicion sobre la divisibilidad de los numeros enteros.
en nuestro programa tenemos 3 opciones en la primera podemos ver algun ejemplo que se haya guardado anteriormente, en el segundo punto podemos ingresar los datos y en el 3 es para salir
Si le precinamos la 2 nos pide la funcion, el valor de a, el de b, para y, el numero de interaciones, si queremos usar fracciones o no, y cuantos decimales queremos utilizar maximo 6 y nos arroja todo el procedimiento con el resultado, y le damos enter para regresar al menu principal

### Metodo de Rungekutta:
Son un conjunto de metodos iterativos para la aproximacion de soluciones de ecuaciones diferenciales ordinarias, concretameten del problema de valor inicial los esquemas son explicitos
En nuestro programa, tenemos 3 opciones en la primera podemos ver algun ejemplo que se haya guardado anteriormente, en el segundo punto podemos ingresar los datos y en el 3 es para salir
Si le precinamos la 2 nos pide la funcion,el valor de a,el de b, para y, el numero de interaciones, si queremos usar fracciones o no, y cuantos decimales queremos utilizar maximo 6 y nos arroja todo el procedimiento con el resultado, y le damos enter para regresar al menu principal
