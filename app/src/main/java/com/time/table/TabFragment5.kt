package com.time.table

/*
 * Created by will.spitzer on 01/06/2018.
 */

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView

class TabFragment5 : Fragment() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.tab_fragment_1, container, false)

        val webView = view.findViewById(R.id.webView) as WebView
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("https://www.trentbarton.co.uk/bus-information/live-bus-departures/?stop=15731")

        return view
    }
}
