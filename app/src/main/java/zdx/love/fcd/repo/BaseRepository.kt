package zdx.love.fcd.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

open class BaseRepository {



    /*这里应该还有一个本地磁盘读取*/

    /*P630*/
    /*网络请求*/
    protected suspend fun <T> fire(
        context: CoroutineContext,
        block: suspend () -> Result<T>
    ): LiveData<Result<T>> {

        val liveResult = MutableLiveData<Result<T>>()
        withContext(context) {

            val result = try {
                block()

            } catch (e: Exception) {
                Result.failure<T>(e)
            }
            liveResult.postValue(result)
        }

        return liveResult
    }
}