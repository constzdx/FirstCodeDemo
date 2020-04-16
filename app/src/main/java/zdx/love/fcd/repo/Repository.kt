package zdx.love.fcd.repo

import kotlinx.coroutines.Dispatchers
import zdx.love.fcd.model.network.service.ApiService
import zdx.love.fcd.model.network.ServiceCreater

object Repository : BaseRepository() {


    suspend fun getDatas() = fire(Dispatchers.IO) {

        val dataResponse = ServiceCreater.create<ApiService>()
            .getData()
        if (dataResponse.errorCode == 0) {
            Result.success(dataResponse)
        } else {
            Result.failure(RuntimeException(dataResponse.errorMsg))
        }

    }


}


