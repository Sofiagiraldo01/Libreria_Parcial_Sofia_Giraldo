## Parte teórica
## Preguntas de selección multiple

*Escribe el ID de la respuesta correcta y explica en una línea por qué las otras son incorrectas.*

## SM-1
Un equipo de desarrollo termina de escribir toda la funcionalidad 
de un módulo y luego le pide al QA que diseñe las pruebas. 
Según lo visto en clase, ¿cómo se llama este enfoque y cuál es su principal problema?

A. Shift-left testing. El problema es que las pruebas se vuelven demasiado técnicas para que el cliente las entienda.

B. Shift-right testing. El problema es que las pruebas solo se pueden ejecutar en producción.

C. Desarrollo tradicional con pruebas al final. El problema es que los defectos se detectan tarde, cuando corregirlos cuesta hasta 100 veces más que si se hubieran encontrado en etapas tempranas.

D. Integración continua. El problema es que requiere un pipeline de CI/CD que el equipo no tiene configurado.


Respuesta: C, Desarrollo tradicional

La A, No es porque las pruebas que va a desarrollar el QA son para revisar que el sistema si cumple con los requisitos de el y no el cliente.
La B, No es porque las pruebas no solo se pueden ejecutar en producción.
La D, No es porque no tiene nada que ver con que las pruebas se hagan de ultimo lugar.


## SM-2
Un desarrollador escribe el siguiente ciclo: primero implementa la función 
`calcular_descuento()` completa con todos los casos que se le ocurren, 
luego escribe los tests para verificar que funciona. ¿Qué regla de TDD está violando?

A. La regla del refactor, porque debería mejorar el código antes de escribir tests.

B. La primera regla de Uncle Bob: no escribir código de producción sin que exista primero un test que falle. El código fue escrito antes de que ningún test lo requiriera.

C. La regla del Green, porque el código debería ser mínimo y no cubrir todos los casos desde el inicio.

D. No está violando ninguna regla. TDD permite escribir el código primero siempre que los tests se escriban inmediatamente después.


Respuesta: B, el RED, primero escribir los test antes que el código


La A, No es porque el refactor es mejorar la funcionalidad.
La C, No es porque el Green es la parte de hacer la funcionalidad para que los test pasen
La D, No es porque si está violando la regal RED


## Preguntas Abiertas
## PA-1
Durante la semana 4 implementamos el carrito de compras con TDD 
y en el primer ciclo, el paso GREEN consistió en escribir el código
más simple posible aunque fuera "feo". Explica por qué TDD obliga a 
hacer esto en el GREEN y qué pasaría con el proceso si el desarrollador 
aprovecha ese paso para escribir código "limpio y completo" desde el inicio.

Respuesta: TDD obliga a hacer en el paso GREEN un código inicial que permita dar el aprobado de los test que requieran con la funcionalidad; si el desarrollador aproveha este paso para escribir codigo limpio eliminaría el paso del refactor y se quebraria el TDD.


## PA- 2
Explica con tus propias palabras la diferencia entre TDD y BDD. 
No es suficiente decir que uno usa código y el otro usa Gherkin. 
Explica qué problema resuelve cada uno, a quién está dirigido y 
por qué se complementan en lugar de reemplazarse.

Respuesta: El TDD es el test driven deveploment, lo que hace utilizar el RED-GREEN-REFACTOR, lo que hace es escribir primero las prubas para que fallen, luegi el codigo necesario para quie pasen y luego en el refactor lo que hace es mejorar el coigo para que se vea limpio y ordenado; esta destinado para desarrolladores y especialmnete para QAs, resuleve le problema de tener que hacer las pruebas de ultimo y luego tener demasiados errores que corregir.
Por otro lado esat el BDD que es el behavior driven development, que lo que hace es tener un lenguajae natural (gherkin) para que ademas de desarrolladores, product owner y clientes seoan que es lo que tiene el código.
Se complementan ya que para qeu un código este completo se necesita de TDD y BDD, ya que cada una tiene lo que le falta a la otra.


## PA - 3
Un compañero te muestra su suite de pruebas y dice: 
"Tengo 95% de cobertura de código, así que mi sistema 
no tiene bugs." Explica por qué esa afirmación es incorrecta. 
Usa un ejemplo concreto que demuestre que cobertura alta no 
garantiza ausencia de defectos.

Respuesta: Esta afirmación es incorrecta ya que se necesita el 100% de las pruebas para poder decir que el sistema no tiene bugs, Por ejemplo, una función podría calcular mal el IVA y aun así tener 100% de cobertura si los tests solo verifican que el método se ejecute sin errores. También puede ocurrir que un test recorra una línea de código pero nunca valide el resultado esperado. Por eso la calidad de las pruebas es más importante que el porcentaje de cobertura por sí solo.


## PA -4
En el contexto de la Regla 2 del examen 
(descuento entre 0% y 40%), un compañero 
dice que basta con probar el descuento del 
20% porque "si funciona con ese valor, funciona con todos". 
Explica por qué esa lógica es incorrecta y qué valores concretos deberías probar tú y por qué.


Respuesta: Esa lógica es incorrecta porque los errores normalmente aparecen en los límites y no en los valores intermedios. Probar solo 20% no garantiza que el sistema funcione correctamente con 0%, 40% o valores inválidos como 41%. Yo probaría -1%, 0%, 1%, 39%, 40% y 41% porque representan los puntos críticos donde suelen ocurrir errores de validación y comparación.


## PA- 5
Mirando el planeador de la asignatura, 
las semanas 3 y 4 cubren pruebas ágiles, 
TDD y BDD. Explica cómo estas prácticas 
se conectan con el concepto de CI/CD que veremos en la semana 6. 
¿Qué pasaría con un pipeline de CI/CD si el equipo no tiene 
una suite de tests automatizados sólida?

CI/CD depende de pruebas automatizadas para verificar rápidamente si el sistema sigue funcionando después de cada cambio. TDD y BDD ayudan a construir esa base de pruebas desde el inicio del proyecto. Cuando un desarrollador hace un push, el pipeline ejecuta automáticamente los tests para detectar errores antes de desplegar el software. Si el equipo no tiene una buena suite de pruebas, el pipeline no puede validar la calidad del sistema y existe un alto riesgo de desplegar código roto o con regresiones a producción.