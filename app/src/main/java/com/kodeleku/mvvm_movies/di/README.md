
# Carpeta `di`

Esta carpeta contiene los módulos de inyección de dependencias utilizando **Hilt** o **Dagger**.

## Responsabilidades
- Proporcionar instancias de dependencias (por ejemplo, Retrofit, Room, Repositorios).
- Gestionar el ciclo de vida de las dependencias.

## Ejemplo de Uso
```kotlin
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://api.example.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
```

### Buenas Prácticas
- Usar @Singleton para dependencias únicas.
- Separar módulos por funcionalidad.