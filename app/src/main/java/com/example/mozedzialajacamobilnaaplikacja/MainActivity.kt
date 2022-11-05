package com.example.mozedzialajacamobilnaaplikacja

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView.FindListener
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import java.util.Stack
import java.util.LinkedList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var stos = Stack<String>()
        stos.addAll(listOf("Jeden","Dwa","Trzy"))
        var kolejka = LinkedList<String>()
        kolejka.addAll(listOf("Mamuś","Tatuś","Babuś"))
        var textwidze = findViewById<TextView>(R.id.textView2);
        fun LIFO(){
            textwidze.text = stos.peek()
            findViewById<Button>(R.id.button).setOnClickListener {
                stos.push(findViewById<EditText>(R.id.editTextTextPersonName).text.toString())
                textwidze.text = stos.peek()
            }
            findViewById<Button>(R.id.button2).setOnClickListener {
                if(stos.isNotEmpty()){
                    stos.pop()
                    if(stos.isEmpty()){
                        textwidze.text = " "
                    }
                    else {
                        stos.peek()
                    }
                }
                else{
                    textwidze.text = " "
                }
                textwidze.text = stos.peek()
            }
        }
        fun FIFO(){
            textwidze.text = kolejka.first
            findViewById<Button>(R.id.button2).setOnClickListener {
            if(kolejka.isNotEmpty()){
                kolejka.removeFirst()
                textwidze.text = kolejka.first
                if(kolejka.isEmpty()){
                    textwidze.text = ""
                }
                else{
                    textwidze.text = kolejka.first
                }
            }
            else {
                textwidze.text = ""
            }
            }
            findViewById<Button>(R.id.button).setOnClickListener {
                kolejka.addLast(findViewById<EditText>(R.id.editTextTextPersonName).text.toString())
                textwidze.text = kolejka.first
            }
        }
        findViewById<RadioButton>(R.id.radioButton).setOnClickListener{
            FIFO()
        }
        findViewById<RadioButton>(R.id.radioButton2).setOnClickListener {
            LIFO()
        }
    }
}