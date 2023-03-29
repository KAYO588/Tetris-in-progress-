package com.example.tetrisgod

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.tetrisgod.Storage.AppPreferences
import com.google.android.material.snackbar.Snackbar

lateinit var tvHighScore: TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        val btnNewGame = findViewById<Button>(R.id.btn_new_game)
        val btnResetGame = findViewById<Button>(R.id.btn_reset_score)
        val btnExit = findViewById<Button>(R.id.btn_exit)
        tvHighScore = findViewById(R.id.tv_score)


        btnNewGame.setOnClickListener(this::onBtnNewGameClick)
        btnResetGame.setOnClickListener(this::onBtnResetScoreClick)
        btnExit.setOnClickListener(this::OnBtnExitClick)

    }

    private fun onBtnNewGameClick(view: View){
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }

    private fun onBtnResetScoreClick(view: View){
        val preferences = AppPreferences(this)
        preferences.clearHighScore()
        Snackbar.make(view, "Score reset", Snackbar.LENGTH_SHORT).show()
        tvHighScore?.text = "High score ${preferences.getHighScore()}"

    }


    private fun OnBtnExitClick(view: View){
        System.exit(0)
    }
}