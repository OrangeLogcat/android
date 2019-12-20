package com.orange.orangedebug.Adapter

import com.orange.jzchi.jzframework.RootAdapter
import com.orange.orangedebug.R
import kotlinx.android.synthetic.main.ad_log_review.view.*

class Ad_Log_Review(var log: ArrayList<String>) : RootAdapter(R.layout.ad_log_review) {

    override fun SizeInit(): Int {
        return log.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mView.logtit.text = log[position]
    }

}