package com.cct.sentiatest.ui.commons.dsl

import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.cct.sentiatest.di.module.GlideApp
import com.cct.sentiatest.di.module.GlideRequest
import com.cct.sentiatest.di.module.GlideRequests

@DslMarker
annotation class ImageViewDsl

@ImageViewDsl
class ImageLoader {
    private var imageView: ImageView? = null

    var item: Load = Load.Uri(android.net.Uri.EMPTY)
    var transform: Transform = Transform.None

    fun set(imageView: ImageView) {
        this.imageView = imageView
    }

    fun url(url: String) = Load.Url(url)

    fun circleTransform() = Transform.Circle

    fun build() {
        imageView?.let {
            with(GlideApp.with(it)) {
                with(item.load(this)) {
                    diskCacheStrategy(DiskCacheStrategy.ALL)
                    transform.apply(this)
                }
            }.into(it)
        }
    }
}

@ImageViewDsl
abstract class Request {
    open fun apply(request: GlideRequest<Drawable>): GlideRequest<Drawable> = request
}

@ImageViewDsl
sealed class Load {
    abstract fun load(glides: GlideRequests): GlideRequest<Drawable>
    class Uri(private val uri: android.net.Uri) : Load() {
        override fun load(glides: GlideRequests): GlideRequest<Drawable> = glides.load(uri)
    }

    class Url(private val url: String) : Load() {
        override fun load(glides: GlideRequests): GlideRequest<Drawable> = glides.load(url)
    }
}

@ImageViewDsl
sealed class Transform : Request() {
    object None : Transform()
    object Circle : Transform() {
        override fun apply(request: GlideRequest<Drawable>) = request.transform(CircleCrop())
    }
}

fun ImageView.dsl(setup: ImageLoader.() -> Unit) {
    with(ImageLoader()) {
        set(this@dsl)
        setup()
        build()
    }
}