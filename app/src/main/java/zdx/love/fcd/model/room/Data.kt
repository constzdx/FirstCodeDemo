package zdx.love.fcd.model.room


data class Data (
    val errorCode :Int,
    val errorMsg: String,
    val data: List<DataBean>){

    data class DataBean (
        val courseId :Int,
        val id :Int,
         val name: String,
        val order :Int,
        val parentChapterId :Int,
        val userControlSetTop:Boolean,
         val visible :Int,
         val children: List<*>
    )
}
