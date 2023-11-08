package com.example.fragmentlistexample

import android.content.Context
import android.content.ContextWrapper
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit

@Composable
fun FragmentWrapper(text: String) {
    val fragmentManager = LocalContext.current.getFragmentManager() ?: return

    key(text) {
        val containerId = remember { View.generateViewId() }

        AndroidView(
            modifier = Modifier
                .fillMaxSize()
                .shadow(elevation = 20.dp)
                .clip(RoundedCornerShape(8.dp)),
            factory = { context ->
                fragmentManager.findFragmentById(containerId)?.view
                    ?.also { (it.parent as? ViewGroup)?.removeView(it) }
                FragmentContainerView(context).apply {
                    id = containerId

                    fragmentManager.commit {
                        val exampleFrag = ExampleFragment.newInstance(text)
                        replace(containerId, exampleFrag)
                    }
                }
            },
        )
    }
}

@Composable
private fun Context.getFragmentManager(): FragmentManager? {
    val activity = when (this) {
        is FragmentActivity -> this
        is ContextWrapper -> this.baseContext as? FragmentActivity
        else -> null
    }

    return activity?.supportFragmentManager
}