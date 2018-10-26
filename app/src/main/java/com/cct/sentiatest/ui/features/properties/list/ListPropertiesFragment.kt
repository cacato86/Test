package com.cct.sentiatest.ui.features.properties.list

import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cct.sentiatest.R
import com.cct.sentiatest.SentiaApp.Companion.component
import com.cct.sentiatest.ui.features.properties.list.ListPropertiesAction.OpenDetail
import com.cct.sentiatest.ui.features.properties.list.ListPropertiesState.*
import com.cct.sentiatest.ui.features.properties.list.di.ListPropertiesModule
import com.cct.sentiatest.ui.features.properties.list.item.PropertyVM
import com.rise.bgo.ui.features.commons.BaseView
import kotlinx.android.synthetic.main.list_properties_layout.*
import kotlinx.android.synthetic.main.loader_full_screen.*
import javax.inject.Inject

class ListPropertiesFragment : Fragment(), BaseView<ListPropertiesState> {
    @Inject
    lateinit var presenter: ListPropertiesPresenter

    private lateinit var adapter: ListPropertiesAdapter

    override fun onAttach(context: Context?) {
        //component add ListPropertiesModule() inject this
        component add ListPropertiesModule(this) inject this
        super.onAttach(context)
    }

    override fun onDetach() {
        presenter.destroy()
        super.onDetach()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.list_properties_layout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
        presenter init (this)
    }

    private fun initView() {
        adapter = ListPropertiesAdapter { presenter reduce OpenDetail(it) }
        listProperties.adapter = adapter
    }

    override fun render(state: ListPropertiesState) {
        when (state) {
            is PropertiesLoaded -> renderProperties(state.properties)
            is Loading -> renderLoader(state.loading)
            is GenericError -> renderError(state.error)
        }
    }

    private fun renderProperties(properties: List<PropertyVM>) {
        adapter.addAll(properties)
    }

    private fun renderLoader(loading: Boolean) {
        if (loading) {
            fullLoader.visibility = View.VISIBLE
        } else {
            fullLoader.visibility = View.GONE
        }
    }

    private fun renderError(error: String) {
        view?.let { Snackbar.make(it, error, Snackbar.LENGTH_SHORT).show() }
    }
}
