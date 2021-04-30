# MeliChallenge


Para analizar un ADN hacer un `POST` request a `{url}/mutants'`( ej: `localhost:8080/mutants` ), con la sequencia de adn en el cuerpo de la request con el siguiente formato: 

`
{ "adn": "{Secuencia de ADN}" }
`

Para recibir estadisticas de la base de datos hacer una `GET` request a `{url}/stats`. ej: `localhost:8080/mutants`.
