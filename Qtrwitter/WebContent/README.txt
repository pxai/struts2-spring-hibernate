Aplicación Qtrwitter
--------------------

Está aplicación tiene alguna mejora respecto al cutreforo.

+ La conexión con el origen de datos se hace con una clase
creada a tal efecto.
+ El string de origen de datos, lo sacamos de un parámetro 
 en el fichero xml de configuración de la aplicación.
+ El slogan también está metido en ese fichero de config.
+ En las páginas privadas antes de entrar se controla si la sesión
está iniciada o no.
+ Se valida alguna cosilla en los formularios, al menos se mira si están vacíos.
+ Se cambia el exceso de scriptlet en los jsp por etiquetas jstl.

Aunque todavía hay cosas que mejorar
------------------------------------
-La forma de pasar el String de origen de datos es un rollo.
Es algo lo suficientemente genérico como para dejarlo fijo.

-Los servlets no debieran hacer validación sino usar los Filters
y meter validación con expresiones regulares.

-Ni tanto ni tan calvo: mostrar datos en jsp usando bucles jstl.
