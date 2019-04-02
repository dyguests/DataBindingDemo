package com.fanhl.databinding

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.fanhl.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        binding.user = User("张三")
        binding.task = Task()
        binding.presenter = Presenter()
    }
}

data class User(
    val firstName: String
)

class Presenter {
    private val TAG = Presenter::class.java.simpleName
    fun onSaveClick(task: Task) {
        Log.d(TAG, "onSaveClick: $task")
    }
}

class Task {

}
