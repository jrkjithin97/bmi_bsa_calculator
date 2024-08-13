package com.example.luassignment3


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.luassignment3.databinding.LayoutBmiCalculatorBinding
import kotlin.math.round


class BmiCalculator : Fragment(R.layout.layout_bmi_calculator) {

    private var _binding: LayoutBmiCalculatorBinding? = null

    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LayoutBmiCalculatorBinding.inflate(inflater, container, false)
        val view = binding.root

        val calcbtn: Button = binding.calcbtn
        val htinp: EditText = binding.htinp
        val wtinp: EditText = binding.wtinp
        val output: TextView = binding.output

        calcbtn.setOnClickListener{
            var h = htinp.text.toString().toDouble()
            var w = wtinp.text.toString().toDouble()
            var res = round((w/(h*h))*1000)/1000
            output.text = "BMI: "+ res.toString() + " kg/m2"
        }

        return view
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}



