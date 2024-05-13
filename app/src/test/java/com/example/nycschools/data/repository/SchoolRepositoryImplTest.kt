package com.example.nycschools.data.repository

import com.example.nycschools.data.model.SATItem
import com.example.nycschools.data.model.SchoolItem
import com.example.nycschools.data.remote.ApiService
import com.example.nycschools.util.TestSchedulerProvider
import io.reactivex.Observable
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class SchoolRepositoryImplTest {
    /**
     * Mock ApiService
     */
    @Mock
    private lateinit var apiService: ApiService

    /**
     * SchoolRepositoryImpl instance
     */
    private lateinit var schoolRepositoryImpl: SchoolRepositoryImpl

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        schoolRepositoryImpl = SchoolRepositoryImpl(apiService, TestSchedulerProvider())
    }

    @Test
    fun testGetSchoolItems() {
        // Arrange
        val schoolItems = listOf(
            SchoolItem(
                "BNG",
                "12345",
                "00000",
                "123 Main St",
                "New York School",
                "NY",
                "abc.com",
                zip = null,
            ),
            SchoolItem(
                "BGP",
                "23456",
                "11111",
                "123 Main St",
                "New York School",
                "NY",
                "xyz.com",
                zip = null,
            ),
            SchoolItem(
                "XYZ",
                "34567",
                "22222",
                "123 Main St",
                "New York School",
                "NY",
                "mno.com",
                zip = null,
            ),
        )
        Mockito.`when`(apiService.getSchoolItems()).thenReturn(Observable.just(schoolItems))

        // Act
        val testObserver = schoolRepositoryImpl.getSchoolItems().test()

        // Assert
        testObserver.assertNoErrors()
        testObserver.assertValue(schoolItems)
    }

    @Test
    fun testGetSATItems() {
        // Arrange
        val satItems = listOf(
            SATItem(
                "12345",
                "100",
                "75",
                "50",
                "85",
                "New York School"
            ),
            SATItem(
                "23456",
                "150",
                "75",
                "50",
                "85",
                "New York School"
            ),
        )
        Mockito.`when`(apiService.getSATItems()).thenReturn(Observable.just(satItems))

        // Act
        val testObserver = schoolRepositoryImpl.getSATItems().test()

        // Assert
        testObserver.assertNoErrors()
        testObserver.assertValue(satItems)
    }

    @After
    fun tearDown() {
        Mockito.framework().clearInlineMocks()
    }
}
