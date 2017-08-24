package com.rukiasoft.amaristest.accountlist.ui.mainviews

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import com.rukiasoft.amaristest.R
import com.rukiasoft.amaristest.accountlist.presenters.AccountsPresenter
import com.rukiasoft.amaristest.accountlist.ui.lifecycleobservers.AccountsLifecycleObserver
import com.rukiasoft.amaristest.model.Account
import com.rukiasoft.amaristest.model.CustomLiveData
import com.rukiasoft.amaristest.utils.logger.LoggerHelper
import com.rukiasoft.newrukiapics.ui.activities.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), AccountsView {

    @Inject
    protected lateinit var presenter: AccountsPresenter

    @Inject
    protected lateinit var log: LoggerHelper

    @Inject
    protected lateinit var observer: AccountsLifecycleObserver

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_all_accounts -> {
                message.setText(R.string.title_all_accounts)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_visible_accounts -> {
                message.setText(R.string.title_visible_accounts)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    override fun setAccountsInView(accounts: List<Account>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addLifecycleObserver(observer: AccountsLifecycleObserver) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLiveAccounts(): CustomLiveData<List<Account>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
