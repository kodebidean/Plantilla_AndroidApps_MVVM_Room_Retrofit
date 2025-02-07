# Carpeta `viewmodel`

Esta carpeta contiene los **ViewModels** que actúan como intermediarios entre la **View** (UI) y el **Model** (datos).

## Responsabilidades
- Exponer datos a la UI utilizando `LiveData` o `StateFlow`.
- Manejar la lógica relacionada con la interacción del usuario.
- Comunicarse con los **Repositorios** para obtener o actualizar datos.

## Ejemplo de Uso
```kotlin
class UserViewModel(
    private val userRepository: UserRepository
) : ViewModel() {

    val users: LiveData<List<User>> = userRepository.getUsers()

    fun refreshUsers() {
        viewModelScope.launch {
            userRepository.refreshUsers()
        }
    }
}
```

### Buenas Prácticas
- Evitar incluir lógica de UI en el ViewModel.
- Usar LiveData o StateFlow para exponer datos a la UI.
- Utilizar viewModelScope para operaciones asíncronas.

---