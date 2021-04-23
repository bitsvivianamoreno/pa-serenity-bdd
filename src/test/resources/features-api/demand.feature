# language: es

@Cucumber
Característica: Filtro de información demanda - API
  QUIERO tener un informe
  PARA la demanda de servicio de transporte de acuerdo con las compras y reservas realizadas relacionadas con Transporte a Piscilago.

  Esquema del escenario: Consultar demanda y realizar:
  1. Un filtro de la fecha que desea el usuario.
  2. Un filtro de punto de recogida.

    Dado Que Administrador desea ver la demanda por Fecha de transporte: <fecha>, Punto de recogida: <punto>, con el usuario: yulymode y clave: LyherWk.
    Cuando Administrador realiza la solicitud.
    Entonces Administrador debe poder ver resultado con filtro.

    Ejemplos:
      | Descripcion                  | fecha      | punto                                |
      | Filtro con fecha y punto     | 2021-03-19 | f921bc81-892e-4361-ae28-0aed7bbdafb8 |
      | Filtro con fecha y sin punto | 2021-03-20 |                                      |
      | Filtro sin fecha y con punto |            | f921bc81-892e-4361-ae28-0aed7bbdafb8 |
      | Filtros vacios               |            |                                      |