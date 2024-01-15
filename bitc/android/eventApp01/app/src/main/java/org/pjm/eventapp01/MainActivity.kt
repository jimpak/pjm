package org.pjm.eventapp01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.widget.CompoundButton
import org.pjm.eventapp01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button1.setOnClickListener{
            binding.textView2.setText("버튼1 클릭")
        }
        binding.button1.setOnLongClickListener{
            binding.textView2.setText("버튼1 Long클릭")
            true
        }
//        binding.button1.setOnClickListener(MyEventHandler(binding))
        binding.button2.setOnClickListener(MyEventHandler(binding))
        binding.button3.setOnClickListener(MyEventHandler(binding))

//        binding.button1.setOnClickListener(this)
//        binding.button2.setOnClickListener(this)
//        binding.button3.setOnClickListener(this)

//        binding.button1.setOnClickListener(View.OnClickListener {
//            binding.textView2.setText("버튼1을 눌렀음")
//        })
//        binding.button2.setOnClickListener(View.OnClickListener {
//            binding.textView2.setText("버튼2를 눌렀음")
//        })
//        binding.button3.setOnClickListener(View.OnClickListener {
//            binding.textView2.setText("버튼3을 눌렀음")
//        })
    }

    // xml 리소스로 이벤트 함수 등록
//    fun onClicked(view:View?) {
//        when(view?.id) {
//            R.id.button1 -> binding.textView2.setText("버튼1을 눌렀습니다")
//            R.id.button2 -> binding.textView2.setText("버튼2을 눌렀습니다")
//            R.id.button3 -> binding.textView2.setText("버튼3을 눌렀습니다")
//        }
//    }

    // 터치 이벤트
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action) { // ? : null 허용
            MotionEvent.ACTION_DOWN-> {
                Log.d(
                    "aaaa",
                    "Touch down event x:${event.x}, y:${event.y}, rawX:${event.rawX}, rawY:${event.rawY}"
                ) // log.i, log.d, log.e
                binding.tvResult.setText("Touch down event x:${event.x}, y:${event.y}, rawX:${event.rawX}, rawY:${event.rawY}")
            }
            MotionEvent.ACTION_UP-> {
                Log.d("aaaa", "Touch up event")
                binding.tvResult.setText("Touch up event")
            }
            MotionEvent.ACTION_MOVE-> {
                Log.d("aaaa", "Touch move event")
                binding.tvResult.setText("Touch move event x:${event.x}, y:${event.y}")
            }
        }
        return super.onTouchEvent(event)
    }

    // Key 이벤트
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        Log.d("bbbb", "onKeyDown")
        binding.tvResult.setText("onKeyDown")
        return super.onKeyDown(keyCode, event)
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        //key event code value
        when(keyCode) {
            KeyEvent.KEYCODE_0 -> binding.tvResult.setText("0키를 눌렀군요")
            KeyEvent.KEYCODE_1 -> binding.tvResult.setText("1키를 눌렀군요")
            KeyEvent.KEYCODE_A -> binding.tvResult.setText("A키를 눌렀군요")
            KeyEvent.KEYCODE_DPAD_UP -> binding.tvResult.setText("윗방향키를 눌렀군요")
            KeyEvent.KEYCODE_DPAD_DOWN -> binding.tvResult.setText("아래방향키를 눌렀군요")
        }

        Log.d("bbbb", "onKeyUp")
//        binding.tvResult.setText("onKeyUp")
        return super.onKeyUp(keyCode, event)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.button1 -> binding.textView2.setText("버튼1을 눌렀습니다")
            R.id.button2 -> binding.textView2.setText("버튼2을 눌렀습니다")
            R.id.button3 -> binding.textView2.setText("버튼3을 눌렀습니다")
        }
    }
}

class MyEventHandler(val binding: ActivityMainBinding):View.OnClickListener {

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.button1 -> binding.textView2.setText("버튼1을 눌렀습니다")
            R.id.button2 -> binding.textView2.setText("버튼2을 눌렀습니다")
            R.id.button3 -> binding.textView2.setText("버튼3을 눌렀습니다")
        }
    }

}