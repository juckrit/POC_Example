package com.kingpowerclick.poc_example.localTest.app.viewmodel

import com.kingpowerclick.poc_example.localTest.BaseTest
import com.kingpowerclick.poc_example.viewmodel.WishlistViewModel
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class WishlistViewModelTest : BaseTest() {
    lateinit var wishlistViewModel: WishlistViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        initMainViewModel()
    }

    @After
    fun tearDown() {
        clearAllMocks()
        unmockkAll()
        clearConstructorMockk()
        unmockkConstructor()
    }

    private fun initMainViewModel() {
        wishlistViewModel =
            spyk(
                WishlistViewModel(
                ),
            )
    }

    @Test
    fun `check consent when not login should not show update consent dialog`() {
        wishlistViewModel.deleteWishlist("asdf")
    }
}
