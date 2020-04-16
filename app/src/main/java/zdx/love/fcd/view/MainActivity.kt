package zdx.love.fcd.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import zdx.love.fcd.vm.MainViewModel
import zdx.love.fcd.R
import zdx.love.fcd.utils.isNetWorkOk
import zdx.love.fcd.utils.showLog
import zdx.love.fcd.utils.showToast


private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {


    /*懒加载,需要的时候再用,不用管什么时候初始化的问题了*/
    private val mainVM by lazy {
        ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*请求网络数据*/
        request.setOnClickListener {
            /*首先网络监测*/
            if (!isNetWorkOk()){
                showToast("您似乎来到了没有网络的荒原....")
                return@setOnClickListener
            }

            showLog(this@MainActivity, "走到这里")
            mainVM.requestData()
        }

        mainVM.datas.observe(this, Observer {

        Log.v("hhlt","Observer")
            if (it.isSuccess) {
                val datas = it.getOrNull()

                if (datas != null) {
                    showJson.text = Gson().toJson(datas).toString()
                } else {
                    showToast("未查询到")
                    it.exceptionOrNull()?.printStackTrace()
                }


            } else {
                showToast("未查询到")
                it.exceptionOrNull()?.printStackTrace()
            }

        })

    }
}
