package com.teguhsiswanto.id.kotlin_firstcode

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    //    Numbers
    fun btn1Clicked(v: View) {
        sisipEkspresi("1", true)
    }

    fun btn2Clicked(v: View) {
        sisipEkspresi("2", true)
    }

    fun btn3Clicked(v: View) {
        sisipEkspresi("3", true)
    }

    fun btn4Clicked(v: View) {
        sisipEkspresi("4", true)
    }

    fun btn5Clicked(v: View) {
        sisipEkspresi("5", true)
    }

    fun btn6Clicked(v: View) {
        sisipEkspresi("6", true)
    }

    fun btn7Clicked(v: View) {
        sisipEkspresi("7", true)
    }

    fun btn8Clicked(v: View) {
        sisipEkspresi("8", true)
    }

    fun btn9Clicked(v: View) {
        sisipEkspresi("9", true)
    }

    fun btn0Clicked(v: View) {
        sisipEkspresi("0", true)
    }

    fun btnDotClicked(v: View) {
        sisipEkspresi(".", true)
    }

    fun btnOpenPClicked(v: View) {
        sisipEkspresi("(", true)
    }

    fun btnClosePClicked(v: View) {
        sisipEkspresi(")", true)
    }


    //    Operators
    fun btnPlusClicked(v: View) {
        sisipEkspresi("+", false)
    }

    fun btnMinusClicked(v: View) {
        sisipEkspresi("-", false)
    }

    fun btnMultiplicationClicked(v: View) {
        sisipEkspresi("*", false)
    }

    fun btnDivideClicked(v: View) {
        sisipEkspresi("/", false)
    }

    /*  btn clear
        fun btnClear {
            textLayer.text = ""
            textLayer2.text = ""
        }
    */

   /* fun cekDot(str:String):String {
        var string = textLayer.text
        if (string.takeLast(1) == str) {
            return ""
        }
    }*/

    fun btnClearClicked(v: View) {
        textLayer.text = ""
        textLayer2.text = ""
    }

    fun btnDelClicked(v: View) {
        var str = textLayer.text.toString()
        if (str.isNotEmpty()) {
            textLayer.text = str.substring(0, str.length - 1)
        }
        textLayer2.text = ""
    }

    fun sisipEkspresi(str: String, bersihkan: Boolean) {

        if (textLayer2.text.isNotEmpty()) {
            textLayer.text = ""
        }

        if (bersihkan) {
//            cekDot(str)
            textLayer2.text = ""
            textLayer.append(str)
        } else {
            textLayer.append(textLayer2.text)
            textLayer.append(str)
            textLayer2.text = ""
        }
    }

    fun btnEqualClicked(v: View) {
        try {
            val ekspresi = ExpressionBuilder(textLayer.text.toString()).build()
            val result = ekspresi.evaluate()
            val longResult = result.toLong()
            if (result == longResult.toDouble()) {
                textLayer2.text = longResult.toString()
            } else {
                textLayer2.text = result.toString()
            }

        } catch (ex:Exception) {
            Log.d("Exception", "message : " + ex.message )
        }
    }


}
