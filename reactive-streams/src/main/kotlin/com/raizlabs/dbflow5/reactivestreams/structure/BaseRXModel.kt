package com.dbflow5.reactivestreams.structure

import com.dbflow5.annotation.ColumnIgnore
import com.dbflow5.config.FlowManager
import com.dbflow5.structure.BaseModel
import com.dbflow5.structure.InvalidDBConfiguration
import com.dbflow5.adapter.ModelAdapter
import com.dbflow5.database.DatabaseWrapper

import io.reactivex.Completable
import io.reactivex.Single

/**
 * Description: Similar to [BaseModel] with RX constructs. Extend this for convenience methods.
 */
open class BaseRXModel {

    /**
     * @return The associated [ModelAdapter]. The [FlowManager]
     * may throw a [InvalidDBConfiguration] for this call if this class
     * is not associated with a table, so be careful when using this method.
     */
    @delegate:ColumnIgnore
    @delegate:Transient
    private val rxModelAdapter: RXModelAdapter<BaseRXModel> by lazy { RXModelAdapter(javaClass) }

    fun DatabaseWrapper.save(): Single<Boolean> =
            rxModelAdapter.save(this@BaseRXModel, this)

    fun DatabaseWrapper.load(): Completable =
            rxModelAdapter.load(this@BaseRXModel, this)

    fun DatabaseWrapper.delete(): Single<Boolean> =
            rxModelAdapter.delete(this@BaseRXModel, this)

    fun DatabaseWrapper.update(): Single<Boolean> =
            rxModelAdapter.update(this@BaseRXModel, this)

    fun DatabaseWrapper.insert(): Single<Long> =
            rxModelAdapter.insert(this@BaseRXModel, this)

    fun DatabaseWrapper.exists(): Single<Boolean> =
            rxModelAdapter.exists(this@BaseRXModel, this)
}
