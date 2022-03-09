package com.kontick.pluginmanager.data

import com.kontick.pluginmanager.domain.ServiceInfoRepository
import com.kontick.pluginmanager.domain.model.ServiceInfo

class BaseServiceInfoRepository(private val sourceOfServiceInfo: SourceOfServiceInfo) :
    ServiceInfoRepository {
    override fun fetchServiceInfoList(): List<ServiceInfo> = sourceOfServiceInfo.fetchServiceInfo()
}