package org.pjm.databaseapp

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.pjm.databaseapp.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var db:SQLiteDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnInsert.setOnClickListener {
            db=DBHelper(this).writableDatabase
            val name = binding.editName.text.toString()
            val phone = binding.editPhone.text.toString()

            val values = ContentValues()
            values.put("name", name)
            values.put("phone", phone)
            db.insert("todo_tb", null, values)
            binding.editName.text = null
            binding.editPhone.text = null
        }

        binding.btnSelect.setOnClickListener {
            val sql = "select * from todo_tb"
            db = DBHelper(this).readableDatabase
            val cursor = db.rawQuery(sql, null)
            while (cursor.moveToNext()) {
                val name = cursor.getString(1)
                val phone = cursor.getString(2)
                binding.tv.append("$name, $phone\n")
            }
        }
    }
}