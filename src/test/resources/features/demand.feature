# language: es

@Cucumber
Característica: YO como empresa transportadora y administrador del E-commerce
  QUIERO tener un informe
  PARA la demanda de servicio de transporte de acuerdo con las compras y reservas realizadas relacionadas con Transporte a Piscilago.

  1. En el módulo administrativo se debe contar con la demanda del Transporte de Piscilago.
  2. En el informe de la demanda de Transporte debe tener fecha de servicio, punto de recogida y total de personas que reservaron el transporte a Piscilago.

  Escenario: En el módulo administrativo debe contar una sección para conocer la demanda que se ha tenido en términos de servicio de transporte.
    Dado Que Administrador entra al portal de transporte con usuario: yulymode y clave: LyherWk
    Cuando Administrador ingresa a la sección de demanda de transporte
    Entonces Administrador debería visualizar la pantalla de demanda de trasporte con título: Demanda

  Escenario: Esta sección para el informe de la demanda de transporte debe contener lo siguiente:
  1. Fecha del transporte con un formato tipo fecha
  2. Punto de transporte o punto de recogida
  3. Total, de personas que reservaron transporte
    Dado Que Administrador entra al portal de transporte con usuario: yulymode y clave: LyherWk
    Cuando Administrador ingresa a la sección de demanda de transporte
    Entonces Administrador debería visualizar una tabla con las cabeceras de: Fecha de transporte, Punto de recogida y Total de personas

  Esquema del escenario: Esta sección del informe de la demanda del transporte debe contener los siguiente a nivel de experiencia, para una mejor y fácil consulta.
  1. Un filtro para el transporte estilo tooltip para la selección de la fecha que desea el usuario, el cual realiza la acción
  en el informe acorde a la fecha de selección.
  2. Un filtro de punto de recogida el cual se desplegará los puntos previamente configurados de recogida de transporte
    Dado Que Administrador entra al portal de transporte con usuario: yulymode y clave: LyherWk
    Cuando Administrador ingresa a la sección de demanda de transporte
    Entonces Administrador debería poder filtrar por Fecha de transporte: <fecha> y Punto de recogida: <punto>

    Ejemplos:
      | Descripcion                  | fecha      | punto    |
      | Filtro con fecha y punto     | 2021-03-19 | Calle 26 |
      | Filtro con fecha y sin punto | 2021-03-20 |          |
      | Filtro sin fecha y con punto |            | Calle 26 |
      | Filtros vacios               |            |          |
      | Filtro con fecha y punto     | 2021-03-17 | Calle 26 |
      | Filtro con fecha y punto     | 2021-04-10 | Calle 26 |
      | Filtro con fecha y punto     | 2021-03-22 | Calle 26 |
      | Filtro con fecha y punto     | 2021-03-23 | Calle 26 |
      | Filtro con fecha y punto     | 2021-03-21 | Calle 26 |
      | Filtro con fecha y punto     | 2021-03-31 | Calle 26 |
      | Filtro con fecha y punto     | 2021-03-18 | Calle 26 |