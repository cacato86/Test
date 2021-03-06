package com.cct.sentiatest.ui.features.properties.list

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cct.sentiatest.R
import com.cct.sentiatest.SentiaApp.Companion.component
import com.cct.sentiatest.ui.commons.BaseView
import com.cct.sentiatest.ui.features.properties.list.ListPropertiesAction.*
import com.cct.sentiatest.ui.features.properties.list.ListPropertiesState.*
import com.cct.sentiatest.ui.features.properties.list.item.PropertyVM
import kotlinx.android.synthetic.main.list_properties_layout.*
import kotlinx.android.synthetic.main.loader_full_screen.*
import javax.inject.Inject


class ListPropertiesFragment : Fragment(), BaseView<ListPropertiesState> {

    companion object {
        private const val LIST_STATE = "LIST_STATE"
    }

    @Inject
    lateinit var presenter: ListPropertiesPresenter

    private lateinit var adapter: ListPropertiesAdapter

    private lateinit var callback: OnItemClickedListener

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try {
            callback = activity as OnItemClickedListener
        } catch (e: ClassCastException) {
            throw ClassCastException(activity.toString() + " must implement OnItemClickedListener")
        }
        component inject this
    }

    override fun onDetach() {
        presenter.destroy()
        super.onDetach()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.list_properties_layout, container, false)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val listState = listProperties.layoutManager.onSaveInstanceState()
        outState.putParcelable(LIST_STATE, listState)
    }

    private var listState: Parcelable? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()

        presenter init (this)

        if (savedInstanceState == null) {
            presenter reduce LoadProperties
        } else {
            presenter reduce RestoreData
            listState = savedInstanceState.getParcelable(LIST_STATE) as Parcelable
        }
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
            is OpenPropertyDetail -> openDetail(state.id)
        }
    }

    private fun renderProperties(properties: List<PropertyVM>) {
        adapter.addAll(properties)
        if (listState != null) {
            listProperties.layoutManager.onRestoreInstanceState(listState)
        }
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

    private fun openDetail(id: String) {
        callback.onPropertySelected(id)
    }

    interface OnItemClickedListener {
        fun onPropertySelected(id: String)
    }
}
