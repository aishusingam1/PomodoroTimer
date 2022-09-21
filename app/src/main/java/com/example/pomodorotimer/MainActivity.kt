package com.example.pomodorotimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.pomodorotimer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    /*lateinit var textView : TextView
    lateinit var messageView : TextView
    private lateinit var binding: ActivityMainBinding

    private var isPaused = false
    private var isCancelled = false
    private var resumeFromMillis: Long = 0
    var workTime = true;
    var cycleCount = 0;*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
        /*binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        textView = findViewById(R.id.textView)
        messageView = findViewById(R.id.message)




        var millisInFutureWork:Long = 2*60*1000
        var millisInFutureBreakShort:Long = 1*60*1000
        var millisInFutureBreakLong:Long = 2*60*1000
        val countDownInterval:Long = 1000*/


        // time count down for 30 seconds,
        // with 1 second as countDown interval

       /* binding.startButton.setOnClickListener{
            binding.startButton.setVisibility(View.INVISIBLE)
            if(workTime){
                messageView.setText("Time to work!")
                if((millisInFutureWork /1000)%60 < 10){
                    textView.setText("" + (millisInFutureWork/1000)/60 + ":0" + (millisInFutureWork /1000)%60)
                } else {
                    textView.setText("" + (millisInFutureWork / 1000) / 60 + ":" + (millisInFutureWork / 1000) % 60)
                }
                timer(millisInFutureWork, countDownInterval)

            } else if(!workTime && cycleCount < 3){ //break time short
                messageView.setText("Short Break")
                if((millisInFutureWork /1000)%60 < 10){
                    textView.setText("" + (millisInFutureBreakShort/1000)/60 + ":0" + (millisInFutureBreakShort /1000)%60)
                } else {
                    textView.setText("" + (millisInFutureBreakShort / 1000) / 60 + ":" + (millisInFutureBreakShort / 1000) % 60)
                }
                timer(millisInFutureBreakShort, countDownInterval)

            } else if(!workTime && cycleCount >= 3){ // break time long
                cycleCount = 0
                messageView.setText("Long Break")
                if((millisInFutureWork /1000)%60 < 10){
                    textView.setText("" + (millisInFutureBreakLong/1000)/60 + ":0" + (millisInFutureBreakLong /1000)%60)
                } else {
                    textView.setText("" + (millisInFutureBreakLong / 1000) / 60 + ":" + (millisInFutureBreakLong / 1000) % 60)
                }
                timer(millisInFutureBreakLong, countDownInterval)
            }


            isCancelled = false
            isPaused = false

            *//*
            object : CountDownTimer(120000, 1000) {

                // Callback function, fired on regular interval
                override fun onTick(millisUntilFinished: Long) {
                    //textView.setText("seconds remaining: " + millisUntilFinished / 1000)
                    if((millisUntilFinished /1000)%60 < 10){
                        textView.setText("" + (millisUntilFinished/1000)/60 + ":0" + (millisUntilFinished /1000)%60)
                    } else {
                        textView.setText("" + (millisUntilFinished / 1000) / 60 + ":" + (millisUntilFinished / 1000) % 60)
                    }
                }

                // Callback function, fired
                // when the time is up
                override fun onFinish() {
                    textView.setText("done!")
                }
            }.start()

             *//*
        }

        binding.stopButton.setOnClickListener{
            isCancelled = true
            isPaused = false

            val myFragment = DetailsFragment()
            val fragment : Fragment? =

            supportFragmentManager.findFragmentByTag(DetailsFragment::class.java.simpleName)

            if(fragment !is DetailsFragment){
                supportFragmentManager.beginTransaction()
                    .add(R.id.stopButton, myFragment,DetailsFragment::class.java.simpleName )
                    .commit()
            }

        }

        binding.pauseButton.setOnClickListener{
            isPaused = true
            isCancelled = false
        }

        binding.resumeButton.setOnClickListener{
            timer(resumeFromMillis, countDownInterval)

            isPaused = false
            isCancelled = false
        }

    }


    fun timer(millisInFuture: Long, countDownInterval: Long){
        object : CountDownTimer(millisInFuture, countDownInterval){

            override fun onTick(millisUntilFinished: Long){
                val timeRemaining = "Seconds remaining\n${millisUntilFinished/1000}"


                if(isPaused){
                    //textView.setText("${textView.text}\nPaused")
                    resumeFromMillis = millisUntilFinished
                    cancel()
                } else if(isCancelled){
                    //textView.setText("${textView.text}\nStopped.(Cancelled)")
                    cancel()
                } else{
                    //textView.setText(timeRemaining)
                    if((millisUntilFinished /1000)%60 < 10){
                        textView.setText("" + (millisUntilFinished/1000)/60 + ":0" + (millisUntilFinished /1000)%60)
                    } else {
                        textView.setText("" + (millisUntilFinished / 1000) / 60 + ":" + (millisUntilFinished / 1000) % 60)
                    }
                }
            }

            override fun onFinish() {
                textView.setText("Done")
                binding.startButton.setVisibility(View.VISIBLE)
                if(workTime){
                    workTime = false
                } else{
                    workTime = true
                    cycleCount++;
                    Log.d("TAG","CycleCount: " + cycleCount)
                }
            }
        }.start()*/

        /*
        object : CountDownTimer(millisInFuture, countDownInterval){
            override fun onTick(millisUntilFinished: Long) {
                //textView.setText("seconds remaining: " + millisUntilFinished / 1000)
                if((millisUntilFinished /1000)%60 < 10){
                    textView.setText("" + (millisUntilFinished/1000)/60 + ":0" + (millisUntilFinished /1000)%60)
                } else {
                    textView.setText("" + (millisUntilFinished / 1000) / 60 + ":" + (millisUntilFinished / 1000) % 60)
                }
            }

            // Callback function, fired
            // when the time is up
            override fun onFinish() {
                textView.setText("done!")
            }
        }.start()

         */
    //}
}