package com.example.olayg.comcastchallenge.view.mainactivity

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.olayg.comcastchallenge.*
import com.example.olayg.comcastchallenge.Constants.Extras.EXTRA_RELATED_TOPIC
import com.example.olayg.comcastchallenge.models.RelatedTopic
import com.example.olayg.comcastchallenge.view.base.BaseActivity
import com.example.olayg.comcastchallenge.view.detailfragment.DetailFragment
import com.example.olayg.comcastchallenge.view.namelistfragment.NameListFragment
import com.example.olayg.comcastchallenge.view.searchactivity.SearchCharacterActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainActivityContract.View, NameListFragment.OnFragmentInteractionListener{

    override var currentContext: Context = this@MainActivity

    @Inject lateinit var presenter: MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupDagger()
        frame_list.visibility = View.VISIBLE
        addFragment(R.id.frame_list, NameListFragment(), "detailfragment")

        when(BuildConfig.FLAVOR) {
            "simponsviewer" -> Toast.makeText(this@MainActivity, "simpons viewer", Toast.LENGTH_SHORT).show()
            "wireviewer" -> Toast.makeText(this@MainActivity, "wire viewer", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onResume() {
        super.onResume()
        toolbar_text.text = getString(R.string.app_name)
        toolbar_back.visibility = View.GONE
        llSearch.visibility = View.GONE
        toolbar_search_text.visibility = View.VISIBLE
        toolbar_search_text.setOnClickListener {
            "searched Clicked".toast(this@MainActivity)
            startActivityForResult(Intent(this@MainActivity, SearchCharacterActivity::class.java), RESULT_SEARCH_CHARACTERS)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RESULT_SEARCH_CHARACTERS && resultCode == Activity.RESULT_OK) {
            val searchedCharacter = data?.getParcelableExtra(EXTRA_RELATED_TOPIC) as RelatedTopic
            onFragmentInteraction(searchedCharacter)
        }
    }

    private fun setupDagger() {
        DaggerMainActivityComponent.builder()
                .netComponent((applicationContext as App).getNetComponent())
                .mainActivityModule(MainActivityModule(this@MainActivity))
                .build().inject(this)
    }

    override fun onFragmentInteraction(relatedTopic: RelatedTopic) {
        frame_detail.visibility = View.VISIBLE
        addFragment(R.id.frame_detail, DetailFragment.newInstance(relatedTopic), "detailfragment")
    }

    override fun showError(error : String) {
        val errDialog = AlertDialog.Builder(currentContext)
        errDialog.setMessage(error)
        errDialog.setCancelable(true)
        errDialog.setPositiveButton("Ok", { dialog, _ -> dialog.dismiss() })
        val alertDialog = errDialog.create()
        alertDialog.show()
    }

    companion object {
        private const val RESULT_SEARCH_CHARACTERS = 1
    }
}
