package com.example.guess_number

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.guess_number.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    val TAG:String = MainActivity::class.java.simpleName
    private lateinit var handler: Handler
    private lateinit var binding: ActivityMainBinding
    private val game = guessbutton()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handler = Handler(Looper.getMainLooper())

        binding.guess.setOnClickListener{
            val guessNum = binding.editText.text.toString().toInt()
            val resultText = game.onclick(guessNum)
            binding.textView.text = game.getRangeText()
            binding.result.text = resultText

            if (resultText == "你猜對了！") {
                handler.postDelayed({
                    Toast.makeText(this,"六秒後重製",Toast.LENGTH_SHORT).show()
                    game.resetGame()
                    binding.result.text = "再來一次"
                    binding.textView.text = "下一回合"
                },6000)
            }

        }

        binding.reset.setOnClickListener{
            game.resetGame()
            binding.result.text = "再猜一次"
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }
}

class guessbutton {
    private var valid_num:Int = 0
    private val range_num :IntArray = intArrayOf(1, 100)

    private var secret : Int = Random.nextInt(range_num[1]) + range_num[0]
    private var guess_number : IntArray = intArrayOf(range_num[0], range_num[1])

    var maxNum = 100
    var minNum = 0

    fun onclick(guess: Int): String {
        if (guess > secret) {
            if(guess_number[1] > guess) {
                guess_number[1] = guess
            }
            return "你猜得比較大"
        }
        else if (guess < secret) {
            if(guess_number[0] < guess){
                guess_number[0] = guess
            }
            return "你猜得比較小"
        }
        else {
            resetGame()
            return "你猜對了！"
        }
    }

    fun getRangeText(): String = "${guess_number[0]} ~ ${guess_number[1]}"

    fun resetGame(): String {
        secret = 1
        guess_number  = intArrayOf(range_num[0], range_num[1])
        return "重來一次"
    }

}
