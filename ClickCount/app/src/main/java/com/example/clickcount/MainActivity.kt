package com.example.clickcount

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

/* saveInstanceState keys */
const val KEY_CNT_A = "cnt_a"
const val KEY_CNT_B = "cnt_b"

const val TAG = "MainActivity"

private var click_count_a = 0
private var click_count_b = 0
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_a = findViewById<Button>(R.id.btn_a)
        val btn_b = findViewById<Button>(R.id.btn_b)
        btn_a.setOnClickListener { click_a() }
        btn_b.setOnClickListener { click_b() }
    }

    fun click_a()
    {
        click_count_a++
        findViewById<TextView>(R.id.cnt_a).text = click_count_a.toString()
    }

    fun click_b()
    {
        click_count_b++
        findViewById<TextView>(R.id.cnt_b).text = click_count_b.toString()
    }

    override fun onSaveInstanceState(outState: Bundle)
    {
        super.onSaveInstanceState(outState)

    }

    override fun onRestart()
    {
        super.onRestart()
        Log.v("", "call Restart()");
    }

    override fun onStart()
    {
        super.onStart()
        Log.v("", "");
    }

    override fun onResume()
    {
        super.onResume()
        Log.v("", "");
    }

    override fun onPause()
    {
        super.onPause()
        Log.v("", "");
    }

    override  fun onStop()
    {
        super.onStop()
        Log.v("", "");
    }

    override fun onDestroy()
    {
        super.onDestroy()
        Log.v("", "");
    }
}