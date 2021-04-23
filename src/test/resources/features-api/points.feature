# language: es

@Cucumber
Característica: Obtener puntos de transporte - API
  Este feature se trata de listar todos los puntos de transportes.

  Escenario: Listar puntos
    Dado Que Administrador desea listar los puntos de transporte con usuario: yulymode y clave: LyherWk
    Cuando Administrador realiza la solicitud
    Entonces Administrador debe visualizar los puntos.