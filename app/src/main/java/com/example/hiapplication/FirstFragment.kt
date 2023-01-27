package com.example.hiapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hiapplication.databinding.FragmentFirstBinding
import com.highsoft.highcharts.common.hichartsclasses.HIChart
import com.highsoft.highcharts.common.hichartsclasses.HILine
import com.highsoft.highcharts.common.hichartsclasses.HIOptions

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }



        val chartView = binding.chartParent
        val options = HIOptions()
        chartView.options = options
        val chart =  HIChart()
        options.chart = chart
        val line = HILine()
        line.data = arrayListOf(1,2,3,4,3,1,2,4,5,4,3,2,1)
        val data = mutableListOf<HILine>()
        data.add(line)
        options.series = ArrayList(data)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}