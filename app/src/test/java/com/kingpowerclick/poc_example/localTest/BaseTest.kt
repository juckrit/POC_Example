package com.kingpowerclick.poc_example.localTest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
abstract class BaseTest {
    @get:Rule
    val archRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutineScope = OldMainCoroutineScopeRule()
}
