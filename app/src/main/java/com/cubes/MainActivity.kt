package com.cubes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton:Button = findViewById(R.id.button)
        rollDice()
        rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        val dice1 = Dice(6)
        val dice2 = Dice(6)

        var cubeRoll = dice1.roll()
        var DiceImage:ImageView = findViewById(R.id.imageDice1)
        DiceImgReplace(DiceImage, cubeRoll)

        cubeRoll = dice2.roll()
        DiceImage = findViewById(R.id.imageDice2)
        DiceImgReplace(DiceImage, cubeRoll)
    }

    private fun DiceImgReplace(Dice:ImageView, Roll: Int) {
        when(Roll) {
            1 -> Dice.setImageResource(R.drawable.dice_1)
            2 -> Dice.setImageResource(R.drawable.dice_2)
            3 -> Dice.setImageResource(R.drawable.dice_3)
            4 -> Dice.setImageResource(R.drawable.dice_4)
            5 -> Dice.setImageResource(R.drawable.dice_5)
            6 -> Dice.setImageResource(R.drawable.dice_6)
        }
    }

    class Dice(val numSides: Int) {
        fun roll(): Int {
            return(1..numSides).random()
        }

    }
}