Feature: Un usuario ingresa a la aplicación para poder ver saldo de mensajes

  Background: Iniciar sesión
    Given  Que usuario ingresa a la pagina de inicio
    And Inicia sesión


  Scenario Outline: ver saldo de mensajes
    Given Que ingresa a la pagina resumen de la cuenta
    When hace click sobre un Plan Prepago
    And selecciona la opcion del Menu Mis Saldos
    Then visualiza la información del saldo de mensajes: <Titulo Del Card>

    Examples:
    |  Titulo Del Card   |
    |Saldo de Internet   |