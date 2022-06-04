package com.indramahkota.dynamic_feature

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.indramahkota.common.base.BaseBindingFragment
import com.indramahkota.domain.SampleRepository
import com.indramahkota.dynamic_feature.databinding.FragmentDynamicFeatureBinding
import timber.log.Timber
import javax.inject.Inject

class DynamicFeatureFragment : BaseBindingFragment() {
    private var _binding: FragmentDynamicFeatureBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var repository: SampleRepository

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: DynamicFeatureViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[DynamicFeatureViewModel::class.java]
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        inject()
    }

    override fun bindFragment(inflater: LayoutInflater, container: ViewGroup?): View {
        _binding = FragmentDynamicFeatureBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun setupUI(view: View, savedInstanceState: Bundle?) {
        Timber.d("Dynamic Feature by Direct Inject: ${repository.getMessage()}")
        Timber.d("Dynamic Feature by ViewModel Inject: ${viewModel.getMessage()}")
    }

    override fun unbindFragment() {
        _binding = null
    }
}