package com.example.pomodorotimer

import android.icu.number.IntegerWidth
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.pomodorotimer.databinding.FragmentSettingsBinding

private const val TAG = "SettingsFragment"

class SettingsFragment : Fragment() {

    private var workTimeEntered = 25
    private var shortBreakEntered = 5
    private var longBreakEntered = 15

    private var _binding: FragmentSettingsBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visisble?"
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        binding.apply{
            backButton.setOnClickListener(){
            
                findNavController().navigate(SettingsFragmentDirections.toTimerFragment())
            }
            workTimeInput.doOnTextChanged { text, _, _, _ ->
                workTimeEntered = Integer.parseInt(text.toString())

                setFragmentResult(REQUEST_WORK_TIME, bundleOf(BUNDLE_WORK_TIME_VALUE to workTimeEntered))
            }
            shortBreakInput.doOnTextChanged { text, _, _, _ ->
                shortBreakEntered = Integer.parseInt(text.toString())
                Log.d("TAG", "ShortBreak: $shortBreakEntered")
                setFragmentResult(REQUEST_SHORT_BREAK, bundleOf(BUNDLE_SHORT_BREAK to shortBreakEntered))

            }
            longBreakInput.doOnTextChanged { text, _, _, _ ->
                longBreakEntered = Integer.parseInt(text.toString())
                setFragmentResult(REQUEST_LONG_BREAK, bundleOf(BUNDLE_LONG_BREAK to longBreakEntered))

            }
        }
        return binding.root
    }

    companion object {
        const val REQUEST_WORK_TIME = "REQUEST_WORK_TIME"
        const val REQUEST_SHORT_BREAK = "REQUEST_SHORT_BREAK"
        const val REQUEST_LONG_BREAK = "REQUEST_LONG_BREAK"
        const val BUNDLE_WORK_TIME_VALUE = "BUNDLE_WORK_TIME_VALUE"
        const val BUNDLE_SHORT_BREAK = "BUNDLE_SHORT_BREAK"
        const val BUNDLE_LONG_BREAK = "BUNDLE_LONG_BREAK"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
