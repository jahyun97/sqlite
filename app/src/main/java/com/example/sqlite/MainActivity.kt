package com.example.sqlite

import android.content.ContentValues
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            var dbHelper = DBhelper(this)
            var db = dbHelper.writableDatabase
            var sql = "select * from USER"
            var c:Cursor = db.rawQuery(sql, null)
            textView.text=""

            while(c.moveToNext()){
                var id_pos = c.getColumnIndex("id")
                var userName_pos = c.getColumnIndex("user_name")
                var loginName_pos = c.getColumnIndex("login_id")
                var passwd_pos = c.getColumnIndex("passwd")

                var id = c.getInt(id_pos)
                var userName = c.getString(userName_pos)
                var loginName = c.getString(loginName_pos)
                var passwd = c.getString(passwd_pos)

                textView.append("ID: ${id} \n")
                textView.append("userName: ${userName} \n")
                textView.append("loginName : ${loginName} \n")
                textView.append("passwd : ${passwd} \n")
            }
            db.close()
        }

        button2.setOnClickListener { view->
            var dbHelper = DBhelper(this)
            var db = dbHelper.writableDatabase

            var cv1:ContentValues = ContentValues()
            var cv2:ContentValues = ContentValues()
            cv1.put("user_name", "이순신")
            cv1.put("login_id","login1")
            cv1.put("passwd", "password_login1")
            cv2.put("user_name", "이순심")
            cv2.put("login_id", "login2")
            cv2.put("passwd", "password_login2")
            db.insert("USER", null, cv1)
            db.insert("USER", null, cv2)

//           var sql = "insert into USER(user_name, login_id, passwd)" +
//                    "values(?, ?, ?)"
//            var data1 = arrayOf("홍길동","login1","password")
//            var data2 = arrayOf("홍길순","lodin2","password")

//            db.execSQL(sql,data1)
//            db.execSQL(sql,data2)
            db.close()
        }

        button3.setOnClickListener { view->
            var dbHelper = DBhelper(this)
            var db = dbHelper.writableDatabase

            var sql = "update USER set user_name = ? where user_name= ?"

        }
    }
}
