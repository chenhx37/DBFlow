package com.dbflow5.rx2.query

import com.dbflow5.TestDatabase
import com.dbflow5.annotation.PrimaryKey
import com.dbflow5.annotation.Table
import com.dbflow5.reactivestreams.structure.BaseRXModel


@Table(database = TestDatabase::class, allFields = true)
class SimpleRXModel(@PrimaryKey var id: String = "") : BaseRXModel()