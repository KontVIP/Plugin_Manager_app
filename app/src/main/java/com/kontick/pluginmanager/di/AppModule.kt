package com.kontick.pluginmanager.di

import com.kontick.pluginmanager.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<MainViewModel> {
        MainViewModel(fetchServiceListUseCase = get())
    }
}