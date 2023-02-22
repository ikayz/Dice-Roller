package dev.ikayz.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create the rollButton reference
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        // Do a dice roll when the app starts
        rollDice()
    }

    /**
    Updates the value on dice roll
     */
    private fun rollDice() {
        val dice = Dice(6)
        val diceOne = Dice(6)

        // Create dice roll
        val diceRoll = dice.roll()
        val diceRollOne = diceOne.roll()


        val diceImage: ImageView = findViewById(R.id.imageView)
        val diceImageOne: ImageView = findViewById(R.id.imageView2)

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val drawableResourceOne = when (diceRollOne) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the image view
        diceImage.setImageResource(drawableResource)
        diceImageOne.setImageResource(drawableResourceOne)

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
        diceImageOne.contentDescription = diceRoll.toString()
    }
}

/**
 * This class creates a dice with a roll method
 */
class Dice(private val numSides: Int) {

    /**
    Method for dice roll
     */
    fun roll(): Int {
        return (1..numSides).random()
    }
}