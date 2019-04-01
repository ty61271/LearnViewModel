package com.example.learnviewmodel.navigation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.learnviewmodel.R
import com.example.learnviewmodel.create.CreateActivity
import com.example.learnviewmodel.notes.NotesListFragment
import com.example.learnviewmodel.tasks.TaskListFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_navigation.*

class NavigationActivity : AppCompatActivity(), TaskListFragment.TouchActionDelegate,
    NotesListFragment.TouchActionDelegate {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_tasks -> {
                replaceFragment(TaskListFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notes -> {
                replaceFragment(NotesListFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        replaceFragment(TaskListFragment.newInstance())
        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun goToCreateActivity(fragmentValue: String) {
        startActivity(Intent(this, CreateActivity::class.java).apply {
            putExtra(FRAGMENT_TYPE_KEY, fragmentValue)
        })
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentHolder, fragment)
            .commit()
    }

    override fun onAddButtonClicked(value: String) {
        goToCreateActivity(value)
    }

    companion object {
        const val FRAGMENT_TYPE_KEY = "f_t_k"
        const val FRAGMENT_VALUE_NOTE = "f_v_n"
        const val FRAGMENT_VALUE_TASK = "f_v_t"
    }
}
