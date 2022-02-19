package com.indramahkota.feature_dynamic.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.indramahkota.feature_dynamic.DynamicFeatureViewModel
import com.indramahkota.hiltexample.di.ViewModelFactory
import com.indramahkota.hiltexample.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.multibindings.IntoMap

@Module
@InstallIn(ViewModelComponent::class)
abstract class DynamicFeatureModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(DynamicFeatureViewModel::class)
    internal abstract fun bindDynamicFeatureViewModel(viewModel: DynamicFeatureViewModel): ViewModel
}