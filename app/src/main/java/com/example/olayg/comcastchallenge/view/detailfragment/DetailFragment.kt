package com.example.olayg.comcastchallenge.view.detailfragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.olayg.comcastchallenge.Constants.Bundles.BUNDLE_RELATED_TOPIC
import com.example.olayg.comcastchallenge.R
import com.example.olayg.comcastchallenge.loadImg
import com.example.olayg.comcastchallenge.models.RelatedTopic
import com.example.olayg.comcastchallenge.view.mainactivity.MainActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar.*
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment() {

    private lateinit var relatedTopic: RelatedTopic

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        arguments?.apply {
            relatedTopic = this.getParcelable(BUNDLE_RELATED_TOPIC)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData(relatedTopic)
    }

    override fun onResume() {
        super.onResume()
        (context as MainActivity).apply {
            toolbar_text.text = getString(R.string.app_name)
            toolbar_back.visibility = View.VISIBLE
            toolbar_search_text.visibility = View.GONE
            toolbar_back.setOnClickListener {
                it.visibility = View.GONE
                frame_detail.visibility = View.GONE
                toolbar_search_text.visibility = View.VISIBLE
                activity?.onBackPressed() }
        }
    }

    private fun setData(relatedTopic: RelatedTopic) {
        val parsedString = relatedTopic.text?.split("-")
        tv_title.text = parsedString?.get(0) ?: "Title"
        if (relatedTopic.icon?.uRL.isNullOrEmpty())
            iv_image.loadImg(null)
        else
            iv_image.loadImg(relatedTopic.icon?.uRL)

        tv_details.text = parsedString?.get(1) ?: "Details"

    }

    companion object {
        fun newInstance(relatedTopic: RelatedTopic): DetailFragment {
            val b = Bundle().apply {
                putParcelable(BUNDLE_RELATED_TOPIC,relatedTopic )
            }
            return DetailFragment().apply { arguments = b }
        }
    }
}
