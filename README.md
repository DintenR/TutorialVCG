#Tutorial-VCG

En este repositorio se encuentra todo el material necesario para seguir el tutorial de la herramienta **Visual Code Grepper** (VCG).
El tutorial consta de 3 partes: Instalación, Analasis del código y configuralción de perfiles. En cada una de ellas aparecen los pasos a seguir para conseguir completar cada apartado.

[TOC]

##Instalación
En este apartado vamos a instalar el software de analisis de codigo estático VCG. Para ello hay que seguir los pasos que se indican a continuacion:
1. Accedemos a la [página de descarga](https://sourceforge.net/projects/visualcodegrepp/ "VCG").
2. Pulsamos el boton **Download**.
3. Ejecutamos el instalador.
4. Seguimos los pasos que nos aparecen dejando la configuración** por defecto**.

Tras seguir estos pasos deberiamos haber instalado el programa y el icono debería aparecer en el escritorio.

##Analisis de código

En este apartado vamos a realizar el analisis del código de una aplicación Java/Android, aunque el programa también admite otros lenguajes de programación como: C++, C#, VB, PHP o PL/SQL.
VCG permite realizar el análisis del código de dos formas diferentes: a través de su interfaz gráfica o por comandos. En primer lugar haremos uso de la interfaz gráfica, ya que me parece la forma más comoda de utilizar el programa.

###Interfaz gráfica

Para utilizar la interfaz gráfica debemos iniciar la aplicación usando el acceso directo que se nos ha creado en el escritorio tras la instalación. Trás hacer esto, aparecerá un dialogo recordandonos que debemos escoger el lenguaje que vamos a analizar. Después, debería abrirse la ventana principal(*Imagen 1: VGC*).
![Imagen 1: VCG](res/VentanaVCG "Imagen 1: VCG")
Para analizar el código seguiremos los siguientes pasos:
1. Escoger Java como lenguaje a analizar .
Para ello debemos seleccionar en *Setings->Java*.
2. Buscar la carpeta que contenga el código fuente.
Se puede analizar cualquier código Java, pero para el tutorial utilizaré el código que dejo disponible en el repositorio.
Para buscar seleccionamos *File->New Target Directory*  o pulsamos **``Ctrl+N``**.
Saldrá una ventana. Seleccionamos la carpeta que contenga el codigo fuente(*Imagen 2: Seleccion de carpeta*).
![Imagen 2: Selección de carpeta](res/SeleccionarCarpeta "Imagen 2: Selección de carpeta")
3. Analizar el código.
Una vez seleccionada la carpeta aparacerán los ficheros Java encontrados(*Imagen 3: Ficheros encontrados*).
![Imagen 3: Ficheros encontrados](res/FicherosEncontrados "Imagen 3: Ficheros encontrados")
Para analizar el código hay 3 opciones: Solo código, solo comentarios o analisis completo. Usaremos el análisis completo para poder ver todas la funcionalidades, pero el proceso sería el mismo para los 3.
Selecionamos *Scan->Full Scan*.
El análisis comenzará y se mostrará una barra de progreso. 
4. Visualización de resultados. 
Cuando termine, podremos ver los resutados obtenidos en texto con el siguiente fomato:

	SEVERIDAD: Problema encontrados
Número de linea - Nombre del fichero
Descripción del problema
[Vista previa del fragmento de código]

	Además se muestra con un código de colores en función de la severidad del error(*Imagen 4: Resultado Análisis*) y es posible ver una vista resumen del análisis(*Imagen 5: Resumen Análisis*).
	![Imagen 4: Resultado Análisis](res/Resultado "Imagen 4: Resultado Análisis")
	![Imagen 5: Resumen Análisis](res/Resumen "Imagen 5: Resumen Análisis")
VCG cuenta tambíen con un modo de visualización para el análisis de los comentarios. En este modo se muestra un diagrama de sectores en el que se muestra la proporcion de comentarios, líneas de codigo, líneas en blanco y líneas con errores respecto al total de líneas (*Imagen 6: Diagrama de Sectores*).
![Imagen 6: Diagrama de Sectores](res/Sectores "Imagen 6: Diagrama de Sectores")
Para ver el diagrama hay que seleccionar *Scan->VisualCode/Comment Breakdown*.

###Línea de comandos (opcional)

Este apartado lo he marcado como opcional, ya que es algo mas complicado y tedioso, debido a que se antoja necesario conocer el comando, las opciones y la ruta hasta el código fuente. Además requiere tener añadido el programa a la variable path del sistema para que reconozca el comando. A pesar de esto, puede tener sentido si queremos automatizar el análisis mediante un script para ejecutarlo de manera periódica o después de cada compilación.
Para utilizar el programa desde linea de comandos hay que escribir el comando que tiene la siguiente sintaxis (solo incluyo los necesarios o más interesantes para este ejercicio, el resto estan disponibles en la [página web](https://github.com/nccgroup/VCG) del proyecto):
```
VisualCodeGrepper [options]
	-t, --target  <ruta al fichero | ruta al directorio>: Indica los ficheros a escanear.
	-l, --language <CPP|PLSQL|JAVA|CS|VB|PHP>: indica el lenguaje en el que están escritos los ficheros.
	-x, --export <Nombre del fichero>:	Exporta automaticamente los resultados a un fichero XML.
	-f, --csv-export <Nombre del fichero>:	Exporta automaticamente los resultados a un fichero CSV.
	-r, --results <Nombre del fichero>:	Exporta automaticamente los resultados a un fichero de texto plano.

```
Si no se indica una opción para exportar los resultados, solamente se inicia el programa con el lenguaje seleccionado y los ficheros cargados para comenzar el análisis.
Por tanto, si ejecutamos el siguiente comando:
``VisualCodeGrepper -t "<Ruta al codigo>" -l "JAVA"``
Se abrirá el programa con el lenguaje Java y los archivos cargados listo para ejecutar el análisis(*Imagen 7: Programa tras ejecutar el comando*).
![Imagen 7: Programa tras ejecutar el comando*](res/InicioComandos "Imagen 7: Programa tras ejecutar el comando*
Y, si ejecutamos este otro:
``VisualCodeGrepper -t "<Ruta al codigo>" -l "JAVA" -x "C:\Users\<Usuario>\Result.xml"``
Se abrirá el programa, se ejecutará el analisis y se guardará en el escritorio en formato XML.

##Configuración de perfiles

La aplicación toma los tipos de errores que debe detectar de un fichero de texto plano. Este fichero se puede comentar, de manera que es posible escoger que reglas de las predefinidas quieres que se apliquen o incluso añadir nuevas reglas.
Para probar esta opción vamos a modificar las reglas para que se muestre un error cuando se utiliza la interfaz List de java. He escogido esta interfaz porque, aunque no es potencialmente peligrosa, se usa en varias ocasiones en el código proporcionado y, por tanto, sirve como ejemplo para ver las reglas personalizadas.
Los pasos a seguir son los siguientes:

1. Seleccionamos *Settings->Options*.
2. Nos posicionamos en la pestaña *Config Files* (*Imagen 8: Configuración*).
![Imagen 8: Configuración](res/Configuracion "Imagen 8: Configuración")
3. Seleccionamos el botón *Edit*  junto a la ruta del fichero Java.
4. Se abrirá el editor de texto. Nos vamos a la última linea del fichero e intoducimos la siguiente linea:
``java.util.List=>Has usado la interfaz List``
Y guardamos el fichero en el escritorio o en algún otro lugar para no sobreescribir el original.
5. En la pantalla de configuracion, seleccionamos la opción *...* (tres puntos)
para buscar el nuevo fichero de configuracion.
6. Acceptamos lo cambios seleccionando el botón *OK*.
7. Por último, seleccionamos *File->Clear* para eliminar el análisis anterior y repetimos el proceso de análisis para comprobar que ha funcionado.