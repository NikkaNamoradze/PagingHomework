package com.example.paginghomework.ui.users

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.paginghomework.adapter.ProgressBarAdapter
import com.example.paginghomework.adapter.UserPagingAdapter
import com.example.paginghomework.databinding.UsersFragmentBinding
import com.example.paginghomework.ui.base.BaseFragment
import kotlinx.coroutines.launch

class UsersFragment : BaseFragment<UsersFragmentBinding>(UsersFragmentBinding::inflate) {

    private val usersAdapter by lazy {
        UserPagingAdapter()
    }

    private val progressBarAdapter by lazy {
        ProgressBarAdapter()
    }

    private val viewModel: UsersViewModel by viewModels()

    override fun start() {
        setUpRecycler()
    }

    private fun setUpRecycler() {
        binding.usersRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = usersAdapter.withLoadStateFooter(progressBarAdapter)
            viewLifecycleOwner.lifecycleScope.launch {
                viewModel.loadUsers().collect {
                    usersAdapter.submitData(lifecycle, it)
                }
            }
        }
    }
}