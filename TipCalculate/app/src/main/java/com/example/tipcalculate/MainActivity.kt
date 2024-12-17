package com.example.tipcalculate

import android.os.Bundle
import android.widget.Button
import android.widget.EditText

import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tipcalculate.databinding.ActivityMainBinding

//용어 정리
/*
레이아웃: xml 레이아웃의 내용이 메모리에 객체화 되는 과정이 레이아웃 인플레이션
 */

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding //binding 상수를 나중에 초기화 해주겠다.:ActivityMainBinding 형태로
    private lateinit var costTipText : EditText
    private lateinit var costRadioGroup: RadioGroup
    private lateinit var calculateButton: Button
    private lateinit var tipAmountText : TextView

    override fun onCreate(savedInstanceState: Bundle?) //안드로이드가 실행시 상속된 함수를 오버라이딩 하겠다.
    {
        //부모의 onCreate 함수를 사용한다.(안전한 인스턴스 상태)로 전달.
        super.onCreate(savedInstanceState)//만약 안전하지 않은 상태라면 강제종료가 될 것이라 예상됨.
        //inflate와 bind의 차이
        //inflate : 생성된 binding 객체의 static api 를 사용하여 레이아웃 인플레이션
        //상수 초기화 activity main에 있는 모든 xml 내용을 가지고 온다.-> 트리 구조
        binding = ActivityMainBinding.inflate(layoutInflater)

        //setContentView()의 역할
        //화면에 나타날 뷰를 지정
        //레이아웃 내용을 메모리에 객체화
        setContentView(binding.root)

        //정의 부분
        costTipText = binding.serviceCost
        costRadioGroup = binding.tipOption
        calculateButton = binding.calSwitch
        tipAmountText = binding.tipAmount



        //calculate tip이 눌려졌을때 발생
        calculateButton.setOnClickListener { calculateTip()}

    }

    private fun calculateTip()
    {
        val radioId: Int = costRadioGroup.checkedRadioButtonId
        val price : Float? = if(costTipText.text.isNotBlank()) costTipText.text.toString().toFloat()
                             else null

        when(radioId)
        {
            binding.optAmazing.id -> tipAmountText.text=(price?.times(0.2) ?: 0.0).toString()
            binding.optGood.id ->tipAmountText.text=(price?.times(0.15) ?: 0.0).toString()
            binding.optOkay.id ->tipAmountText.text=(price?.times(0.1) ?: 0.0).toString()
        }


    }

}