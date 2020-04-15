package zdx.love.fcd

import android.view.View
import android.widget.Toast

fun showToast(string: String) {
    Toast.makeText(getContextGlobal(), string, Toast.LENGTH_LONG).show()
}


fun showSnack(view: View, block: (() -> Unit)? = null) {

    /*  Snackbar.make(view,"yes",Snackbar.LENGTH_LONG)
          .setAction("action",{
              block?.invoke()
          })
          .show()*/
}