package zdx.love.fcd.model.network.service

import retrofit2.http.GET
import zdx.love.fcd.model.room.Data

interface ApiService {


    @GET("wxarticle/chapters/json")
    suspend fun getData(): Data


}
