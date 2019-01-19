package com.night.check1

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_page.view.*

class PageFragment : Fragment() {
    @LayoutRes
    internal var layoutRes: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_page, container, false)
        view.viewStub.layoutResource = layoutRes
        view.viewStub.inflate()

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = arguments
        if (args != null) {
            layoutRes = args.getInt(RES)
        }
    }

    companion object {
        const val RES = "res"

        fun newInstance(@LayoutRes res: Int): PageFragment {
            val fragment = PageFragment()
            val args = Bundle()
            args.putInt(RES, res)
            fragment.arguments = args
            return fragment
        }
    }
}
