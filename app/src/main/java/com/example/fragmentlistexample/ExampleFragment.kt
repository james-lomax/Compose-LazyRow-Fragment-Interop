package com.example.fragmentlistexample

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment

class ExampleFragment : Fragment() {

    companion object {
        private const val ARG_PAGE_TEXT = "page_text"

        fun newInstance(pageText: String): ExampleFragment {
            val fragment = ExampleFragment()
            val args = Bundle()
            args.putString(ARG_PAGE_TEXT, pageText)
            fragment.arguments = args
            return fragment
        }
    }

    private var pageText: String = "Empty"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            pageText = requireArguments().getString(ARG_PAGE_TEXT) ?: "Null"
        }

        Log.i("ExampleFragment", "onCreate: pageText = $pageText")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        Log.i("ExampleFragment", "onCreateView: pageText = $pageText")

        // Programmatically create a TextView
        val textView = TextView(context).apply {
            layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply {
                gravity = android.view.Gravity.CENTER
            }
            text = pageText
            textSize = 24f // Set the size of the text if you need
            // Other text view settings like text color, padding etc.
        }

        // Create a LinearLayout as the root of the fragment's layout
        val linearLayout = LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
            gravity = android.view.Gravity.CENTER
            layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            addView(textView) // Add the TextView to the LinearLayout
        }

        // Return the LinearLayout as this fragment's view
        return linearLayout
    }
}
