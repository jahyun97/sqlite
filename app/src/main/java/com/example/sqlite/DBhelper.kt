package com.example.sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import  android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DBhelper (context: Context) :SQLiteOpenHelper(context, "sample.db", null,1 ){
    override fun onCreate(db: SQLiteDatabase?) {
        Log.i("msg", "테이블 생성")
        var sql = "CREATE TABLE USER (" +
                "id integer primary key autoincrement, " +
                "user_name text, "+
                "login_id text, "+
                "passwd text "+
                ")"

        db!!.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}