package com.kingpowerclick.poc_example.localTest

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestWatcher
import org.junit.runner.Description

// https://life.wongnai.com/%E0%B9%80%E0%B8%82%E0%B8%B5%E0%B8%A2%E0%B8%99-test-kotlin-coroutine-%E0%B8%9A%E0%B8%99-android-%E0%B8%AD%E0%B8%A2%E0%B9%88%E0%B8%B2%E0%B8%87%E0%B9%84%E0%B8%A3%E0%B8%96%E0%B8%B6%E0%B8%87%E0%B8%88%E0%B8%B0%E0%B9%82%E0%B8%AD%E0%B9%80%E0%B8%84%E0%B8%99%E0%B8%B0-2ddf1014ddc8
class MainCoroutineScopeRule(val dispatcher: TestDispatcher) :
    TestWatcher() {
    override fun starting(description: Description?) {
        super.starting(description)
        // All injected dispatchers in a test should be TestDispatchers that share the same
        // TestScheduler (available as dispatcher.scheduler). All TestDispatchers created after
        // the Main dispatcher has been replaced will automatically share its scheduler.
        Dispatchers.setMain(dispatcher)

        // If you need to create and inject test dispatchers before this happens, create a
        // TestScheduler yourself, and pass it to all test dispatchers explicitly.
    }

    override fun finished(description: Description?) {
        super.finished(description)
        Dispatchers.resetMain()
    }
}
