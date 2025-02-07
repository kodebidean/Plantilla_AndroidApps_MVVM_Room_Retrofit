# Carpeta `views`

Esta carpeta contiene las **Actividades** y **Fragmentos** que representan la interfaz de usuario (UI) de la aplicación.

## Estructura
- **Actividades**: Clases que manejan pantallas completas (por ejemplo, `UserActivity`).
- **Fragmentos**: Clases que representan partes reutilizables de la UI (por ejemplo, `UserDetailFragment`).

## Responsabilidades
- Manejar la interacción del usuario.
- Observar los datos expuestos por los `ViewModels`.
- Actualizar la UI en respuesta a cambios en los datos.

## Ejemplo de Uso
```kotlin
class UserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserBinding
    private val viewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configura el RecyclerView
        val adapter = UserAdapter(emptyList())
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        // Observa los datos del ViewModel
        viewModel.users.observe(this, { users ->
            adapter.users = users
            adapter.notifyDataSetChanged()
        })
    }
}
```

---