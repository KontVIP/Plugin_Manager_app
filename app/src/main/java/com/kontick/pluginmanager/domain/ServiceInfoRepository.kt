package com.kontick.pluginmanager.domain

import com.kontick.pluginmanager.domain.model.ServiceInfo

interface ServiceInfoRepository {
    fun fetchServiceInfoList() : List<ServiceInfo>
}