# Carpeta `utils`

Esta carpeta contiene utilidades y extensiones que se utilizan en toda la aplicación.

## Ejemplos de Contenido
- Extensiones de Kotlin para clases estándar.
- Funciones de utilidad para formatear fechas, cadenas, etc.
- Clases de ayuda para operaciones comunes.

## Ejemplo de Uso
```kotlin
fun String.toTitleCase(): String {
    return this.split(" ").joinToString(" ") { it.capitalize() }
}
```

### Buenas Prácticas
- Usar @Singleton para dependencias únicas.
- Separar módulos por funcionalidad.