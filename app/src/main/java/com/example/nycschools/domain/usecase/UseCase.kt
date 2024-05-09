package com.example.nycschools.domain.usecase

import com.example.nycschools.data.model.SATItem
import com.example.nycschools.data.model.SchoolItem

/**
 * UseCase class
 * */
class UseCase {
    /**
     * function to filter the school items
     *
     * @param schoolItems - list of [SchoolItem]
     * @param satItems - list of [SATItem]
     * @return list of [SchoolItem]
     * */
    fun filterSchoolItems(
        schoolItems: List<SchoolItem>,
        satItems: List<SATItem>,
    ): List<SchoolItem> {
        return schoolItems.filter { schoolItem ->
            satItems.any { satItem ->
                schoolItem.dbn == satItem.dbn
            }
        }
    }

    /**
     * function to get the SAT item
     *
     * @param satItems - list of [SATItem]
     * @param uniqueSchoolNumber - [String]
     * @return [SATItem]
     * */
    fun getSatItem(satItems: List<SATItem>, uniqueSchoolNumber: String): SATItem? {
        return try {
            satItems.first { it.dbn == uniqueSchoolNumber }
        } catch (e: NoSuchElementException) {
            null
        }
    }
}