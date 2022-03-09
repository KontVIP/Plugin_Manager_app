package com.kontick.pluginmanager.di

import com.kontick.pluginmanager.domain.usecase.FetchServiceListUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<FetchServiceListUseCase> {
        FetchServiceListUseCase.Base(serviceInfoRepository = get())
    }

}