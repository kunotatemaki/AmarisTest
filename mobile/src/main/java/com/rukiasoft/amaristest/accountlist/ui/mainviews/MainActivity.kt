package com.rukiasoft.amaristest.accountlist.ui.mainviews

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import com.rukiasoft.amaristest.AmarisApplication
import com.rukiasoft.amaristest.R
import com.rukiasoft.amaristest.accountlist.presenters.AccountsPresenter
import com.rukiasoft.amaristest.accountlist.ui.adapters.AccountsAdapter
import com.rukiasoft.amaristest.accountlist.ui.lifecycleobservers.AccountsLifecycleObserver
import com.rukiasoft.amaristest.accountlist.ui.viewmodels.AccountsViewModel
import com.rukiasoft.amaristest.dependencyInjection.modules.AccountsModule
import com.rukiasoft.amaristest.model.Account
import com.rukiasoft.amaristest.model.CustomLiveData
import com.rukiasoft.amaristest.utils.logger.LoggerHelper
import com.rukiasoft.newrukiapics.ui.activities.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import android.arch.lifecycle.LifecycleObserver
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import com.rukiasoft.amaristest.databinding.ActivityMainBinding
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager




class MainActivity : BaseActivity(), AccountsView {

    @Inject
    protected lateinit var presenter: AccountsPresenter

    @Inject
    protected lateinit var log: LoggerHelper

    @Inject
    protected lateinit var observer: AccountsLifecycleObserver

    @Inject
    protected lateinit var adapter: AccountsAdapter

    private lateinit var mRecyclerView: RecyclerView

    private lateinit var mBinding: ActivityMainBinding

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_all_accounts -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_visible_accounts -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //inject everything
        (application as AmarisApplication).mComponent.getAccountsSubcomponent(AccountsModule(this)).inject(this)

        //binding
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        log.d(this, "oncreate activity")

        //set the mAdapter for the recycler view
        mRecyclerView = mBinding.accountsRecyclerView

        // use a linear layout manager
        val mLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mRecyclerView.layoutManager = mLayoutManager
        mRecyclerView.adapter = adapter
        //add a divider decorator
        val dividerItemDecoration = DividerItemDecoration(mRecyclerView.context,
                DividerItemDecoration.VERTICAL)
        mRecyclerView.addItemDecoration(dividerItemDecoration)

    }

    override fun setAccountsInView(accounts: List<Account>) {
        log.d(this, "pongo las cuentas en la vista")
        adapter.accounts.clear()
        adapter.accounts.addAll(accounts)
        adapter.notifyDataSetChanged()
    }

    override fun addLifecycleObserver(observer: AccountsLifecycleObserver) {
        if (observer is LifecycleObserver) {
            lifecycle.addObserver(observer as LifecycleObserver)
        }
    }

    override fun getLiveAccounts(): CustomLiveData<MutableList<Account>> {
        return ViewModelProviders.of(this).get(AccountsViewModel::class.java).listOfAccounts
    }
}
