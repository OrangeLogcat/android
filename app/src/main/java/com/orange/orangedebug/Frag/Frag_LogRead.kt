package com.orange.orangedebug.Frag

import com.orange.jzchi.jzframework.RootFragement
import com.orange.orangedebug.R
import kotlinx.android.synthetic.main.logread.view.*

class Frag_LogRead(val content:String):RootFragement(R.layout.logread) {
    override fun ViewInit() {
        rootview.log.text=content
    }

}