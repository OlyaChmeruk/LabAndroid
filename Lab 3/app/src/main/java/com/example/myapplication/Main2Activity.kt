package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        textField.text = ""
        val dbHandler = MindOrksDBOpenHelper(this, null)
        val cursor = dbHandler.getAllName()
        cursor!!.moveToFirst()
        textField.append((cursor.getString(cursor.getColumnIndex(MindOrksDBOpenHelper.COLUMN_NAME))))
        while (cursor.moveToNext()) {
            textField.append((cursor.getString(cursor.getColumnIndex(MindOrksDBOpenHelper.COLUMN_NAME))))
            textField.append("\n")
        }
        cursor.close()
    }


}
