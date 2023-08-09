//https://drive.google.com/drive/folders/1MDBE8nOUM563217jzZ8ex0ggebpd_3QH?usp=share_link
package com.testapplication.dicegame2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val aboutbutton: Button = findViewById(R.id.aboutbutton)
        aboutbutton.setOnClickListener {
            // Do something in response to the about button click

            val builder = AlertDialog.Builder(this)
            builder.setTitle("20210695 Yashasshree")
            builder.setMessage("I confirm that I understand what plagiarism is and have read and understood the section on assessment offences in the essential information for students. The work that I have submitted is entirely my own. Any work from other authors is duly referenced and acknowledged.")
            builder.setNeutralButton("Ok"){dialog, id -> dialog.cancel()}
            builder.show()

            }

        val newgamebutton = findViewById<Button>(R.id.newgamebutton)
        newgamebutton.setOnClickListener {
            // Do something in response to the about button click
            startActivity(Intent(this, PlayBoard::class.java))

        }



    }
}