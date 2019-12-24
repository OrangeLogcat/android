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
        val replacetext="樣本數:y\t成功:s\t失敗:f\t成功率:%"
        var success=0
        var fault=0
        val item=ItemDAO(act,"log.db")
        item.ExSql("CREATE TABLE   IF NOT EXISTS logtable (\n" +
                "    id   INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    data VARCHAR NOT NULL,\n" +
                "    type VARCHAR NOT NULL,\n" +
                "time TIME"+
                ");\n")
        item.Query("select * from logtable order by id desc", Sql_Result {
            beans.add(it.getString(2),it.getString(1),it.getString(3))
            if(it.getString(2).contains("成功")){
                success++
            }else{
                fault++
            }
        })
        if(beans.data.size!=0){rootview.tit.text=replacetext.replace("y","${beans.data.size}").replace("s","${success}").replace("f","${fault}").replace("%","${success*100/beans.data.size}")}
        adapter=Ad_Log_Review(beans)
        rootview.re.layoutManager=LinearLayoutManager(act)
        rootview.re.adapter=adapter
        rootview.refresh.setOnClickListener {
             success=0
             fault=0
          beans.clear()
            ItemDAO(act,"log.db").Query("select * from logtable order by id desc", Sql_Result {
                beans.add(it.getString(2),it.getString(1),it.getString(3))
                if(it.getString(2).contains("成功")){
                    success++
                }else{
                    fault++
                }
            })
            adapter.notifyDataSetChanged()
            if(beans.data.size!=0){rootview.tit.text=replacetext.replace("y","${beans.data.size}").replace("s","${success}").replace("f","${fault}").replace("%","${success*100/beans.data.size}")}
        }
        rootview.delete.setOnClickListener {
            beans.clear()
            item.DropTb("logtable")
            item.ExSql("CREATE TABLE   IF NOT EXISTS logtable (\n" +
                    "    id   INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "    data VARCHAR NOT NULL,\n" +
                    "    type VARCHAR NOT NULL,\n" +
                    "time TIME"+
                    ");\n")
          adapter.notifyDataSetChanged()
        }
        rootview.serch.setOnClickListener {
            val text=rootview.editText.text
            var count=0
            success=0
            fault=0
            beans.clear()
            ItemDAO(act,"log.db").Query("select * from logtable order by id desc", Sql_Result {
                if(it.getString(2).contains(text)){
                    count++
                    beans.add(it.getString(2).substring(0,it.getString(2).indexOf("*")),it.getString(1),it.getString(3))
                    if(it.getString(2).contains("成功")){
                        success++
                    }else{
                        fault++
                    }
                }
            })
            adapter.notifyDataSetChanged()
            if(beans.data.size!=0){rootview.tit.text=replacetext.replace("y","${count}").replace("s","${success}").replace("f","${fault}").replace("%","${success*100/count}")}
        }
    }

}