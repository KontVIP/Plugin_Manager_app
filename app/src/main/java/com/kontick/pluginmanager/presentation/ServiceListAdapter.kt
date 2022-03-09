package com.kontick.pluginmanager.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.appcompat.widget.SwitchCompat
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kontick.pluginmanager.R
import com.kontick.pluginmanager.domain.model.ServiceInfo


class ServiceListAdapter(private val context: Context, serviceList: List<ServiceInfo>) :
    RecyclerView.Adapter<ServiceListAdapter.ViewHolder>() {
    private val mServiceList: List<ServiceInfo> = serviceList
    private lateinit var itemSwitchListener : ItemSwitchListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.plugin_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val serviceLabel = mServiceList[position].appName
        holder.itemTextView.text = serviceLabel
    }

    override fun getItemCount() = mServiceList.size

    fun setSwitchListener(itemSwitchListener : ItemSwitchListener) {
        this.itemSwitchListener = itemSwitchListener
    }

    interface ItemSwitchListener {
        fun onSwitchListener(view: View, label: String, isChecked : Boolean, packageName: String)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        CompoundButton.OnCheckedChangeListener {
        val itemTextView: TextView = itemView.findViewById(R.id.plugin_name_text_view)
        private val itemSwitch: SwitchCompat = itemView.findViewById(R.id.plugin_switch)

        init {
            itemSwitch.setOnCheckedChangeListener(this)
        }

        override fun onCheckedChanged(compoundButton: CompoundButton?, p1: Boolean) {
            if (compoundButton != null)
                itemSwitchListener.onSwitchListener(compoundButton, mServiceList[position].appName, p1, mServiceList[position].packageName)
        }
    }
}