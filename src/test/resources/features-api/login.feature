# language: es

@Cucumber
Característica: Iniciar sesion - API
  Este feature se trata de iniciar sesion  en el portal de transporte.

  Esquema del escenario: Iniciar sesion
    Dado Que <actor> desea ingresar con usuario: <nombreUsuario> y clave: <claveUsuario>
    Cuando <actor> realiza la consulta
    Entonces <actor> deberia recibir respuesta exitosa.

    Ejemplos:
      | Descripcion                                  | actor         | nombreUsuario | claveUsuario |
      | Resultado con Usuario Administrador          | Administrador | yulymode      | LyherWk      |
      | Resultado con Usuario Transportista          | Transportista | 12345         | 12345        |
      | Resultado con Usuario Empresa Transportadora | Empresa       | 0987654321    | LyherWk      |