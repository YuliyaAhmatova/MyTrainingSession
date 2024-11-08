package com.example.mytrainingsession

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ThirdActivity : AppCompatActivity() {

    private lateinit var toolbarThird:Toolbar
    private lateinit var startButton:Button
    private lateinit var exerciseTV:TextView
    private lateinit var descriptionTV:TextView
    private lateinit var timerTV:TextView
    private lateinit var backButton:Button
    private lateinit var imageViewIV:ImageView

    private lateinit var timer:CountDownTimer
    lateinit var exercise:Exercise

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_third)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        init()

        setSupportActionBar(toolbarThird)
        title = "Тренировки по фитнесу"

        exercise = intent.extras?.getSerializable("exercise") as Exercise
        exerciseTV.text = exercise.name
        descriptionTV.text = exercise.description
        startButton.setOnClickListener {
            startWorkout()
        }

        backButton.setOnClickListener {
            finish()
        }
    }

    private fun startWorkout() {
        startButton.isEnabled = false
        backButton.isEnabled = false
        startButton.text = "Процесс тренировки"
        timerTV.text = formatTime(exercise.durationInSeconds)
        imageViewIV.setImageResource(exercise.gifImage)
        timer = object : CountDownTimer (
            exercise.durationInSeconds * 1000L,
            1000
        ){
            override fun onTick(millisUntilFinished: Long) {
                timerTV.text = formatTime((millisUntilFinished / 1000).toInt())
            }

            override fun onFinish() {
                timerTV.text = "Упражнение завершено"
                imageViewIV.visibility = View.VISIBLE
                imageViewIV.setImageResource(0)
                backButton.isEnabled = true
                startButton.isEnabled = true
                startButton.text = "Начало тренировки"

            }
        }.start()
    }

    @SuppressLint("DefaultLocale")
    private fun formatTime(seconds: Int): String {
        val minutes = seconds / 60
        val remainingSeconds = seconds % 60
        return String.format("%02d:%02d", minutes, remainingSeconds)
    }

    private fun init() {
        startButton = findViewById(R.id.startButton)
        exerciseTV = findViewById(R.id.exerciseTV)
        descriptionTV = findViewById(R.id.descriptionTV)
        timerTV = findViewById(R.id.timerTV)
        backButton = findViewById(R.id.backButton)
        imageViewIV = findViewById(R.id.imageViewIV)
        toolbarThird = findViewById(R.id.toolbarThird)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_third, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.exitTAMenu -> {
                finishAffinity()
                Toast.makeText(
                    applicationContext,
                    "Программа завершена",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}