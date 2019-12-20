package com.orange.orangedebug

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import androidx.fragment.app.Fragment
import com.orange.jzchi.jzframework.RootActivity
import com.orange.orangedebug.Frag.Frag_Log

class MainActivity : RootActivity() {
    override fun ChangePageListener(tag: String, frag: Fragment) {

    }

    override fun KeyLinsten(event: KeyEvent) {

    }

    override fun ViewInit(rootview: View) {
        ChangePage(Frag_Log(),"Frag_Log",true)
    }


}
