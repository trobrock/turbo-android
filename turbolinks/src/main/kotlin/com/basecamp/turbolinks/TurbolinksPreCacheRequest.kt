package com.basecamp.turbolinks

import android.net.Uri
import android.webkit.CookieManager
import android.webkit.WebResourceRequest

internal class TurbolinksPreCacheRequest(val url: String, val userAgent: String) : WebResourceRequest {
    private val cookieManager = CookieManager.getInstance()

    override fun getUrl(): Uri {
        return Uri.parse(url)
    }

    override fun isRedirect(): Boolean {
        return false
    }

    override fun getMethod(): String {
        return "GET"
    }

    override fun getRequestHeaders(): Map<String, String> {
        return mapOf(
            "Cookie" to cookieManager.getCookie(url),
            "User-Agent" to userAgent
        )
    }

    override fun hasGesture(): Boolean {
        return false
    }

    override fun isForMainFrame(): Boolean {
        return true
    }
}
