package com.example.nycschools.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.nycschools.data.model.SATItem
import com.example.nycschools.data.model.SchoolItem
import com.example.nycschools.data.repository.SchoolRepository
import com.example.nycschools.util.ApiCallStatus
import com.example.nycschools.util.SchedulerProvider
import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import io.reactivex.schedulers.TestScheduler
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class HomeViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule() // Forces RxJava to run on same thread

    /**
     * Mock SchoolRepository
     */
    @Mock
    private lateinit var schoolRepository: SchoolRepository

    /**
     * HomeViewModel instance
     */
    private lateinit var homeViewModel: HomeViewModel

    /**
     * SchedulerProvider instance
     */
    @Mock
    private lateinit var scheduler: SchedulerProvider

    /**
     * TestObserver instance for RxJava
     */
    private lateinit var testObserver: TestObserver<ApiCallStatus<List<SchoolItem>>>

    /**
     * TestScheduler instance for RxJava
     */
    private lateinit var testScheduler: TestScheduler

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        testObserver = TestObserver()
        testScheduler = TestScheduler()
        Mockito.`when`(scheduler.io()).thenReturn(testScheduler)
        Mockito.`when`(scheduler.ui()).thenReturn(testScheduler)
        homeViewModel = HomeViewModel(schoolRepository)
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
        Mockito.`when`(schoolRepository.getSchoolItems()).thenReturn(Observable.just(schoolItems))

        // Act
        homeViewModel.getSchoolItems(satItems)
        testScheduler.triggerActions()  // Trigger emissions

        // Assert
        assert(homeViewModel.schoolItemsList.value is ApiCallStatus.Success)
        assert((homeViewModel.schoolItemsList.value as ApiCallStatus.Success).data == schoolItems)
    }

    @After
    fun tearDown() {
        Mockito.framework().clearInlineMocks()
    }
}
