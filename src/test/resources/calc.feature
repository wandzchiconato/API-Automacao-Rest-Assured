Feature: Calcular Numero

  Scenario Outline: Calcular Numeros
    Given que abro a calculadora
    When digito <num1>
    And clico em Somar
    And digito <num2>
    When quando clico no igual
    Then entao exibe o <resultado>

    Examples:
      | num1 | nun2 | resultado |
      | "3"  | "2"  | "5"       |
      | "0"  | "8"  | "8"       |
      | "4"  | "-1" | "3"       |