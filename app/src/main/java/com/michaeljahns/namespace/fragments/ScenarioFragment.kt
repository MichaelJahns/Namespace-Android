package com.michaeljahns.namespace.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.viewpager2.widget.ViewPager2
import com.michaeljahns.namespace.R
import com.michaeljahns.namespace.ScenarioPageAdapter
import com.michaeljahns.namespace.databinding.FragmentScenarioBinding
import com.michaeljahns.namespace.grammy.Scenario
import com.michaeljahns.namespace.models.ScenarioModel

class ScenarioFragment : Fragment(R.layout.fragment_scenario) {
    private lateinit var binding: FragmentScenarioBinding
    private var scenarioList = mutableListOf<Scenario>()
    private var _scenarioList = MutableLiveData<List<Scenario>>()
    private val model: ScenarioModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentScenarioBinding.inflate(layoutInflater, container, false)
        resetLists()
        startViewPager()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        resetLists()
    }

    private fun startViewPager() {
        binding.vp2Scenario.adapter = ScenarioPageAdapter(scenarioList)
        binding.vp2Scenario.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.indicatorScenario.setViewPager(binding.vp2Scenario)
    }

    private fun resetLists() {
        this.scenarioList.clear()
        this.scenarioList = model.getScenarios()
        this._scenarioList = model._getScenarios()
    }
}