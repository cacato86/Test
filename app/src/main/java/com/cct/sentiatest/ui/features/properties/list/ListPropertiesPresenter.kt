package com.cct.sentiatest.ui.features.properties.list

import com.cct.sentiatest.ui.features.properties.list.ListPropertiesAction.LoadProperties
import com.cct.sentiatest.ui.features.properties.list.ListPropertiesState.RenderProperties
import com.cct.sentiatest.ui.features.properties.list.item.PropertyVM
import com.rise.bgo.ui.features.commons.BasePresenter
import com.rise.bgo.ui.features.commons.BaseView
import javax.inject.Inject

class ListPropertiesPresenter @Inject constructor()
    : BasePresenter<ListPropertiesState, ListPropertiesAction>() {

    override fun init(view: BaseView<ListPropertiesState>) {
        super.init(view)
        loadProperties()
    }

    override fun reduce(action: ListPropertiesAction) {
        when (action) {
            is LoadProperties -> loadProperties()
        }
    }

    private fun loadProperties() {

        //FAKE DATA
        val list = listOf(
                PropertyVM("Eastern Suburbs", "3", "2", "1",
                        "Family Home With Potential In The Heart Of Bondi Presenting an abundance of potential in the heart of Bondi, this dual layout home set over 440sqm is available to the market for the first time in over 34 years. While perfectly liveable as i...",
                        "https://storage.googleapis.com/idx-photos-gs.ihouseprd.com/TX-NTREIS/13807656/org/003.jpg",
                        "20000 AUS", "Mattew red", "https://www.shareicon.net/data/128x128/2016/01/12/702155_users_512x512.png",
                        "79 Anglesea Street, Bondi, NSW", true),
                PropertyVM("Eastern Suburbs", "3", "2", "1",
                        "Family Home With Potential In The Heart Of Bondi Presenting an abundance of potential in the heart of Bondi, this dual layout home set over 440sqm is available to the market for the first time in over 34 years. While perfectly liveable as i...",
                        "https://storage.googleapis.com/idx-photos-gs.ihouseprd.com/TX-NTREIS/13807656/org/003.jpg",
                        "20000 AUS", "Mattew red", "https://www.shareicon.net/data/128x128/2016/01/12/702155_users_512x512.png",
                        "79 Anglesea Street, Bondi, NSW", false),
                PropertyVM("Eastern Suburbs", "3", "2", "1",
                        "Family Home With Potential In The Heart Of Bondi Presenting an abundance of potential in the heart of Bondi, this dual layout home set over 440sqm is available to the market for the first time in over 34 years. While perfectly liveable as i...",
                        "https://storage.googleapis.com/idx-photos-gs.ihouseprd.com/TX-NTREIS/13807656/org/003.jpg",
                        "20000 AUS", "Mattew red", "https://www.shareicon.net/data/128x128/2016/01/12/702155_users_512x512.png",
                        "79 Anglesea Street, Bondi, NSW", true))
        render(RenderProperties(list))
    }
}