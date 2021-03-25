package com.cobamvvm.project

import android.app.Application
import com.cobamvvm.project.dependency.apiDataSourceDependency
import com.cobamvvm.project.dependency.repositoryDependency
import com.cobamvvm.project.dependency.viewModelDependency
import org.koin.android.ext.android.startKoin

class App : Application(){

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(
            apiDataSourceDependency,
            repositoryDependency,
            viewModelDependency

        ))
    }
}