package org.pjm.app08

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import org.pjm.app08.databinding.ActivityMainBinding
import org.pjm.app08.databinding.DialogLayoutBinding

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 커스텀 다이얼로그
        binding.button5.setOnClickListener {
            val dialogBinding = DialogLayoutBinding.inflate(layoutInflater)
            AlertDialog.Builder(this).run {
                setTitle("input")
                setView(dialogBinding.root)
                setPositiveButton("닫기", null)
                dialogBinding.radioButton.setOnClickListener {
                    val name = dialogBinding.editTextText.text.toString()
                    val gender = dialogBinding.radioButton.text.toString()
                    binding.tv1.setText("name:$name, gender:$gender")
                }
                dialogBinding.radioButton2.setOnClickListener {
                    val name = dialogBinding.editTextText.text.toString()
                    val gender = dialogBinding.radioButton2.text.toString()
                    binding.tv1.setText("name:$name, gender:$gender")
                }
                show()
            }
        }

        // 날짜 데이터 알림
        binding.button2.setOnClickListener {
            DatePickerDialog(this, object :DatePickerDialog.OnDateSetListener {
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                    binding.tv1.setText("date:$year, $month, $dayOfMonth")
                }
            }, 2024, 0, 16).show()
        }

        // 시간 데이터 알림
        binding.button3.setOnClickListener {
            TimePickerDialog(this, object : TimePickerDialog.OnTimeSetListener {
                override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                    binding.tv1.setText("time: $hourOfDay, $minute")
                }
            }, 0,0,true).show()
        }

        // 목록 출력 알림 다이얼로그
        binding.button4.setOnClickListener {
            val items = arrayOf("사과", "복숭아", "포도")
            AlertDialog.Builder(this).run {
                setTitle("item test")
                setIcon(android.R.drawable.ic_dialog_alert)
                setMultiChoiceItems(items, booleanArrayOf(true, false, false), object : DialogInterface.OnMultiChoiceClickListener {
                    override fun onClick(dialog: DialogInterface?, which: Int, isChecked: Boolean) {
                        binding.tv1.setText("${items[which]} ${if (isChecked) "선택됨" else "선택해제됨"}")
                    }
                })
                setPositiveButton("닫기", null)
                show()
            }
        }



        // 토스트
        binding.button.setOnClickListener {
            val toast = Toast.makeText(baseContext, "토스트 메시지", Toast.LENGTH_SHORT)
            toast.addCallback(
                object :Toast.Callback() {
                    override fun onToastHidden() { // 토스트가 사라질때 작업할 내용
                        super.onToastHidden()
                        binding.tv1.setText("toast hidden")
                    }

                    override fun onToastShown() { // 토스트가 실행될때 작업할 내용
                        super.onToastShown()
                        binding.tv1.setText("toast show...")
                    }
                }
            )

            toast.show()
        }

        val requestLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted ->
            if (isGranted) {
                Log.d("aaaaa", "callBack...gented")
            } else {
                Log.d("aaaa", "callBack...denied....")
            }

        }

        // 커미션 허용 확인
        val status = ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION")
        if(status == PackageManager.PERMISSION_GRANTED)
            Log.d("aaaa", "greanted....")
        else
            requestLauncher.launch("android.permission.ACCESS_FINE_LOCATION")
    }
}