package zdx.love.fcd

import android.app.Application
import android.content.Context


fun getContextGlobal()=APP.context
fun getApplicationGlobal()=APP.application

class APP :Application(){
    companion object{
        @JvmStatic
        lateinit var context: Context
        @JvmStatic
        lateinit var application: Application
    }
    override fun onCreate() {
        super.onCreate()
        application=this
        context=applicationContext
    }
}