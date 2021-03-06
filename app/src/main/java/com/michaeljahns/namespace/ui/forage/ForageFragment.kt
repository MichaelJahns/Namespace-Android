package com.michaeljahns.namespace.ui.forage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.michaeljahns.namespace.R
import com.michaeljahns.namespace.databinding.FragmentForageBinding
import com.michaeljahns.namespace.repository.forage.Forage
import com.michaeljahns.namespace.util.InjectorUtils
import com.michaeljahns.namespace.viewmodel.forage.ForageViewModel
import com.michaeljahns.namespace.viewmodel.forage.ForageViewModelFactory


class ForageFragment : Fragment(R.layout.fragment_forage) {
    private lateinit var binding: FragmentForageBinding
    private val factoryView: ForageViewModelFactory = InjectorUtils.provideForageModelFactory()
    private lateinit var forageViewModel: ForageViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentForageBinding.inflate(layoutInflater, container, false)
        initUI()
        return binding.root
    }

    private fun initUI() {
        forageViewModel = ViewModelProvider(this, factoryView)
                .get(ForageViewModel::class.java)
        forageViewModel.getForages().observe(viewLifecycleOwner, Observer { forages ->
            startViewPager(forages)
        })
    }

    private fun startViewPager(forageList: List<Forage>) {
        binding.vp2Forage.adapter = ForagePageAdapter(forageList)
        binding.vp2Forage.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.indicatorForage.setViewPager(binding.vp2Forage)
    }
}