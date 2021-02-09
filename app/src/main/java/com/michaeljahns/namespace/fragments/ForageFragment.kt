package com.michaeljahns.namespace.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.viewpager2.widget.ViewPager2
import com.michaeljahns.namespace.ForagePageAdapter
import com.michaeljahns.namespace.R
import com.michaeljahns.namespace.databinding.FragmentForageBinding
import com.michaeljahns.namespace.grammy.Forage
import com.michaeljahns.namespace.models.ForageModel


class ForageFragment : Fragment(R.layout.fragment_forage) {
    private lateinit var binding: FragmentForageBinding
    private lateinit var forageList: MutableLiveData<MutableList<Forage>>
    private val model: ForageModel by viewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentForageBinding.inflate(inflater, container, false)
        forageList = model.forages
        startViewPager()
        return binding.root
    }

    private fun startViewPager() {
        binding.vp2Forage.adapter = ForagePageAdapter(forageList)
        binding.vp2Forage.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }


}