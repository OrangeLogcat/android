package com.orange.orangedebug.Frag

import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.orange.jzchi.jzframework.RootFragement
import com.orange.orangedebug.Adapter.Ad_Log_Read
import com.orange.orangedebug.R
import kotlinx.android.synthetic.main.logread.view.*

class Frag_LogRead(val content:String):RootFragement(R.layout.logread) {
    lateinit var adapter:Ad_Log_Read
    override fun ViewInit() {
        var a=content.split("\n")
        adapter=Ad_Log_Read(a)
        rootview.re.layoutManager=LinearLayoutManager(act)
        rootview.re.adapter=adapter
        adapter.notifyDataSetChanged()
    }

}