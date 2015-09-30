# RedisPoC

Este es un ejemplo que muestra como externalizar la sesión de usuario a Redis, un sistema de caché
distribuida.

La aplicación es un proyecto Maven que utiliza Spring y Redis. El fichero clave para indicar al servidor
dónde tiene que grabar la sesión es el fichero session.xml dónde se configura el conector de Redis (Jedis)
para indicarle la dirección de la caché distribuida.

La aplicación contempla la parametrización de Redis mediante la lectura de variable de entorno (redishost).
