package com.kontick.pluginmanager.presentation

import android.content.ComponentName
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kontick.pluginmanager.R
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity(), ServiceListAdapter.ItemSwitchListener {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.plugin_list_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        viewModel.serviceListLive.observe(this) { serviceList ->
            val adapter = ServiceListAdapter(this, serviceList)
            adapter.setSwitchListener(this)
            recyclerView.adapter = adapter
        }
    }

    override fun onSwitchListener(view: View, label: String, isChecked: Boolean, packageName: String) {
        val serviceIntent = Intent()
        serviceIntent.component = ComponentName(packageName, "$packageName.MyService")
        if (isChecked) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                startForegroundService(serviceIntent)
             else
                 startService(serviceIntent)
        } else {
            stopService(serviceIntent)
            Toast.makeText(this, "$label stop", Toast.LENGTH_SHORT).show()
        }
    }
}