package com.kingpowerclick.poc_example.viewmodel

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
 class WishlistViewModel
    @Inject
    constructor(
    ) : BaseViewModel<WishlistViewModel.ViewState, WishlistViewModel.ViewEffect, WishlistViewModel.Action>(
            ViewState(),
        ) {
        override fun onReduceState(viewAction: Action): ViewState =
            when (viewAction) {
                is Action.Loading ->
                    state.copy(
                        isLoading = true,
                    )
                is Action.Loaded ->
                    state.copy(
                        isLoading = false,
                    )
            }

        fun deleteWishlist(sku: String) {
        }

        data class ViewState(
            val isLoading: Boolean = false,
        ) : BaseViewState

        data class ViewEffect(
            val error: String? = null,
            val addItemToCartSuccess: Boolean = false,
            val deleteWishlistSuccess: Boolean = false,
        ) : BaseViewEffect

    sealed class Action : BaseAction {
            object Loading : Action()

            object Loaded : Action()
        }

        companion object {
            const val PREFETCH_DISTANCE = 2
        }
    }
