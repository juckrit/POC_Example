package com.kingpowerclick.poc_example.viewmodel

import androidx.lifecycle.ViewModel
import com.kingpowerclick.poc_example.BuildConfig
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.properties.Delegates

abstract class BaseViewModel<ViewState : BaseViewState, ViewEffect : BaseViewEffect, ViewAction : BaseAction>(
    initialState: ViewState,
) : ViewModel() {
    private val stateMutableLiveData = MutableStateFlow(initialState)
    private val effectSingleLiveData = SingleLiveEvent<ViewEffect>()

    val stateLiveData: StateFlow<ViewState>
        get() = stateMutableLiveData

    val viewEffect: SingleLiveEvent<ViewEffect> = effectSingleLiveData

    private var stateTimeTravelDebugger: StateTimeTravelDebugger? = null

    init {
        if (BuildConfig.DEBUG) {
            stateTimeTravelDebugger = StateTimeTravelDebugger(this::class.java.simpleName)
        }
    }

    // Delegate will handle state event deduplication
    // (multiple states of the same type holding the same data will not be dispatched multiple times to LiveData stream)
    protected var state by Delegates.observable(initialState) { _, old, new ->
        stateMutableLiveData.value = new

        if (new != old) {
            stateTimeTravelDebugger?.apply {
                addStateTransition(old, new)
                logLast()
            }
        }
    }

    fun sendAction(viewAction: ViewAction) {
        stateTimeTravelDebugger?.addAction(viewAction)
        state = onReduceState(viewAction)
    }

    fun sendEffect(viewEffect: ViewEffect) {
        effectSingleLiveData.invoke(viewEffect)
    }

    protected abstract fun onReduceState(viewAction: ViewAction): ViewState
}
