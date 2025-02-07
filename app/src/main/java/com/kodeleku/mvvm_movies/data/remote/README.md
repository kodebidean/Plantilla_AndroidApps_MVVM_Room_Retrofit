# Carpeta `remote`

Esta carpeta contiene todo lo relacionado con las llamadas a APIs remotas utilizando **Retrofit**.

## Estructura
- **Interfaces**: Definiciones de los servicios de API.
- **Configuración**: Instancia de Retrofit y conversores (por ejemplo, Gson).

## Ejemplo de Uso
### Interface de Servicio
```kotlin
interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<User>
}
```

### Configuración de Retrofit
```kotlin
val retrofit = Retrofit.Builder()
    .baseUrl("https://api.example.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val apiService = retrofit.create(ApiService::class.java)
```

## Buenas Prácticas
- Usar `suspend` para funciones asíncronas.
- Definir modelos de datos que coincidan con la respuesta de la API.
- Usar un conversor como Gson para parsear JSON.
```

---
