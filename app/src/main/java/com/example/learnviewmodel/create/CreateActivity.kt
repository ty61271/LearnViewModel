package com.example.learnviewmodel.create

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.learnviewmodel.R
import com.example.learnviewmodel.navigation.NavigationActivity
import kotlinx.android.synthetic.main.activity_create.*

class CreateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        intent.getStringExtra(NavigationActivity.FRAGMENT_TYPE_KEY).run {
            textView.text =
                if (this == NavigationActivity.FRAGMENT_VALUE_TASK) "this is a task"
                else if (this == NavigationActivity.FRAGMENT_VALUE_NOTE) "this is a notte"
                else "something went wrong"
        }
    }
}
