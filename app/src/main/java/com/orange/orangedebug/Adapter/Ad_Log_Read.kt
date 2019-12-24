package com.orange.orangedebug.Adapter

import com.orange.jzchi.jzframework.RootAdapter
import com.orange.orangedebug.R
import kotlinx.android.synthetic.main.log_ad.view.*

class Ad_Log_Read(var a:List<String>):RootAdapter(R.layout.log_ad) {
    override fun SizeInit(): Int {
        return a.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val b=a[position]
        holder.mView.logtext.text=b.toUpperCase()
        if(b.contains("TX")){
            holder.mView.logtext.setTextColor(act.resources.getColor(R.color.colorRecieveText))
        }else{
            holder.mView.logtext.setTextColor(act.resources.getColor(R.color.colorAccent))
        }
    }

}