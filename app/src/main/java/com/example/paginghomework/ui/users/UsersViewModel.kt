package com.example.paginghomework.ui.users

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.paginghomework.model.User
import com.example.paginghomework.network.RetrofitClient
import com.example.paginghomework.network.RetrofitClient.getUsersInfo
import com.example.paginghomework.pagingsource.UsersPagingSource
import com.example.paginghomework.utils.ResponseHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class UsersViewModel : ViewModel() {

    @SuppressLint("CheckResult")
    fun loadUsers(): Flow<PagingData<User.Data>> {
        return Pager(
            config = PagingConfig(1),
            pagingSourceFactory = { UsersPagingSource(getUsersInfo) }).flow.cachedIn(viewModelScope)
    }
}

