package com.example.nycschools.domain.usecase

import com.example.nycschools.data.model.SATItem
import com.example.nycschools.data.model.SchoolItem
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Test

class UseCaseTest {
    /** UseCase instance */
    private val useCase = UseCase()

    @Test
    fun testFilterSchoolItems() {
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
                zip = null
            ),
            SchoolItem(
                "BGP",
                "23456",
                "11111",
                "123 Main St",
                "New York School",
                "NY",
                "xyz.com",
                zip = null
            ),
            SchoolItem(
                "XYZ",
                "34567",
                "22222",
                "123 Main St",
                "New York School",
                "NY",
                "mno.com",
                zip = null
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

        // Act
        val result = useCase.filterSchoolItems(schoolItems, satItems)

        // Assert
        assertEquals(2, result.size)
        assertEquals("12345", result[0].dbn)
        assertEquals("23456", result[1].dbn)
    }

    @Test
    fun testGetSatItem() {
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

        // Act
        val result = useCase.getSatItem(satItems, "23456")

        // Assert
        assertNotNull(result)
        assertEquals("23456", result?.dbn)
    }
}
