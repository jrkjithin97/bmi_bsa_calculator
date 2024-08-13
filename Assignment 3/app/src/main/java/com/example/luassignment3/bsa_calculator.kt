package com.example.luassignment3


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.luassignment3.databinding.LayoutBsaCalculatorBinding
import kotlin.math.round
import kotlin.math.sqrt


class BsaCalculator : Fragment(R.layout.layout_bsa_calculator) {

    private var _binding: LayoutBsaCalculatorBinding? = null

    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LayoutBsaCalculatorBinding.inflate(inflater, container, false)
        val view = binding.root

        val calcbtn: Button = binding.calcbtn
        val htinp: EditText = binding.htinp
        val wtinp: EditText = binding.wtinp
        val output: TextView = binding.output

        calcbtn.setOnClickListener{
            var h = htinp.text.toString().toDouble()
            var w = wtinp.text.toString().toDouble()
            var res = round((sqrt((h*100*w)/3600))*1000) /1000
            output.text = "BSA: "+ res.toString() + " m2"
        }

        return view
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}



