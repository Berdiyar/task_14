package com.example.a14_sabaq

import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var b:  Int = 1
    var d: Int = 0
    val models: MutableList<User> = mutableListOf()
    val adapter: Adapter = Adapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycleView.adapter = adapter
        recycleView.layoutManager = GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false)
        recycleView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recycleView.scrollToPosition(models.size-1)
        setData(1)
    }

    fun setData(manis: Int){
        for(i in 0 until manis){
            val model: User = User()
            if(b==d) {
                b = d + 1
                model.title = "Title $b"
                model.description = "Description $b"
                model.idnomer = b
                models.add(model)
            }
            else{
                model.title = "Title $b"
                model.description = "Description $b"
                model.idnomer = b
                models.add(model)
                b += 1
            }
        }
        adapter.setData(models)
    }
    fun minusData(idnomer: Int){
        //models.removeAt(idnomer)
        var a: Int = idnomer - 1
        models.removeAt(a)
        adapter.notifyItemRangeRemoved(a, 1)
    }
    fun onClick(idnomeri: Int) {
        var s: Int = idnomeri
        setData(s)
    }

    fun onOpButClick(view: View, idnomer: Int){
        val Opmenu = PopupMenu(this, view)
        val opmenuinflater = Opmenu.menuInflater
        opmenuinflater.inflate(R.menu.item_menu, Opmenu.menu)
        Opmenu.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.qosiw -> {
                    var a = 1
                    onClick(a)
                }
                R.id.oshiriw -> {
                    minusData(idnomer)
                    d = b
                    b-=1
                }
            }
            return@setOnMenuItemClickListener true
        }
        Opmenu.show()
    }

}
