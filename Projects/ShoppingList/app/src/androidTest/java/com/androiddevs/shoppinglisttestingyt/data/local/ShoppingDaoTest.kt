package com.androiddevs.shoppinglisttestingyt.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.androiddevs.shoppinglisttestingyt.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class ShoppingDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database : ShoppingItemDatabase
    private lateinit var dao: ShoppingDao

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
                ApplicationProvider.getApplicationContext(),
                ShoppingItemDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.shoppingDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insertShoppingItem() = runBlockingTest {
        // ARRANGE
        val shoppingItem = ShoppingItem("name", 1, 1f, "url", id = 1)

        // SUT
        dao.insertShoppingItem(shoppingItem)

        // ACT
        val allShoppingItems = dao.observeAllShoppingItems().getOrAwaitValue()

        // ASSERT
        assertThat(allShoppingItems).contains(shoppingItem)
    }


    @Test
    fun deleteShoppingItem() = runBlockingTest {
        // ARRANGE
        val shoppingItem = ShoppingItem("name", 1, 1f, "url", id = 1)
        // Add the item
        dao.insertShoppingItem(shoppingItem)

        // SUT
        dao.deleteShoppingItem(shoppingItem)

        // ACT
        val allShoppingItems = dao.observeAllShoppingItems().getOrAwaitValue()

        // ASSERT
        assertThat(allShoppingItems).isEmpty()

    }


    @Test
    fun observeTotalPriceSum() = runBlockingTest {
        // ARRANGE
        val shoppingItem1 = ShoppingItem("name", 2, 10f, "url", id = 1)
        val shoppingItem2 = ShoppingItem("name", 4, 5.5f, "url", id = 2)
        val shoppingItem3 = ShoppingItem("name", 0, 100f, "url", id = 3)
        // Add the items
        dao.insertShoppingItem(shoppingItem1)
        dao.insertShoppingItem(shoppingItem2)
        dao.insertShoppingItem(shoppingItem3)

        // ACT
        val totalPriceSum = dao.observeTotalPrice().getOrAwaitValue()

        // ASSERT
        assertThat(totalPriceSum).isEqualTo(2 * 10f + 4 * 5.5f)
    }

}













