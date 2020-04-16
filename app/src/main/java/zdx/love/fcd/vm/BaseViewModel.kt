package zdx.love.fcd.vm

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {


    /**
     * 封装
     * 启发:
     * P630
     */
    protected  fun <T> getResult(
        temp: MutableLiveData<Any?>, /*工具人*/
        block:suspend () -> LiveData<Result<T>>
    ): LiveData<Result<T>> {

        val dataTemp = Transformations.switchMap(temp) {
            /*这里有没有必要呢*/
            val resultTemp = MutableLiveData<Result<T>>()
            /*防止vm销毁后协程依然存在*/
            viewModelScope.launch(Dispatchers.Main) {
                try {
                    resultTemp.value = block().value
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

            resultTemp
        }
        return dataTemp

    }


}