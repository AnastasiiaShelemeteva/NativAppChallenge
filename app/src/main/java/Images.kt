import java.io.Serializable

data class Images (
    val id: Int,
    var isLiked: Boolean = false
): Serializable