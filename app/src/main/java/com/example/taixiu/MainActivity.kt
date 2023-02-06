package com.example.taixiu

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val rollButton: Button=findViewById(R.id.button4)
        rollButton.setOnClickListener {
            rollDice()

        }
        rollDice()
    }

    private fun rollDice() {
        val dice=Dice(6)
        val value=dice.roll();
        val resultImageView:ImageView=findViewById(R.id.imageView)
        val img=when(value) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        resultImageView.setImageResource(img)
        resultImageView.contentDescription=dice.roll().toString()




//        val dice2=Dice(6)
//        val resultTextView1:TextView=findViewById(R.id.textView2)
//        resultTextView1.text=dice2.roll().toString()
//
//        val toast=Toast.makeText(this,"ket qua:"+dice.roll()+dice2.roll(),Toast.LENGTH_SHORT)
//        toast.show()
    }
}
class Dice(private val numSides:Int){
    fun roll(): Int{
        return (1..numSides).random()
    }
}