package com.fanhl.databinding

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import com.fanhl.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        binding.user = User("张", ObservableField("无忌"))
        binding.task = Task()
        binding.presenter = object : Presenter() {
            override fun onSaveClick(task: Task) {
                super.onSaveClick(task)
                binding.user?.lastName?.set("三丰")
            }
        }
    }
}

data class User(
    val firstName: String,
    val lastName: ObservableField<String>
)

open class Presenter {
    private val TAG = Presenter::class.java.simpleName

    open fun onSaveClick(task: Task) {
        Log.d(TAG, "onSaveClick: $task")
    }
}

class Task {

}
