package com.kontick.pluginmanager.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kontick.pluginmanager.domain.usecase.FetchServiceListUseCase
import com.kontick.pluginmanager.domain.model.ServiceInfo

class MainViewModel(private val fetchServiceListUseCase: FetchServiceListUseCase) : ViewModel() {

    private var _serviceListLive = MutableLiveData<List<ServiceInfo>>()
    var serviceListLive: LiveData<List<ServiceInfo>> = _serviceListLive

    init {
        fetchServiceList()
    }

    private fun fetchServiceList() {
        _serviceListLive.value = fetchServiceListUseCase.invoke()
    }

}