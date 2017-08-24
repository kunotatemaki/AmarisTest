package com.rukiasoft.amaristest.accountlist.ui.mainviews

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.rukiasoft.amaristest.R
import com.rukiasoft.amaristest.accountlist.ui.lifecycleobservers.AccountsLifecycleObserver
import com.rukiasoft.amaristest.model.Account
import com.rukiasoft.amaristest.model.CustomLiveData
import com.rukiasoft.newrukiapics.ui.activities.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), AccountsView {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                message.setText(R.string.title_notifications)
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
