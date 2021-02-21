package com.michaeljahns.namespace.scenario

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ScenarioDao {
    private var scenarioList = mutableListOf<Scenario>()
    private val scenarios = MutableLiveData<List<Scenario>>()

    init {
        regenerateScenarios()
    }

    fun getScenarios() = scenarios as LiveData<List<Scenario>>

    fun clearScenarios() {
        scenarioList.clear()
    }

    private fun updateLiveData() {
        scenarios.value = scenarioList
    }

    fun regenerateScenarios() {
        clearScenarios()
        scenarioList = ScenarioFactory.getScenarios(7)
        updateLiveData()
    }
}