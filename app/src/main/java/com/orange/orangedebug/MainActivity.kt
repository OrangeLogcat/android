package com.orange.orangedebug

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import androidx.fragment.app.Fragment
import com.google.firebase.messaging.FirebaseMessaging
import com.jzsql.lib.mmySql.ItemDAO
import com.jzsql.lib.mmySql.Sql_Result
import com.orange.jzchi.jzframework.RootActivity
import com.orange.orangedebug.Frag.Frag_Log

class MainActivity : RootActivity() {
    lateinit var item: ItemDAO
    override fun ChangePageListener(tag: String, frag: Fragment) {

    }

    override fun KeyLinsten(event: KeyEvent) {

    }

    override fun ViewInit(rootview: View) {

        FirebaseMessaging.getInstance().subscribeToTopic("LogCat")
            .addOnCompleteListener {
                             Toast("註冊成功")
            };
        ChangePage(Frag_Log(),"Frag_Log",true)
    }


}
