package com.orange.orangedebug.FireBase

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.jzsql.lib.mmySql.ItemDAO
import com.jzsql.lib.mmySql.Sql_Result


class MyFirebaseService : FirebaseMessagingService() {
    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        super.onMessageReceived(remoteMessage)
        Log.i("MyFirebaseService", "收到")
//        Log.i("MyFirebaseService", "title " + remoteMessage!!.data["data_title"]!!)
//        Log.i("MyFirebaseService", "body " + remoteMessage.data["data_content"]!!)
        val item= ItemDAO(this.applicationContext,"log.db")
        item.ExSql("CREATE TABLE   IF NOT EXISTS logtable (\n" +
                "    id   INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    data VARCHAR NOT NULL,\n" +
                "    type VARCHAR NOT NULL,\n" +
                "time TIME"+
                ");\n")
        item.ExSql("insert into logtable (type,data,time) values ('${remoteMessage!!.data["data_title"]!!}','${remoteMessage.data["data_content"]!!}','${remoteMessage.data["data_time"]!!}')")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MyFirebaseService", "close")
    }

    override fun onNewToken(s: String?) {
        super.onNewToken(s)
        Log.i("MyFirebaseService", "token " + s!!)
    }

}