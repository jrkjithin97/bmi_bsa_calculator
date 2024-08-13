package com.example.luassignment3


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.luassignment3.databinding.LayoutBsaDetailsBinding



class BsaDetails : Fragment(R.layout.layout_bsa_details) {

    private var _binding: LayoutBsaDetailsBinding? = null

    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LayoutBsaDetailsBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.info.text="The average adult BSA is 1.7 m2 (1.9 m2 for adult males and "+
                "1.6 m2 for adult females). This number is used to "+
                "calculate dosages for cytotoxic anticancer agents. "+
                "To minimize variation in patient size, dosing for "+
                "most chemotherapeutic agents use mg of drug per "+
                "m2 of body surface area. Although this methodology "+
                "has not been rigorously validated, BSA-based "+
                "dosing has become the standard when prescribing "+
                "most cytotoxic agents and some therapeutic monoclonal " +"antibodies. In theory, BSA mitigates the variability "+
                "of patient size and abnormal adipose tissue to help "+
                "optimize drug efficacy, improve drug clearance and "+
                "to minimize or prevent toxicity."

        return view
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}



