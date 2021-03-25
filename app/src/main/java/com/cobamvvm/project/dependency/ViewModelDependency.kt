package com.cobamvvm.project.dependency

import com.cobamvvm.project.module.viewmodel.MainViewModel
import org.koin.android.architecture.ext.viewModel
import org.koin.dsl.module.applicationContext

val viewModelDependency = applicationContext {
    viewModel { MainViewModel(get()) }
}