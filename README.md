tic-tac-toe
===========

Implementación p2p de un juego tic tac toe en Java. Está compuesto de 2 partes: un servidor maestro y un cliente p2p.

Instrucciones
=======
 - En la carpeta del servidor (matching-server), vaya hacia \build\libs y, en una instancia de la consola, ejecute el servidor de matching así: `` java -jar matching-server-0.1.0.jar `` Nota: el servidor escuchará en el puerto 8080.
 - En la carpeta de los clientes (tic-tac-toe-client), diríjase a \build\libs, abra una instancia de la consola e ingrese `` java -jar tic-tac-toe-client-0.1.0.jar``
 - El primer cliente que se ejecute, de cada par, servirá como servidor p2p, y escuchará por el puerto 9998.
 - Inicie otra instancia del ejecutable del cliente.
 - Ya puede jugar. Puede hacer una movida ingresando una posición del 1 al 9, que corresponden a las casillas del tablero. Cuando acabe el turno de un jugador, empezará el del otro, hasta que la partida termine.