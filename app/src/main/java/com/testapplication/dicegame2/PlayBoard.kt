package com.testapplication.dicegame2

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class PlayBoard : AppCompatActivity() {
    private val imgnames = arrayOf("number1", "number2", "number3", "number4", "number5","number6")
    private val reroll = arrayOf("none","none","none","none","none")
    private var reroll2 = arrayOf("none","none","none","none","none")
    private var compReroll = arrayOf(false,false,false,false,false)
    private val ran = Random()
    var userW=false
    var compW=false
    var draw=false
    var rerollCount = 0
    companion object{
        var cwin = 0
        var uwin = 0
    }
    var clickCheck = false

    private lateinit var uimg1: ImageView
    private lateinit var uimg2: ImageView
    private lateinit var uimg3: ImageView
    private lateinit var uimg4: ImageView
    private lateinit var uimg5: ImageView

    private lateinit var cimg1: ImageView
    private lateinit var cimg2: ImageView
    private lateinit var cimg3: ImageView
    private lateinit var cimg4: ImageView
    private lateinit var cimg5: ImageView

    private var un1 = 0
    private var un2 = 0
    private var un3 = 0
    private var un4 = 0
    private var un5 = 0

    private var cn1 = 0
    private var cn2 = 0
    private var cn3 = 0
    private var cn4 = 0
    private var cn5 = 0

    private var user_roundscore = 0
    private var user_roundscore2 = 0
    private var user_roundscore3 = 0


    private var user_score = 0
    private var comp_roundscore = 0
    var comp_total=0

    var hardmode=0
    var incrementNumber = 0


    val uwindisplay : TextView?=null
    val cwindisplay : TextView?=null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        if (savedInstanceState!=null){
            rerollCount=savedInstanceState.getInt("rerollCount")
            user_roundscore=savedInstanceState.getInt("userroundscore")
            comp_roundscore=savedInstanceState.getInt("comproundscore")
            user_score=savedInstanceState.getInt("userscore")
            comp_total=savedInstanceState.getInt("compscore")
            updateUI()
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_board)
        println(rerollCount)

        val uwindisplay : TextView = findViewById(R.id.uwin)
        uwindisplay.text = "U : $uwin"
        val cwindisplay : TextView = findViewById(R.id.cwin)
        cwindisplay.text = "C : $cwin"

        uimg1 = findViewById(R.id.userslot1)
        uimg2 = findViewById(R.id.userslot2)
        uimg3 = findViewById(R.id.userslot3)
        uimg4 = findViewById(R.id.userslot4)
        uimg5 = findViewById(R.id.userslot5)

        cimg1 = findViewById(R.id.compslot1)
        cimg2 = findViewById(R.id.compslot2)
        cimg3 = findViewById(R.id.compslot3)
        cimg4 = findViewById(R.id.compslot4)
        cimg5 = findViewById(R.id.compslot5)

        //button declaration
        val userthrow: Button = findViewById(R.id.userthrow)
        val score: Button = findViewById(R.id.scorebutton)

        //functions for dice rollers

        fun userThrow1_d1(){
            //change user 1st image
            un1 = ran.nextInt(6)
            val resource_idu1 = resources.getIdentifier(
                imgnames[un1],
                "drawable",
                "com.testapplication.dicegame2"
            )
            uimg1.setImageResource(resource_idu1)
            user_roundscore+=(un1+1)

        }

        fun userThrow1_d2(){
            // Change user 2nd image
            un2 = ran.nextInt(6)
            val resource_idu2 = resources.getIdentifier(
                imgnames[un2],
                "drawable",
                "com.testapplication.dicegame2"
            )
            uimg2.setImageResource(resource_idu2)
            user_roundscore+=(un2+1)

        }

        fun userThrow1_d3(){
            //change user 3rd image
            un3 = ran.nextInt(6)
            val resource_idu3 = resources.getIdentifier(
                imgnames[un3],
                "drawable",
                "com.testapplication.dicegame2"
            )
            uimg3.setImageResource(resource_idu3)
            user_roundscore+=(un3+1)

        }

        fun userThrow1_d4(){
            //change users 4th image
            un4 = ran.nextInt(6)
            val resource_idu4 = resources.getIdentifier(
                imgnames[un4],
                "drawable",
                "com.testapplication.dicegame2"
            )
            uimg4.setImageResource(resource_idu4)
            user_roundscore+=(un4+1)

        }

        fun userThrow1_d5(){
            //change user 5th image
            un5 = ran.nextInt(6)
            val resource_idu5 = resources.getIdentifier(
                imgnames[un5],
                "drawable",
                "com.testapplication.dicegame2"
            )
            uimg5.setImageResource(resource_idu5)
            user_roundscore+=(un5+1)

        }

        fun compThrow_d1(){
            cn1 = ran.nextInt(6)
            val resource_idc1 = resources.getIdentifier(
                imgnames[cn1],
                "drawable",
                "com.testapplication.dicegame2"
            )
            cimg1.setImageResource(resource_idc1)
            comp_roundscore += (cn1+1)
        }

        fun compThrow_d2(){
            //change computer number 2
            cn2 = ran.nextInt(6)
            val resource_idc2 = resources.getIdentifier(
                imgnames[cn2],
                "drawable",
                "com.testapplication.dicegame2"
            )
            cimg2.setImageResource(resource_idc2)
            comp_roundscore += (cn2+1)
        }

        fun compThrow_d3(){
            //change computer number 3
            cn3 = ran.nextInt(6)
            val resource_idc3 = resources.getIdentifier(
                imgnames[cn3],
                "drawable",
                "com.testapplication.dicegame2"
            )
            cimg3.setImageResource(resource_idc3)
            comp_roundscore += (cn3+1)
        }

        fun compThrow_d4(){
            //change computer number 4
            cn4 = ran.nextInt(6)
            val resource_idc4 = resources.getIdentifier(
                imgnames[cn4],
                "drawable",
                "com.testapplication.dicegame2"
            )
            cimg4.setImageResource(resource_idc4)
            comp_roundscore += (cn4+1)
        }

        fun compThrow_d5(){
            //change computer number 5
            cn5 = ran.nextInt(6)
            val resource_idc5 = resources.getIdentifier(
                imgnames[cn5],
                "drawable",
                "com.testapplication.dicegame2"
            )
            cimg5.setImageResource(resource_idc5)
            comp_roundscore += (cn5+1)
        }

        //function to update scores
        fun updateRoundScores(){
            val urs : TextView = findViewById(R.id.userroundscore)
            val crs : TextView = findViewById(R.id.comproundscore)
            urs.text = user_roundscore.toString()
            crs.text = comp_roundscore.toString()
            user_roundscore=0
            comp_roundscore=0
        }

        //function to collect data on which dice not to reroll
        fun rerollSelection(){
            Toast.makeText(applicationContext,"Click on dices not to reroll",Toast.LENGTH_SHORT).show()
            val dice1 : ImageView = findViewById(R.id.userslot1)
            dice1.setOnClickListener{
                clickCheck=true
                Toast.makeText(applicationContext,"Dice 1 removed from reroll",Toast.LENGTH_SHORT).show()
                reroll[0] = "reroll"
            }

            val dice2 : ImageView = findViewById(R.id.userslot2)
            dice2.setOnClickListener{
                clickCheck=true
                Toast.makeText(applicationContext,"Dice 2 removed from reroll",Toast.LENGTH_SHORT).show()
                reroll[1] = "reroll"
            }

            val dice3 : ImageView = findViewById(R.id.userslot3)
            dice3.setOnClickListener{
                clickCheck=true
                Toast.makeText(applicationContext,"Dice 3 removed from reroll",Toast.LENGTH_SHORT).show()
                reroll[2] = "reroll"
            }

            val dice4 : ImageView = findViewById(R.id.userslot4)
            dice4.setOnClickListener{
                clickCheck=true
                Toast.makeText(applicationContext,"Dice 4 removed from reroll",Toast.LENGTH_SHORT).show()
                reroll[3] = "reroll"
            }

            val dice5 : ImageView = findViewById(R.id.userslot5)
            dice5.setOnClickListener{
                clickCheck=true
                Toast.makeText(applicationContext,"Dice 5 removed from reroll",Toast.LENGTH_SHORT).show()
                reroll[4] = "reroll"
            }
        }

        //game modes
        fun easyMode(){
            println("Easy Mode")

            compThrow_d1()
            compThrow_d2()
            compThrow_d3()
            compThrow_d4()
            compThrow_d5()

            for (i in compReroll.indices){
                compReroll[i]=ran.nextBoolean()

                if (compReroll[i] == true) {
                    when (i) {
                        0 -> compThrow_d1()
                        1 -> compThrow_d2()
                        2 -> compThrow_d3()
                        3 -> compThrow_d4()
                        4 -> compThrow_d5()
                    }
                }
            }

            comp_roundscore=0
            comp_roundscore=cn1+cn2+cn3+cn4+cn5+5
            val crs : TextView = findViewById(R.id.comproundscore)
            crs.text = comp_roundscore.toString()
            comp_total+=comp_roundscore


        }
        fun hardMode(){
            println("Hard Mode $hardmode")
            // Change computer 1st image
            cn1 = ran.nextInt(6)
            println(cn1)
            var i = 1
            while ((i < 3) and (cn1<3))  {
                cn1 = ran.nextInt(6)
                println("Try $i $cn1")
                i++
            }
            val resource_idc1 = resources.getIdentifier(
                imgnames[cn1],
                "drawable",
                "com.testapplication.dicegame2"
            )
            cimg1.setImageResource(resource_idc1)

            //change computers 2nd image
            cn2 = ran.nextInt(6)
            var j = 1
            while ((j < 3) and (cn2<3))  {
                cn2 = ran.nextInt(6)
                j++
            }
            val resource_idc2 = resources.getIdentifier(
                imgnames[cn2],
                "drawable",
                "com.testapplication.dicegame2"
            )
            cimg2.setImageResource(resource_idc2)

            //change computers 3rd image
            cn3 = ran.nextInt(6)
            var k = 1
            while ((k < 3) and (cn3<3))  {
                cn3 = ran.nextInt(6)
                k++
            }
            val resource_idc3 = resources.getIdentifier(
                imgnames[cn3],
                "drawable",
                "com.testapplication.dicegame2"
            )
            cimg3.setImageResource(resource_idc3)

            //change computers 4th image
            cn4 = ran.nextInt(6)
            var l = 1
            while ((l < 3) and (cn4<3))  {
                cn4 = ran.nextInt(6)
                l++
            }
            val resource_idc4 = resources.getIdentifier(
                imgnames[cn4],
                "drawable",
                "com.testapplication.dicegame2"
            )
            cimg4.setImageResource(resource_idc4)

            // Change computers 5th  image
            cn5 = ran.nextInt(6)
            var m = 1
            while ((m < 3) and (cn5<3))  {
                cn5 = ran.nextInt(6)
                m++
            }
            val resource_idc5 = resources.getIdentifier(
                imgnames[cn5],
                "drawable",
                "com.testapplication.dicegame2"
            )
            cimg5.setImageResource(resource_idc5)

            comp_roundscore=0
            comp_roundscore=cn1+cn2+cn3+cn4+cn5+5
            val crs : TextView = findViewById(R.id.comproundscore)
            crs.text = comp_roundscore.toString()
            comp_total+=comp_roundscore

        }

        fun wincheck(){
            val setMax: EditText = findViewById(R.id.max)
            var maximum = setMax.text.toString()
            var max = maximum.toInt()

            if ((comp_total==max) and(user_score==max)){
                draw=true
                println("match draw")
            }

            if((comp_total>max) and(user_score<max) and (comp_total>user_score)){
                compW=true
                println("computer win")
            }

            if((comp_total<max) and(user_score>max) and (comp_total<user_score)){
                userW=true
                println("user win")
            }


        }



        fun score(){
            wincheck()
            rerollCount=0

            val userTotal : TextView = findViewById(R.id.scoreBoard)
            userTotal.text = "$comp_total : $user_score"

            //drawn at match point procedure
            if (draw==true){
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Tied")
                builder.setMessage("You have tied an will be automatically rerolled")
                builder.setNeutralButton("Ok"){dialog, id -> dialog.cancel()}
                builder.show()
                userThrow1_d1()
                userThrow1_d2()
                userThrow1_d3()
                userThrow1_d4()
                userThrow1_d5()
                compThrow_d1()
                compThrow_d2()
                compThrow_d3()
                compThrow_d4()
                compThrow_d5()

            }
            //computers winning message
            if(compW==true){
                cwin++
                val builder = AlertDialog.Builder(this)
                val textView = TextView(this)
                textView.text = ("Computer Wins. \n Return to home screen")
                textView.setTextColor(Color.RED)
                textView.setBackgroundColor(Color.BLACK)
                textView.gravity = Gravity.CENTER
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30f)
                builder.setView(textView)
                builder.show()
                score.isEnabled = false
                userthrow.isEnabled = false
                val cwindisplay : TextView = findViewById(R.id.cwin)
                cwindisplay.text = "C : $cwin"

            }
            if(userW==true){
                //users winning message
                uwin ++
                val builder = AlertDialog.Builder(this)
                val textView = TextView(this)
                textView.text = ("User Wins!!!! \n Return to home screen")
                textView.setTextColor(Color.GREEN)
                textView.setBackgroundColor(Color.BLACK)
                textView.gravity = Gravity.CENTER
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30f)
                builder.setView(textView)
                builder.show()
                score.isEnabled = false
                userthrow.isEnabled = false
                val uwindisplay : TextView = findViewById(R.id.uwin)
                uwindisplay.text = "U : $uwin"

            }
        }




        val modeToggle: ToggleButton = findViewById(R.id.modeToggle)
        modeToggle.setOnCheckedChangeListener { _, isChecked ->

        }

        //throw button
        userthrow.setOnClickListener{
            if (rerollCount==0){
                userThrow1_d1()
                userThrow1_d2()
                userThrow1_d3()
                userThrow1_d4()
                userThrow1_d5()
                user_roundscore=0
                user_roundscore=un1+un2+un3+un4+un5+5
                user_score += user_roundscore
                val urs : TextView = findViewById(R.id.userroundscore)
                urs.text = user_roundscore.toString()
                rerollSelection()
                rerollCount++


                if (modeToggle.isChecked) {
                    hardMode()
                } else {
                    easyMode()
                }

            }

            else if (rerollCount==1){
                user_score-=user_roundscore
                    for (i in reroll.indices) {
                        if (reroll[i] != "reroll") {
                            when (i) {
                                0 -> userThrow1_d1()
                                1 -> userThrow1_d2()
                                2 -> userThrow1_d3()
                                3 -> userThrow1_d4()
                                4 -> userThrow1_d5()
                            }

                        }

                    }
                user_roundscore=0
                user_roundscore+=un1+un2+un3+un4+un5+5
                user_score += user_roundscore
                val urs : TextView = findViewById(R.id.userroundscore)
                urs.text = user_roundscore.toString()

                reroll[0]="none"
                reroll[1]="none"
                reroll[2]="none"
                reroll[3]="none"
                reroll[4]="none"
                rerollCount++

            }
            else if (rerollCount==2){
                user_score-=user_roundscore
                Toast.makeText(applicationContext,"No remaining throws",Toast.LENGTH_SHORT).show()
                for (i in reroll.indices) {
                    if (reroll[i] != "reroll") {
                        when (i) {
                            0 -> userThrow1_d1()
                            1 -> userThrow1_d2()
                            2 -> userThrow1_d3()
                            3 -> userThrow1_d4()
                            4 -> userThrow1_d5()
                        }
                    }
                }

                user_roundscore=0
                user_roundscore=un1+un2+un3+un4+un5+5
                user_score += user_roundscore
                val urs : TextView = findViewById(R.id.userroundscore)
                urs.text = user_roundscore.toString()
                reroll[0]="none"
                reroll[1]="none"
                reroll[2]="none"
                reroll[3]="none"
                reroll[4]="none"

                rerollCount=0
                score()
            }
        }


        //score button
        score.setOnClickListener{
            score()
        }

    }


    override fun onSaveInstanceState(outState: Bundle,) {
        super.onSaveInstanceState(outState)
        outState.putInt("rerollCount",rerollCount)
        outState.putInt("userroundscore", user_roundscore)
        outState.putInt("comproundscore", comp_roundscore)
        outState.putInt("userscore", user_score)
        outState.putInt("compscore", comp_total)

    }
    fun updateUI(){
        val urs : TextView = findViewById(R.id.userroundscore)
        urs.text = user_roundscore.toString()
        val crs : TextView = findViewById(R.id.comproundscore)
        crs.text = comp_roundscore.toString()
        val userTotal : TextView = findViewById(R.id.scoreBoard)
        userTotal.text = "$comp_total : $user_score"

    }
}
