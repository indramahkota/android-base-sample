package com.indramahkota.feature_dynamic

import androidx.lifecycle.ViewModel
import com.indramahkota.domain.SampleRepository
import javax.inject.Inject

class DynamicFeatureViewModel @Inject constructor(private val repository: SampleRepository) : ViewModel() {
    fun getMessage() = repository.getMessage()
}