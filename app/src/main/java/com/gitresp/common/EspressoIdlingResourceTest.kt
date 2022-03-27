package com.gitresp.common

import androidx.test.espresso.IdlingResource


object EspressoIdlingResourceTest {
    var countingIdlingResource: GitRepoResourceTest? =
        GitRepoResourceTest()

    fun increment() {
        if (countingIdlingResource != null) countingIdlingResource!!.increment()
    }

    fun decrement() {
        if (countingIdlingResource != null) countingIdlingResource!!.decrement()
    }

    val idlingResource: IdlingResource?
        get() = countingIdlingResource
}
