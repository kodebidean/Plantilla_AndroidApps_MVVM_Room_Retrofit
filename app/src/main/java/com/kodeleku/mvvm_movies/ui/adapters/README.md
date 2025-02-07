# Carpeta `adapters`

Esta carpeta contiene los **Adapters** y **ViewHolders** que se utilizan para manejar la visualización de datos en un `RecyclerView`.

## Responsabilidades
- **Adapter**: Vincula los datos con las vistas individuales (`ViewHolder`).
- **ViewHolder**: Mantiene referencias a las vistas y actualiza su contenido.

## Ejemplo de Uso
```kotlin
class UserAdapter(
    private val users: List<User>
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(
        private val binding: ItemUserBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User) {
            binding.textViewName.text = user.name
            binding.textViewEmail.text = user.email
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemUserBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int = users.size
}
```

### Buenas Prácticas
- Usar DiffUtil para mejorar el rendimiento al actualizar datos.
- Separar la lógica de clics en un listener externo.

---