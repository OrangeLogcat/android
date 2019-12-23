package com.orange.orangedebug.Frag

import androidx.recyclerview.widget.LinearLayoutManager
import com.jzsql.lib.mmySql.ItemDAO
import com.jzsql.lib.mmySql.Sql_Result
import com.orange.jzchi.jzframework.RootFragement
import com.orange.orangedebug.Adapter.Ad_Log_Review
import com.orange.orangedebug.Beans.Beans_Log
import com.orange.orangedebug.MainActivity
import com.orange.orangedebug.R
import kotlinx.android.synthetic.main.activity_main.view.*
import java.io.*

class Frag_Log:RootFragement(R.layout.activity_main){
    lateinit var adapter:Ad_Log_Review
    var beans= Beans_Log()
    override fun ViewInit() {
        var item=ItemDAO(act,"log.db")
        item.ExSql("CREATE TABLE   IF NOT EXISTS logtable (\n" +
                "    id   INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    data VARCHAR NOT NULL,\n" +
                "    type VARCHAR NOT NULL,\n" +
                "time TIME"+
                ");\n")
        item.Query("select * from logtable", Sql_Result {
            beans.add(it.getString(2),it.getString(1),it.getString(3))
        })
        adapter=Ad_Log_Review(beans)
        rootview.re.layoutManager=LinearLayoutManager(act)
        rootview.re.adapter=adapter
        rootview.refresh.setOnClickListener {
          beans.clear()
            ItemDAO(act,"log.db").Query("select * from logtable", Sql_Result {
                beans.add(it.getString(2),it.getString(1),it.getString(3))
            })
            adapter.notifyDataSetChanged()
        }
    }

}