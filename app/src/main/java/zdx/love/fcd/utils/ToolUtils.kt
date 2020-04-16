package zdx.love.fcd.utils

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import android.widget.Toast
import zdx.love.fcd.BuildConfig
import zdx.love.fcd.app.getContextGlobal

fun showToast(string: String, time: Int = Toast.LENGTH_LONG) {
    Toast.makeText(getContextGlobal(), string, time).show()
}


fun getThreadNow() = Thread.currentThread().name.toString()

fun showLog(any: Any, string: String) {
    if (BuildConfig.DEBUG) {
        Log.v(any.javaClass.simpleName, string)
    }

}


//2.断网测试
@SuppressLint("ObsoleteSdkInt")
fun isNetWorkOk(): Boolean {

    val context: Context = getContextGlobal()
    val cm =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    if (Build.VERSION.SDK_INT < 23) {
        val mWiFiNetworkInfo = cm.activeNetworkInfo
        if (mWiFiNetworkInfo != null) {
            if (mWiFiNetworkInfo.type == ConnectivityManager.TYPE_WIFI) { //WIFI
                return true
            } else if (mWiFiNetworkInfo.type == ConnectivityManager.TYPE_MOBILE) { //移动数据
                return true
            }
        }
    } else {
        val network = cm.activeNetwork
        if (network != null) {
            val nc = cm.getNetworkCapabilities(network)
            if (nc != null) {
                if (nc.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) { //WIFI
                    return true
                } else if (nc.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) { //移动数据
                    return true
                }
            }
        }
    }
    return false
}
