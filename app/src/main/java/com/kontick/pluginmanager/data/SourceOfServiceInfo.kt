package com.kontick.pluginmanager.data

import android.content.Context
import android.content.pm.ApplicationInfo
import com.kontick.pluginmanager.domain.model.ServiceInfo

interface SourceOfServiceInfo {

    fun fetchServiceInfo(): List<ServiceInfo>

    class Base(private val context: Context) : SourceOfServiceInfo {
        override fun fetchServiceInfo(): List<ServiceInfo> {
            val serviceInfoList = mutableListOf<ServiceInfo>()
            for (packageInfo in context.packageManager.getInstalledApplications(0)) {
                if (isService(packageInfo)) serviceInfoList.add(
                    ServiceInfo(
                        context.packageManager.getApplicationLabel(packageInfo).toString(),
                        packageInfo.packageName.toString()
                    )
                )
            }
            return serviceInfoList
        }

        private fun isService(packageInfo: ApplicationInfo) =
            packageInfo.packageName.toString().contains("com.kontick") &&
                    !packageInfo.packageName.toString().contains("com.kontick.pluginmanager")
    }

}