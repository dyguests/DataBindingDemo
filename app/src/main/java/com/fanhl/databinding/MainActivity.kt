package com.fanhl.databinding

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.annotation.RestrictTo
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import com.fanhl.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        binding.user = User("张", MutableLiveData<String>().apply {
            value = "无忌"
        })
        binding.task = Task()
        binding.presenter = object : Presenter() {
            override fun onSaveClick(task: Task) {
                super.onSaveClick(task)
                binding.user?.lastName?.value = "三丰"
            }
        }
    }
}

data class User(
    val firstName: String,
    val lastName: MutableLiveData<String>
)

open class Presenter {
    open fun onSaveClick(task: Task) {
        Log.d(TAG, "onSaveClick: $task")
    }

    companion object {
        private val TAG = Presenter::class.java.simpleName
    }
}

class Task : BaseObservable() {
    // @get:Bindable
    // var firstName: String = ""
    //     set(value) {
    //         field = value
    //         notifyPropertyChanged(BR.task)
    //     }
}

@RestrictTo(RestrictTo.Scope.LIBRARY)
@BindingMethods(
    BindingMethod(type = TextView::class, attribute = "android:paddingLeft", method = "setPaddingLeft")
)
object MyTextViewBindingAdapter {
    @BindingAdapter("android:paddingLeft")
    fun setPaddingLeft(view: TextView, padding: Int) {
        view.setPadding(padding, padding, padding, padding)
    }
}
