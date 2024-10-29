import com.example.rickmorty.models.Info
import retrofit2.http.GET
import retrofit2.http.Path
import com.example.rickmorty.models.Result

interface RickAndMortyApi {
    @GET("character")
    suspend fun getCharacters(): Info

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") characterId: Int): Result
}


