package com.rukiasoft.amaristest;

import com.rukiasoft.amaristest.accountlist.presenters.AccountsPresenterImpl;
import com.rukiasoft.amaristest.accountlist.ui.mainviews.AccountsView;
import com.rukiasoft.amaristest.model.Account;
import com.rukiasoft.amaristest.resources.ResourcesManager;
import com.rukiasoft.amaristest.utils.AmarisConstants;
import com.rukiasoft.amaristest.utils.logger.AndroidLogHelperImpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

/**
 * Created by Roll on 26/8/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class PresenterTest {

    @Mock
    AndroidLogHelperImpl log;

    @Mock
    ResourcesManager resources;

    @Mock
    AccountsView view;

    @InjectMocks
    AccountsPresenterImpl presenter;

    private List<Account> accounts;

    @Before
    public void configureData(){
        Account account1 = new Account("Account1", true);
        Account account2 = new Account("Account2", false);
        Account account3 = new Account("Account3", true);
        accounts = new ArrayList<>();
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
    }

    @Test
    public void checkIfShowAllAccounts(){
        when(view.getSelectedType()).thenReturn(AmarisConstants.Type.ALL);
        List<Account> filteredAccounts = presenter.getFilteredAccounts(accounts);
        assertTrue(filteredAccounts.size() == 3);
    }

    @Test
    public void checkIfShowOnlyVisibleAccounts(){
        when(view.getSelectedType()).thenReturn(AmarisConstants.Type.VISIBLE);
        List<Account> filteredAccounts = presenter.getFilteredAccounts(accounts);
        assertTrue(filteredAccounts.size() == 2);
    }

}
