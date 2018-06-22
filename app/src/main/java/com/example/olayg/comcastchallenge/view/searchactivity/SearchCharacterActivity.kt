package com.example.olayg.comcastchallenge.view.searchactivity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.example.olayg.comcastchallenge.*
import com.example.olayg.comcastchallenge.Constants.Extras.EXTRA_RELATED_TOPIC
import com.example.olayg.comcastchallenge.models.RelatedTopic
import com.example.olayg.comcastchallenge.view.base.BaseActivity
import com.example.olayg.comcastchallenge.view.mainactivity.MainActivity
import com.example.olayg.comcastchallenge.view.mainactivity.MainActivityModule
import kotlinx.android.synthetic.main.activity_search_character.*
import kotlinx.android.synthetic.main.app_bar.*
import javax.inject.Inject

class SearchCharacterActivity : BaseActivity(), SearchCharacterContract.View {

    override var currentContext: Context = this@SearchCharacterActivity
    @Inject
    lateinit var presenter: SearchCharacterPresenter
    private var topics = mutableListOf<RelatedTopic>()
    private var searchedTopics = mutableListOf<ViewType>()
    private val rvListener = object : RecyclerClickListener.OnRecyclerClickListener {
        override fun onItemClick(view: View, position: Int) {
            setResult(Activity.RESULT_OK, Intent().apply { putExtra(EXTRA_RELATED_TOPIC, searchedTopics[position] as RelatedTopic) })
            finish()
        }

        override fun onItemLongClick(view: View, position: Int) {}
    }
    private val searchRecyclerView: RecyclerView by lazy {
        rv_search.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@SearchCharacterActivity)
            addOnItemTouchListener(RecyclerClickListener(this@SearchCharacterActivity, this, rvListener))
            addItemDecoration(DividerItemDecoration(this@SearchCharacterActivity))
            adapter = RvAdapter()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_character)
        initViews()
        setupDagger()
    }

    private fun setupDagger() {
        DaggerSearchActivityComponent.builder()
                .netComponent((applicationContext as App).getNetComponent())
                .searchActivityModule(SearchActivityModule(this@SearchCharacterActivity))
                .build().inject(this@SearchCharacterActivity)
    }

    override fun onResume() {
        super.onResume()
        presenter.getData()
        toolbar_text.text = getString(R.string.app_name)
        llSearch.visibility = View.VISIBLE
        toolbar_back.setOnClickListener { onBackPressed() }
        presenter.getData()
    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        super.onBackPressed()
    }

    private fun initViews() {
        toolbar_edt_search.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int){}
            override fun afterTextChanged(s: Editable) = performSearch(s.toString())
        })
    }

    private fun performSearch(searched: String) {
        "performSearch on $searched".log()
        if (searched.length > 1) {
            this.searchedTopics.clear()
            topics.forEach {
                if (it.text?.split("-")?.get(0)?.contains(searched, true) == true)
                    searchedTopics.add(it)
            }

            "Topics is " + topics.count().log()
            "Searched topics is " + searchedTopics.count().log()
            (searchRecyclerView.adapter as RvAdapter).updateItems(searchedTopics)
        }
    }

    override fun loadData(topics: MutableList<RelatedTopic>) {
        this.topics.clear()
        this.topics = topics
        "topics count is " + topics.count().log()
    }

    override fun showError(error: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
