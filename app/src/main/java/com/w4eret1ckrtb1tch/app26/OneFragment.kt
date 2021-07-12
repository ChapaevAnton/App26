package com.w4eret1ckrtb1tch.app26

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.w4eret1ckrtb1tch.app26.data.Employee

class OneFragment : Fragment() {

    private val employee = Employee("Иванов", "Иван", "Иванович")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_one, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val previous: Button = view.findViewById(R.id.previous_button_1)
        val next: Button = view.findViewById(R.id.next_button_1)

        previous.setOnClickListener {
            if (MainActivity_26_7.getBackStackEntryCount(requireActivity()) != 0) {
                MainActivity_26_7.getNavController(requireActivity()).popBackStack()
            } else {
                Log.d("TAG", "backStackEntryCount: last ")
            }

            Log.d(
                "TAG",
                "backStackEntryCount: ${MainActivity_26_7.getBackStackEntryCount(requireActivity())}"
            )
        }

        next.setOnClickListener {
            val bundle = Bundle()
            bundle.putParcelable(MainActivity_26_7.EMPLOYEE_ONE, employee)

            MainActivity_26_7.getNavController(requireActivity())
                .navigate(R.id.action_oneFragment_to_twoFragment, bundle)
            Log.d(
                "TAG",
                "backStackEntryCount: ${MainActivity_26_7.getBackStackEntryCount(requireActivity())}"
            )
        }


    }

}