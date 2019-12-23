package com.orange.orangedebug.Adapter

import com.orange.jzchi.jzframework.RootAdapter
import com.orange.orangedebug.Beans.Beans_Log
import com.orange.orangedebug.Frag.Frag_LogRead
import com.orange.orangedebug.R
import kotlinx.android.synthetic.main.ad_log_review.view.*

class Ad_Log_Review(var beans: Beans_Log) : RootAdapter(R.layout.ad_log_review) {

    override fun SizeInit(): Int {
        return beans.tit.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mView.logtit.text = beans.tit[position]
        holder.mView.time.text=beans.time[position]
        holder.mView.setOnClickListener {
            act.ChangePage(Frag_LogRead(beans.data[position]),"Frag_LogRead",true)
        }
    }

}