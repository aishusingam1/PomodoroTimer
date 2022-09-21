package com.example.pomodorotimer

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.pomodorotimer.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null

    lateinit var totalMinutes : TextView
    lateinit var totalCycleCount : TextView

    private val args: DetailsFragmentArgs by navArgs()
  
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        totalMinutes = binding.totalMinutes
        totalCycleCount = binding.totalNumCycles

        totalMinutes.setText(args.totalWorkTime.toString())
        totalCycleCount.setText(args.totalCycleCount.toString())

        binding.apply{
            startNew.setOnClickListener {
                findNavController().navigate(R.id.details_to_timer)
            }
        }
    }

    override fun onResume() {
        super.onResume()

    }

    override fun onPause() {
        super.onPause()

    }

    override fun onDestroy() {
        super.onDestroy()

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
