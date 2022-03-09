package com.kontick.pluginmanager.domain.usecase

import com.kontick.pluginmanager.domain.ServiceInfoRepository
import com.kontick.pluginmanager.domain.model.ServiceInfo

interface FetchServiceListUseCase {

    fun invoke(): List<ServiceInfo>

    class Base(private val serviceInfoRepository: ServiceInfoRepository) : FetchServiceListUseCase {
        override fun invoke(): List<ServiceInfo> = serviceInfoRepository.fetchServiceInfoList()
    }

}