Meta:
@product Blastoide

Narrative:
Como usuario administrador
Yo quiero vender un producto
luego quiero poder ver la factura generada

Scenario: facturacion a cliente comun y poder ver la factura

Given Yo estoy en la pagina de Login
When Yo entro con el usuario <firstName> y la password <lastName>
Then I validate the confirmation number
Examples:
| firstName | lastName |
| lucas     | lucas    |
| juan      | juan     |