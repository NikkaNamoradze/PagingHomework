package com.example.paginghomework.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.paginghomework.model.User
import com.example.paginghomework.network.RetrofitClient

class UsersPagingSource(private val api: RetrofitClient.UserInfo) : PagingSource<Int, User.Data>() {
    override fun getRefreshKey(state: PagingState<Int, User.Data>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User.Data> {

        val page = params.key ?: FIRST_PAGE_INDEX


        return try {
            val response = api.getUsers(page)
            val body = response.body()!!.userData

            LoadResult.Page(
                data = body,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (body.isEmpty()) null else page + 1
            )

        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    }

    companion object {
        const val FIRST_PAGE_INDEX = 1
    }

}