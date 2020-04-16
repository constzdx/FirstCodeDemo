package zdx.love.fcd.vm
//https://www.jianshu.com/p/2f0c995f2566
import androidx.lifecycle.MutableLiveData
import zdx.love.fcd.repo.Repository
import zdx.love.fcd.vm.BaseViewModel

class MainViewModel : BaseViewModel() {

    /*工具人,LiveData数据从别处来时候启动工具人*/
    private var temp = MutableLiveData<Any?>()

    val datas = getResult(temp) {
        Repository.getDatas()
    }

    /**
     * 请求数据
     * 驱动temp被switchMap观测
     */
    fun requestData() {
        temp.value = temp.value
    }


}