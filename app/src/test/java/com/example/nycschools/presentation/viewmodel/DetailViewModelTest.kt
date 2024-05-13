package com.example.nycschools.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.nycschools.data.model.SATItem
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

class DetailViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule() // Forces RxJava to run on same thread

    /**
     * Mock SchoolRepository
     */
    @Mock
    private lateinit var schoolRepository: SchoolRepository

    /**
     * DetailViewModel instance
     */
    private lateinit var detailViewModel: DetailViewModel

    /**
     * SchedulerProvider instance
     */
    @Mock
    private lateinit var scheduler: SchedulerProvider

    /**
     * TestObserver instance for RxJava
     */
    private lateinit var testObserver: TestObserver<ApiCallStatus<List<SATItem>>>

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
        detailViewModel = DetailViewModel(schoolRepository)
    }

    @Test
    fun testGetSATItemsSuccess() {
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
        Mockito.`when`(schoolRepository.getSATItems()).thenReturn(Observable.just(satItems))

        // Act
        detailViewModel.getSATItems()
        testScheduler.triggerActions()  // Trigger emissions

        // Assert
        assert(detailViewModel.satItemsList.value is ApiCallStatus.Success)
        assert((detailViewModel.satItemsList.value as ApiCallStatus.Success).data == satItems)
    }

    @Test
    fun testGetSATItemsError() {
        // Arrange
        Mockito.`when`(schoolRepository.getSATItems()).thenReturn(Observable.error(Exception("Error")))

        // Act
        detailViewModel.getSATItems()
        testScheduler.triggerActions()  // Trigger emissions

        // Assert
        assert(detailViewModel.satItemsList.value is ApiCallStatus.Error)
        assert((detailViewModel.satItemsList.value as ApiCallStatus.Error).exception.message == "Error")
    }

    @After
    fun tearDown() {
        Mockito.framework().clearInlineMocks()
    }
}
