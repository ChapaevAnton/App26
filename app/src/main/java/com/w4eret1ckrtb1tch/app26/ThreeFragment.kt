package com.w4eret1ckrtb1tch.app26

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

class ThreeFragment : Fragment() {

    private val args: ThreeFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val employee1 = args.employee1
        val employee2 = args.employee2
        Log.d("TAG", "employee1: $employee1")
        Log.d("TAG", "employee2: $employee2")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_three, container, false)

    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val previous: Button = view.findViewById(R.id.previous_button_3)
        val next: Button = view.findViewById(R.id.next_button_3)

        previous.setOnClickListener {
            MainActivity_26_7.getNavController(requireActivity()).popBackStack()
            Log.d("TAG", "backStackEntryCount: ${MainActivity_26_7.getBackStackEntryCount(requireActivity())}")
        }

        next.setOnClickListener {
            MainActivity_26_7.getNavController(requireActivity()).navigate(R.id.action_threeFragment_to_oneFragment)
            Log.d("TAG", "backStackEntryCount: ${MainActivity_26_7.getBackStackEntryCount(requireActivity())}")
        }


    }

}