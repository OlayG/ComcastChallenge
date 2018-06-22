package com.example.olayg.comcastchallenge.view.namelistfragment

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.view.menu.ListMenuPresenter
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.olayg.comcastchallenge.*
import com.example.olayg.comcastchallenge.models.RelatedTopic
import com.example.olayg.comcastchallenge.view.mainactivity.MainActivityPresenter
import kotlinx.android.synthetic.main.fragment_name_list.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [NameListFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [NameListFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class NameListFragment : Fragment(), NameListContract.View {

    @Inject
    lateinit var presenter: NameListPresenter
    private var listener: OnFragmentInteractionListener? = null
    private var topics = mutableListOf<RelatedTopic>()

    private val rvListener = object : RecyclerClickListener.OnRecyclerClickListener {
        override fun onItemClick(view: View, position: Int) {
            topics[position].log()
            listener?.onFragmentInteraction(topics[position])
        }

        override fun onItemLongClick(view: View, position: Int) {}
    }
    private val myRecyclerView: RecyclerView by lazy {
        rv.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            addOnItemTouchListener(RecyclerClickListener(context, this, rvListener))
            addItemDecoration(DividerItemDecoration(context))
            adapter = RvAdapter()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_name_list, container, false)

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getData()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
        DaggerNameListComponent.builder()
                .netComponent((context.applicationContext as App).getNetComponent())
                .nameListModule(NameListModule(this@NameListFragment))
                .build().inject(this@NameListFragment)
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun loadNameList(topics: MutableList<RelatedTopic>) {
        this.topics.clear()
        this.topics = topics
        (myRecyclerView.adapter as RvAdapter).addItems(topics)
    }

    private var dialog : ProgressDialog? = null

    override fun dismissProgressBar() {
        dialog?.dismiss()
        dialog = null    }

    override fun showProgressBar() {
        if (dialog == null ) {
            dialog = ProgressDialog.show(context, "Loading", "Please wait", true )
        } else {
            dialog!!.show()
        }    }

    override fun showError(error: String) {
        val errDialog = AlertDialog.Builder(context)
        errDialog.setMessage(error)
        errDialog.setCancelable(true)
        errDialog.setPositiveButton("Ok", { dialog, _ -> dialog.dismiss() })
        val alertDialog = errDialog.create()
        alertDialog.show()    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(relatedTopic: RelatedTopic)
    }
}
