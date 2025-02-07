# Carpeta `local`

Esta carpeta contiene todo lo relacionado con el almacenamiento de datos locales utilizando **Room**.

## Estructura
- **Entities**: Clases que representan las tablas de la base de datos.
- **DAOs**: Interfaces que definen las operaciones de acceso a la base de datos.
- **Database**: Clase que representa la base de datos y proporciona acceso a los DAOs.

## Ejemplo de Uso
### Entity
```kotlin
@Entity(tableName = "users")
data class User(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "email") val email: String
)
```

### DAO
```kotlin
@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun getAllUsers(): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<User>)
}
```

### Database
```kotlin
@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
```

## Buenas Prácticas
- Usar `@Entity` para definir tablas.
- Usar `@Dao` para definir operaciones de base de datos.
- Usar `LiveData` o `Flow` para observar cambios en la base de datos.
```

---
