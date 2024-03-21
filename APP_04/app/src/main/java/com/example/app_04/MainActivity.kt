package com.example.app_04

import android.media.AsyncPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    private lateinit var txtCom: ImageView
    private lateinit var txtResult: TextView
    private lateinit var imBtnScissors: ImageButton
    private lateinit var imBtnRock: ImageButton
    private lateinit var imBtnPaper: ImageButton
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtCom = findViewById<ImageView>(R.id.txtCom)
        txtResult = findViewById<TextView>(R.id.txtResult)
        imBtnScissors = findViewById<ImageButton>(R.id.imBtnScissors)
        imBtnRock = findViewById<ImageButton>(R.id.imBtnRock)
        imBtnPaper = findViewById<ImageButton>(R.id.imBtnPaper)
        imageView = findViewById(R.id.imageView)

        imBtnScissors.setOnClickListener{
            imageView.setImageResource(R.drawable.scissor)
            playGame(Choice.SCISSORS)
        }

        imBtnRock.setOnClickListener{
            imageView.setImageResource(R.drawable.rock)
            playGame(Choice.ROCK)
        }

        imBtnPaper.setOnClickListener{
            imageView.setImageResource(R.drawable.paper)
            playGame(Choice.PAPER)
        }
    }
    enum class Choice {
        SCISSORS, ROCK, PAPER
    }
    fun getChoiceString(choice: Choice): Int {
        return when (choice) {
            Choice.SCISSORS -> R.string.scissors
            Choice.ROCK -> R.string.rock
            Choice.PAPER -> R.string.paper
        }
    }
    fun playGame(playerChoice: Choice) {
        val choices = Choice.values()
        val computerChoices = choices[Random(1).nextInt(choices.size)]

        when {
            computerChoices == Choice.PAPER -> {
                imageView.setImageResource(R.drawable.paper)
            }
            computerChoices == Choice.SCISSORS -> {
                imageView.setImageResource(R.drawable.scissor)
            }
            computerChoices == Choice.ROCK -> {
                imageView.setImageResource(R.drawable.rock)
            }
        }

        when {
            playerChoice == computerChoices -> {

                txtResult.setText(R.string.draw)
            }
            (playerChoice == Choice.SCISSORS && computerChoices == Choice.PAPER) ||
                    (playerChoice == Choice.ROCK && computerChoices == Choice.SCISSORS) ||
                    (playerChoice == Choice.PAPER && computerChoices == Choice.ROCK) -> {

                txtResult.setText(R.string.win)
                }
            else -> {

                txtResult.setText(R.string.lose)
            }
        }
    }
}