package com.cct.sentiatest.ui.features.properties.list

import android.os.Bundle
import android.support.v4.app.Fragment
import com.cct.sentiatest.domain.usecases.ObtainPropertiesUseCase
import com.cct.sentiatest.ui.commons.Router
import com.cct.sentiatest.ui.features.properties.ListPropertiesMapper
import com.cct.sentiatest.ui.features.properties.list.ListPropertiesAction.LoadProperties
import com.cct.sentiatest.ui.features.properties.list.ListPropertiesAction.OpenDetail
import com.cct.sentiatest.ui.features.properties.list.di.ListPropertiesModule.Companion.DETAIL_FRAGMENT
import com.cct.sentiatest.ui.features.properties.list.item.PropertyVM
import com.cct.sentiatest.ui.utils.observeOnUI
import com.cct.sentiatest.ui.utils.plusAssign
import com.rise.bgo.ui.features.commons.BasePresenter
import com.rise.bgo.ui.features.commons.BaseView
import javax.inject.Inject
import javax.inject.Named


class ListPropertiesPresenter @Inject constructor(private val obtainProperties: ObtainPropertiesUseCase,
                                                  private val mapper: ListPropertiesMapper,
                                                  private val router: Router,
                                                  @Named(DETAIL_FRAGMENT) private val detailFragment: Fragment)
    : BasePresenter<ListPropertiesState, ListPropertiesAction>() {

    companion object {
        const val FRAGMENT_ID = "id"
    }

    override fun init(view: BaseView<ListPropertiesState>) {
        super.init(view)
        loadProperties()
    }

    override fun reduce(action: ListPropertiesAction) {
        when (action) {
            is LoadProperties -> loadProperties()
            is OpenDetail -> openDetail(action.property)
        }
    }

    private fun loadProperties() {
        disposables += obtainProperties.execute()
                .observeOnUI()
                .doOnSubscribe { render(mapper.mapLoading(true)) }
                .doAfterTerminate { render(mapper.mapLoading(false)) }
                .subscribe({
                    render(mapper.mapListProperties(it))
                }, { render(mapper.mapError(it)) })
    }

    private fun openDetail(property: PropertyVM) {
        detailFragment.arguments = generateData(property.area)
        router.open(detailFragment)
    }

    private fun generateData(id: String): Bundle {
        val bundle = Bundle()
        bundle.putString(FRAGMENT_ID, id)
        return bundle
    }
}