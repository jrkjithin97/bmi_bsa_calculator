package com.example.luassignment3

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_home_page)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val hpcap : TextView = findViewById(R.id.hpcaption)
        val hpbtn : Button = findViewById(R.id.hpbtn)
        val hpdesc: TextView = findViewById(R.id.hpdesc)
        var msg = ""
        val bundle: Bundle? = intent.extras
        bundle?.let {
            msg = (bundle.getString("key")).toString()
            hpcap.text = msg
        }
        if(msg=="bmi"){
            hpcap.text = "Body Mass Index"
            hpbtn.text = "BMI Calculator"
            hpdesc.text = "BMI is a measure used to determine a person’s degree of" +
                    "overweight. Calculated based on height and weight, BMI is" +
                    "easy to measure, reliable, and correlated with the" +
                    "percentage of body fat mass. It is a more accurate" +
                    "estimate of total body fat compared with body weight"+
                    "alone. BMI can also help gauge a person’s risk for " +
                    "conditions such as heart disease, high blood pressure," +
                    "type 2 diabetes, gallstones, respiratory problems, and" +
                    "certain cancers. "
        }
        else{
            hpcap.text = "Body Surface Area"
            hpbtn.text = "BSA Calculator"
            hpdesc.text = "BSA measures the total surface area of the body and is used"+
                    "to calculate drug dosages and medical indicators or " +
                    "assessments. The first formula was developed by Du Bois in "+
                    "1916 and since then, several others have been developed." +
                    "The Mosteller formula, which is the easiest to calculate" +
                    "and remember, is the most commonly used formula in "+
                    "practice and in clinical trials."

        }

        hpbtn.setOnClickListener{

            if(msg=="bmi"){

                val intent = Intent(this, CalcPage::class.java)
                intent.putExtra("key", "bmi")
                startActivity(intent)

            }
            else{
                val intent = Intent(this, CalcPage::class.java)
                intent.putExtra("key", "bsa")
                startActivity(intent)

            }


        }

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.it_bmi ->{

                val intent = Intent(this, HomePage::class.java)
                intent.putExtra("key", "bmi")
                startActivity(intent)


            }

            R.id.it_bsa ->{

                val intent = Intent(this, HomePage::class.java)
                intent.putExtra("key", "bsa")
                startActivity(intent)


            }




        }
        return true
    }


}