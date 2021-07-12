package com.w4eret1ckrtb1tch.app26

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.w4eret1ckrtb1tch.app26.data.Employee

class TwoFragment : Fragment() {

    private val employee1 = Employee("Николаев", "Николай", "Николаевич")
    private val employee2 = Employee("Петров", "Петр", "Петрович")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val employee: Employee? = arguments?.getParcelable(MainActivity_26_7.EMPLOYEE_ONE)
        Log.d("TAG", "employee: $employee")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val previous: Button = view.findViewById(R.id.previous_button_2)
        val next: Button = view.findViewById(R.id.next_button_2)


        previous.setOnClickListener {
            MainActivity_26_7.getNavController(requireActivity()).popBackStack()
            Log.d(
                "TAG",
                "backStackEntryCount: ${MainActivity_26_7.getBackStackEntryCount(requireActivity())}"
            )
        }

        next.setOnClickListener {
            val action =
                TwoFragmentDirections.actionTwoFragmentToThreeFragment(
                    employee1 = employee1, employee2 = employee2
                )
            it.findNavController().navigate(action)

            Log.d(
                "TAG",
                "backStackEntryCount: ${MainActivity_26_7.getBackStackEntryCount(requireActivity())}"
            )
        }

    }

}