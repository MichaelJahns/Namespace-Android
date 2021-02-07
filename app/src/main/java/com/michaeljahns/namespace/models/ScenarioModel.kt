package com.michaeljahns.namespace.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.michaeljahns.namespace.factories.ScenarioFactory
import com.michaeljahns.namespace.grammy.Scenario

class ScenarioModel : ViewModel() {
    private var numberOfScenarios = MutableLiveData<Int>()
    private var minPawnAgeRange = MutableLiveData<Int>()
    private var maxPawnAgeRange = MutableLiveData<Int>()
    private var scenarios: MutableList<Scenario> = ScenarioFactory.getScenarios(getNumberOfScenarios())
    private lateinit var _scenarios: MutableLiveData<List<Scenario>>

    fun getNumberOfScenarios(): Int {
        return this.numberOfScenarios.value ?: 15
    }

    fun getNumberOfScenariosFloat(): Float {
        val numberOfScenarios = this.numberOfScenarios.value?.toFloat()
        return numberOfScenarios ?: 15F
    }

    fun setNumberOfScenarios(number: Int) {
        this.numberOfScenarios.value = number
    }

    fun setPawnAgeRange(minimum: Int, maximum: Int) {
        this.minPawnAgeRange.value = minimum
        this.maxPawnAgeRange.value = maximum
    }

    fun regenerateScenarios() {
        scenarios = ScenarioFactory.getScenarios(getNumberOfScenarios())
    }

    fun getScenarios(): MutableList<Scenario> {
        return this.scenarios
    }

    fun _getScenarios(): MutableLiveData<List<Scenario>> {
        return this._scenarios
    }

    fun getMinPawnAgeRange(): Float {
        val minAge = this.minPawnAgeRange.value?.toFloat()
        return minAge ?: 10F
    }

    fun getMaxPawnAgeRange(): Float {
        val maxAge = this.maxPawnAgeRange.value?.toFloat()
        return maxAge ?: 70F
    }


}


