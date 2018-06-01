Meta:
@product Blastoide

Narrative:
Como usuario administrador
Yo quiero poder entrar a las paginas principales del sistema
luego quiero poder ver en cada una el titulo del sistema

Scenario: Validar que se muestre bien la pagina de facturacion

Given Yo estoy en la pagina de Login
When Yo entro a la pagina facturar con el usuario <firstName> y la password <lastName>
Then Yo valido que el titulo este presente
Examples:
| firstName | lastName |
| lucas     | lucas    |

Scenario: Validar que se muestre bien la pagina de Caja Diaria

Given Yo estoy en la pagina de Login
When Yo entro a la pagina Caja Diaria con el usuario <firstName> y la password <lastName>
Then Yo valido que el titulo este presente
Examples:
| firstName | lastName |
| lucas     | lucas    |

Scenario: Validar que se muestre bien la pagina de tipo de iva

Given Yo estoy en la pagina de Login
When Yo entro a la pagina Tipo de iva con el usuario <firstName> y la password <lastName>
Then Yo valido que el titulo este presente
Examples:
| firstName | lastName |
| lucas     | lucas    |

Scenario: Validar que se muestre bien la pagina de tipos de clientes

Given Yo estoy en la pagina de Login
When Yo entro a la pagina Tipo de clientes con el usuario <firstName> y la password <lastName>
Then Yo valido que el titulo este presente
Examples:
| firstName | lastName |
| lucas     | lucas    |

Scenario: Validar que se muestre bien la pagina de Clientes

Given Yo estoy en la pagina de Login
When Yo entro a la pagina clientes con el usuario <firstName> y la password <lastName>
Then Yo valido que el titulo este presente
Examples:
| firstName | lastName |
| lucas     | lucas    |

Scenario: Validar que se muestre bien la pagina de detalle de ctas corrientes

Given Yo estoy en la pagina de Login
When Yo entro a la pagina detalle de ctas corrientes con el usuario <firstName> y la password <lastName>
Then Yo valido que el titulo este presente
Examples:
| firstName | lastName |
| lucas     | lucas    |

Scenario: Validar que se muestre bien la pagina de productos

Given Yo estoy en la pagina de Login
When Yo entro a la pagina productos con el usuario <firstName> y la password <lastName>
Then Yo valido que el titulo este presente
Examples:
| firstName | lastName |
| lucas     | lucas    |

Scenario: Validar que se muestre bien la pagina de productos sin stock

Given Yo estoy en la pagina de Login
When Yo entro a la pagina productos sin stock con el usuario <firstName> y la password <lastName>
Then Yo valido que el titulo este presente
Examples:
| firstName | lastName |
| lucas     | lucas    |

Scenario: Validar que se muestre bien la pagina de productos por proveedor

Given Yo estoy en la pagina de Login
When Yo entro a la pagina productos por proveedor con el usuario <firstName> y la password <lastName>
Then Yo valido que el titulo este presente
Examples:
| firstName | lastName |
| lucas     | lucas    |

Scenario: Validar que se muestre bien la pagina de tipos de productos

Given Yo estoy en la pagina de Login
When Yo entro a la pagina tipos de productos con el usuario <firstName> y la password <lastName>
Then Yo valido que el titulo este presente
Examples:
| firstName | lastName |
| lucas     | lucas    |
