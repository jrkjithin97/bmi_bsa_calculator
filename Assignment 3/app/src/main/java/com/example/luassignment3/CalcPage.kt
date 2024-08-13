package com.example.luassignment3

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.app.PendingIntent
import androidx.core.app.NotificationCompat

class CalcPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_calc_page)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        //Notification

        fun createNotificationChannel(context: Context) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val name = "Not1"
                val descriptionText = "Notification Channel"
                val importance = NotificationManager.IMPORTANCE_DEFAULT
                val channel = NotificationChannel("101", name, importance).apply {
                    description = descriptionText
                }

                val notificationManager: NotificationManager =
                    context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                notificationManager.createNotificationChannel(channel)
            }
        }

        fun showNotification(context: Context,str: String) {
            val intent = Intent(context, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            val pendingIntent: PendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_IMMUTABLE)

            val builder = NotificationCompat.Builder(context, "101")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Notification")
                .setContentText(str)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)

            val notificationManager: NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.notify(0, builder.build())
        }

        createNotificationChannel(this)




        val keyval : TextView = findViewById(R.id.key)
        val cpcap : TextView = findViewById(R.id.cpcaption)
        val backbtn : Button = findViewById(R.id.backbtn)
        val calcbtn : Button = findViewById(R.id.calc)
        val infobtn: Button = findViewById(R.id.info)



        var msg = ""
        val bundle: Bundle? = intent.extras
        bundle?.let {
            msg = (bundle.getString("key")).toString()

        }
        //Displaying intent message
        keyval.text = "Intent message: "+ msg



        backbtn.setOnClickListener{
            if(msg=="bmi"){
                val intent = Intent(this, HomePage::class.java)
                intent.putExtra("key", "bmi")
                startActivity(intent)


            }
            else{
                val intent = Intent(this, HomePage::class.java)
                intent.putExtra("key", "bsa")
                startActivity(intent)

            }
        }

        val bmiCalcFragment = BmiCalculator()
        val bmiDetFragment = BmiDetails()
        val bsaCalcFragment = BsaCalculator()
        val bsaDetFragment = BsaDetails()
        if(msg=="bmi") {

            //Show notification
            showNotification(this,"BMI Calculator is running")

            //Setting Heading
            cpcap.text = "BMI Calculator"


            supportFragmentManager.beginTransaction().apply {
                replace(R.id.main_frame_layout, bmiCalcFragment)
                commit()
            }

        }
        else{
            //Show notification
            showNotification(this,"BSA Calculator is running")

            //Setting Heading
            cpcap.text = "BSA Calculator"


            supportFragmentManager.beginTransaction().apply {
                replace(R.id.main_frame_layout, bsaCalcFragment)
                commit()
            }

        }

        calcbtn.setOnClickListener{
            if(msg=="bmi"){

                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.main_frame_layout, bmiCalcFragment)
                    commit()
                }

            }
            else{

                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.main_frame_layout, bsaCalcFragment)
                    commit()
                }

            }
        }

        infobtn.setOnClickListener{

            if(msg=="bmi"){

                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.main_frame_layout, bmiDetFragment)
                    commit()
                }

            }
            else{

                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.main_frame_layout, bsaDetFragment)
                    commit()
                }

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

