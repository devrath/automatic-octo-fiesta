package com.example.code.exampleone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.code.R
import com.example.code.exampleone.screens.images.ImagesFragment
import com.example.code.exampleone.screens.lookup.LookupFragment
import kotlinx.android.synthetic.main.fragment_example_one.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ExampleOneFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_example_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val images = ImagesFragment()
        activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.content, images)?.commit()
        nav_view.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.images -> {
                    activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.content, images)?.commit()
                }
                R.id.lookup -> {
                    val lookup = LookupFragment()
                    activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.content, lookup)?.commit()
                }
            }
            true
        }
    }
}