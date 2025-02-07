# Carpeta `repository`

Esta carpeta contiene los **Repositorios** que actúan como una capa intermedia entre la fuente de datos (local o remota) y el `ViewModel`.

## Responsabilidades
- Combinar datos locales y remotos.
- Proporcionar una única fuente de verdad para los datos.
- Manejar la lógica de actualización de datos.

## Ejemplo de Uso
```kotlin
class UserRepository(
    private val userDao: UserDao,
    private val apiService: ApiService
) {
    fun getUsers(): LiveData<List<User>> {
        // Obtener datos de la API y guardarlos en la base de datos local
        viewModelScope.launch {
            val users = apiService.getUsers()
            userDao.insertAll(users)
        }
        // Retornar datos desde la base de datos local
        return userDao.getAllUsers()
    }
}
```

## Buenas Prácticas
- Usar coroutines para operaciones asíncronas.
- Centralizar el acceso a datos en los repositorios.
- Evitar exponer detalles de implementación (por ejemplo, si los datos vienen de una API o de la base de datos local).
```

---
