package com.kontick.pluginmanager.di

import com.kontick.pluginmanager.data.BaseServiceInfoRepository
import com.kontick.pluginmanager.data.SourceOfServiceInfo
import com.kontick.pluginmanager.domain.ServiceInfoRepository
import org.koin.dsl.module

val dataModule = module {

    single<ServiceInfoRepository> {
        BaseServiceInfoRepository(serviceInfoSource = get())
    }

    single<SourceOfServiceInfo> {
        SourceOfServiceInfo.Base(context = get())
    }

}