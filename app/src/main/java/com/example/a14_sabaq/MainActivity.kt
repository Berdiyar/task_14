package com.example.a14_sabaq

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var b:  Int = 1
    val models: MutableList<User> = mutableListOf()
    val adapter: Adapter = Adapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycleView.adapter = adapter
        recycleView.layoutManager = GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false)
        recycleView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        setData(1)
    }

    fun setData(manis: Int){
        for(i in 0 until manis){
            val model: User = User()
            model.title = "Title $b"
            model.description = "Description $b"
            model.idnomer = b
            models.add(model)
            b+=1
        }
        adapter.setData(models)
    }
    fun onClick(idnomeri: Int) {
        var s: Int = idnomeri
        setData(s)
    }

}
