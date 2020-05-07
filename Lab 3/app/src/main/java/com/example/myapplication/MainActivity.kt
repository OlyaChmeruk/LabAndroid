package com.example.myapplication

import android.content.Intent

import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity()
{
    val counter = 0
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val spinner =  findViewById(R.id.spinner) as Spinner;

        var fonts = arrayOf("Monospace", "Sans Serif", "Serif", "Bold", "Default")
        val aray = ArrayAdapter(this, android.R.layout.simple_spinner_item, fonts)
        // Set layout to use when the list of choices appear
        aray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Set Adapter to Spinner
        spinner!!.setAdapter(aray)
    }

    fun changeFont(view: View)
    {
        val spinner =  findViewById(R.id.spinner) as Spinner;
        val edit = findViewById(R.id.editText) as EditText;
        if (edit.text.isEmpty())
        {
            Toast.makeText(applicationContext, "Please add text", Toast.LENGTH_SHORT).show()
        }
        else {

        val typ = edit.typeface as Typeface
            when (spinner.selectedItem) {
                spinner.getItemAtPosition(0) -> if (typ !=Typeface.MONOSPACE)
                {edit.setTypeface(Typeface.MONOSPACE)
                    Toast.makeText(applicationContext, "Font changed", Toast.LENGTH_SHORT).show()}
                spinner.getItemAtPosition(1) -> if (typ !=Typeface.SANS_SERIF) {edit.setTypeface(Typeface.SANS_SERIF)
                    Toast.makeText(applicationContext, "Font changed", Toast.LENGTH_SHORT).show()}
                spinner.getItemAtPosition(2) ->  if (typ !=Typeface.SERIF) {edit.setTypeface(Typeface.SERIF)
                    Toast.makeText(applicationContext, "Font changed", Toast.LENGTH_SHORT).show()}
                spinner.getItemAtPosition(3) -> if (typ !=Typeface.DEFAULT_BOLD) {edit.setTypeface(Typeface.DEFAULT_BOLD)
                    Toast.makeText(applicationContext, "Font changed", Toast.LENGTH_SHORT).show()}
                spinner.getItemAtPosition(4) -> if (typ !=Typeface.DEFAULT) {
                    edit.setTypeface(Typeface.DEFAULT)
                    Toast.makeText(applicationContext, "Font changed", Toast.LENGTH_SHORT).show()
                } }


            val dbHandler = MindOrksDBOpenHelper(this, null)

            val user = Storage(edit.text.toString(),  spinner.selectedItemPosition, counter)
            dbHandler.addValue(user)
            counter.inc()

}
    }

    fun view (view: View)
    {
        val intent = Intent(this, Main2Activity::class.java)
        startActivity(intent)
    }

    fun clear(view: View)
    {
        val edit = findViewById(R.id.editText) as EditText;
        edit.setText("");
        Toast.makeText(applicationContext, "Text field cleared", Toast.LENGTH_SHORT).show()
    }


}

