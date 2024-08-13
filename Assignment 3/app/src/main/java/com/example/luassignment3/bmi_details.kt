package com.example.luassignment3


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.luassignment3.databinding.LayoutBmiDetailsBinding



class BmiDetails : Fragment(R.layout.layout_bmi_details) {

    private var _binding: LayoutBmiDetailsBinding? = null

    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LayoutBmiDetailsBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.info.text="The BMI scores are classified based on risk for cardiovascular disease "+
                "and can be applied to people of Caucasian, Hispanic, and African-American "+
                "race. However, these standards may underestimate the risk of "+
                "obesity and diabetes in people of Asian and South Asian descent. "+
                "A lower threshold should be used for these populations.\n\n"+
            "BMI Classification\n\n"+
        "Underweight: < 18.5 kg/m2\n"+
        "Normal weight: 18.5 to 24.9 kg/m2\n"+
        "Overweight: 25.0 to 29.9 kg/m2\n"+
        "Obesity: >= 30 kg/m2"

        return view
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}



