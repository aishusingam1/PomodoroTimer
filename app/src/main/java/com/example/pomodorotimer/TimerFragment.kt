package com.example.pomodorotimer

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.pomodorotimer.databinding.FragmentTimerBinding


class TimerFragment : Fragment(){

    private var _binding: FragmentTimerBinding? = null
    private val binding
        get() = checkNotNull(_binding){
            "Error statement"
        }

    lateinit var textView : TextView
    lateinit var messageView : TextView

    var workTimeMin = 20
    var shortBreakMin = 5
    var longBreakMin = 15

    private var isPaused = false
    private var isCancelled = false
    private var resumeFromMillis: Long = 0
    var workTime = true
    var cycleCount = 0
    var workTimeTotal = 0
    var totalCycleCount = 0

    var inputWorkTime = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTimerBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    fun startTimer(workTimeInput : Int, shortBreakInput : Int, longBreakInput : Int){
        workTimeMin = workTimeInput
        shortBreakMin = shortBreakInput
        longBreakMin = longBreakInput
        Log.d("TAG","Fragment Manager Changed Work Time: $workTimeMin")
        Log.d("TAG","Fragment Manager Changed Short Break: $shortBreakMin")
        Log.d("TAG","Fragment Manager Changed Long Break: $longBreakMin")


        var millisInFutureWork:Long = (workTimeMin.toLong())*60*1000
        var millisInFutureBreakShort:Long = (shortBreakMin.toLong())*60*1000
        var millisInFutureBreakLong:Long = (longBreakMin.toLong())*60*1000

        val countDownInterval:Long = 1000


        binding.apply{
            startButton.setOnClickListener {
                startButton.visibility = View.INVISIBLE
                pauseButton.visibility = View.VISIBLE
                resumeButton.visibility = View.VISIBLE
                stopButton.visibility = View.VISIBLE
                Log.d("TAG", "Entered start button")



                if(workTime){
                    messageView.setText("Time to work!")
                    if((millisInFutureWork /1000)%60 < 10){
                        textView.setText("" + (millisInFutureWork/1000)/60 + ":0" + (millisInFutureWork /1000)%60)
                    } else {
                        textView.setText("" + (millisInFutureWork / 1000) / 60 + ":" + (millisInFutureWork / 1000) % 60)
                    }
                    timer(millisInFutureWork, countDownInterval)
                    workTimeTotal += workTimeMin

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
                        textView.setText("" + (millisInFutureBreakLong / 100) / 60 + ":" + (millisInFutureBreakLong / 1000) % 60)
                    }

                    timer(millisInFutureBreakLong, countDownInterval)
                }


                isCancelled = false
                isPaused = false
            }
    }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        Log.d("TAG", "Entered onViewCreated")
        textView = binding.textView
        messageView = binding.messageView

        setFragmentResultListener(
            SettingsFragment.REQUEST_WORK_TIME
        ) { _, bundle ->
            var newWorkTime = bundle.getInt(SettingsFragment.BUNDLE_WORK_TIME_VALUE)
            workTimeMin = newWorkTime
            var newShortBreak = bundle.getInt(SettingsFragment.BUNDLE_SHORT_BREAK)
            shortBreakMin = newShortBreak
            var newLongBreak = bundle.getInt(SettingsFragment.BUNDLE_LONG_BREAK)
            longBreakMin = newLongBreak
            Log.d("TAG", "Entered Fragment Listener: $workTimeMin , $shortBreakMin , $longBreakMin")
            startTimer(newWorkTime, newShortBreak, newLongBreak)
        }


        Log.d("TAG", "New Work Time: $inputWorkTime")
        var millisInFutureWork:Long = (workTimeMin.toLong())*60*1000
        var millisInFutureBreakShort:Long = (shortBreakMin.toLong())*60*1000
        var millisInFutureBreakLong:Long = (longBreakMin.toLong())*60*1000

        val countDownInterval:Long = 1000



        binding.apply{
            startButton.setOnClickListener {
                startButton.visibility = View.INVISIBLE
                pauseButton.visibility = View.VISIBLE
                resumeButton.visibility = View.VISIBLE
                stopButton.visibility = View.VISIBLE
                Log.d("TAG", "Entered start button")

                if(workTime){
                    messageView.setText("Time to work!")
                    if((millisInFutureWork /1000)%60 < 10){
                        textView.setText("" + (millisInFutureWork/1000)/60 + ":0" + (millisInFutureWork /1000)%60)
                    } else {
                        textView.setText("" + (millisInFutureWork / 1000) / 60 + ":" + (millisInFutureWork / 1000) % 60)
                    }
                    timer(millisInFutureWork, countDownInterval)
                    workTimeTotal += workTimeMin

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
            }

            stopButton.setOnClickListener{
                isCancelled = true
                isPaused = false

                findNavController().navigate(TimerFragmentDirections.showDetailsFragment2(workTimeTotal, totalCycleCount))
            }

            pauseButton.setOnClickListener{
                isPaused = true
                isCancelled = false

            }

            resumeButton.setOnClickListener{
                timer(resumeFromMillis, countDownInterval)

                isPaused = false
                isCancelled = false

            }


        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.fragment_timer, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        Log.d("TAG", "entered stop, going to settings")
        findNavController().navigate(TimerFragmentDirections.showSettingsFragment2())
        return super.onOptionsItemSelected(item)
    }

    fun timer(millisInFuture: Long, countDownInterval: Long){
        object : CountDownTimer(millisInFuture, countDownInterval){

            override fun onTick(millisUntilFinished: Long){

                if(isPaused){
                    resumeFromMillis = millisUntilFinished
                    cancel()
                } else if(isCancelled){
                    cancel()
                } else{
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
                    cycleCount++
                    totalCycleCount++
                    Log.d("TAG","CycleCount: " + cycleCount)
                }
            }
        }.start()

    }

}
