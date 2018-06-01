Meta:
@product Blastoide3

Narrative:
Como usuario administrador
Yo quiero vender un producto
luego quiero poder ver la factura generada

Scenario: facturacion a cliente comun y poder ver la factura

Given Yo estoy en la pagina de Login
When Yo entro a todas las paginas con el usuario <firstName> y la password <lastName>
Then Yo valido que el titulo este presente
Examples:
| firstName | lastName |
| lucas     | lucas    |