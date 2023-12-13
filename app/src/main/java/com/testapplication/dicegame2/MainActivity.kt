package com.testapplication.dicegame2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val aboutbutton: Button = findViewById(R.id.aboutbutton)
        aboutbutton.setOnClickListener {
            // Do something in response to the about button click

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Instructions : ")
            builder.setMessage("You have 5 dice to roll, so does the computer. " +
                    "Once you click throw, you get your results. " +
                    "Click score to confirm the scores and add them to the total. " +
                    "If your scores are low, don't worry you can re-roll them by pressing throw once again," +
                    "but click on the dice that you are satisfied with to stop them from re-rolling. " +
                    "You can do this 3 times, and on the 3rd time, your scores will be added automatically." +
                    "\n\nHappy dicing!!!")
            builder.setNeutralButton("Ok"){dialog, id -> dialog.cancel()}
            builder.show()

            }

        val newgamebutton = findViewById<Button>(R.id.newgamebutton)
        newgamebutton.setOnClickListener {
            // Do something in response to the about button click
            startActivity(Intent(this, PlayBoard::class.java))

        }

        //click listener for rotating silhouette animation
        val rotatingImage: ImageView = findViewById(R.id.rot1)
        rotatingImage.setOnClickListener {
            rotateImage(rotatingImage)
            System.out.println("hello");
        }



    }

    //image rotate animation
    private fun rotateImage(view: View) {
        val rotateAnimation = RotateAnimation(
            0f, 720f,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )

        rotateAnimation.duration = 500 // Duration of the rotation animation in milliseconds
        rotateAnimation.fillAfter = true // Keeps the image in the rotated state after the animation

        view.startAnimation(rotateAnimation)
    }
}