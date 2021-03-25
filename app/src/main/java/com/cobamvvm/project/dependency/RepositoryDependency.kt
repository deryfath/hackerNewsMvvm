package com.cobamvvm.project.dependency

import com.cobamvvm.project.data.DataRepository
import org.koin.dsl.module.applicationContext

val repositoryDependency = applicationContext {
    bean { DataRepository(get()) }
}