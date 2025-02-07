# Carpeta `model`

Esta carpeta contiene las clases de modelo que representan los datos de la aplicación.

## Responsabilidades
- Definir la estructura de los datos (por ejemplo, entidades de Room o modelos de API).
- Proporcionar métodos de utilidad para manipular datos.

## Ejemplo de Uso
```kotlin
data class User(
    val id: Int,
    val name: String,
    val email: String
)
```

### Buenas Prácticas
- Usar data class para modelos inmutables.
- Separar modelos de la lógica de negocio.