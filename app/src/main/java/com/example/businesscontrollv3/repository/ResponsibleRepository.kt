package com.example.businesscontrollv3.repository

import androidx.annotation.WorkerThread
import com.example.businesscontrollv3.infra.database.ResponsibleDAO
import com.example.businesscontrollv3.model.Responsible

class ResponsibleRepository (private val responsibleDAO: ResponsibleDAO){

    val allResponsibles = responsibleDAO.getAllResponsibles()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
            suspend fun save(responsible: Responsible){
                responsibleDAO.save(responsible)
            }
}