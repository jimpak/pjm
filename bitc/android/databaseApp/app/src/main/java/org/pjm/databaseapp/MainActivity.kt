package org.pjm.databaseapp

import android.content.ContentValues
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.pjm.databaseapp.databinding.ActivityMainBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // DB생성
        val db = openOrCreateDatabase("test_db", Context.MODE_PRIVATE, null)
        val tableName = binding.edit1.text.toString()

        binding.btnCreateTable.setOnClickListener { 
            try {
                val sql = """
                    create table $tableName (
                    _id integer primary key autoincrement,
                    name text not null,
                    phone text)
                """.trimIndent()
                db.execSQL(sql)
                binding.tvResult.append("${tableName}이 생성되었습니다")
            } catch (e:Exception) {
                e.printStackTrace()
                binding.tvResult.append("테이블 생성 중 오류 발생: ${e.message}")
            }
        }
        
        binding.btnInsert.setOnClickListener {
            // 1. 첫번째 방법
            val sql = "insert into $tableName (name, phone) values(?,?)"
            db.execSQL(sql, arrayOf("홍길동", "010-1234-5678"))

            // 2. 두번째 방법
            val values = ContentValues()
            values.put("name", "박정민")
            values.put("phone", "010-0000-0000")
            db.insert(tableName, null, values)

            binding.tvResult.append("\n 데이터저장")
        }

        binding.btnSelect.setOnClickListener {
            val sql = "select * from $tableName"
            db.rawQuery(sql, null).use { cursor ->
                while (cursor.moveToNext()) {
                    val id = cursor.getInt(0)
                    val name = cursor.getString(1)
                    val phone = cursor.getString(2)
                    binding.tvResult.append("$id, $name, $phone\n")
                }
            }
        }

        binding.btnUpdate.setOnClickListener {
            val values = ContentValues()
            values.put("_id", 1)
            values.put("name", "박정민")
            values.put("phone", "010-0000-0000")
            db.update(tableName, values, "_id=?", arrayOf("1"))
        }
    }
}