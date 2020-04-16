package zdx.love.fcd.model.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



object ServiceCreater {

    private  const val BASE_URL="https://wanandroid.com/"

    val retrofit=Retrofit.Builder()
       .baseUrl(BASE_URL)
       .addConverterFactory(GsonConverterFactory.create())
       .build()

    inline fun <reified T> create():T=
        retrofit.create(T::class.java)
}