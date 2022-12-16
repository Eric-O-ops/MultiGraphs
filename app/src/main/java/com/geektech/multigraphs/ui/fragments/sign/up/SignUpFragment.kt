package com.geektech.multigraphs.ui.fragments.sign.up

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.multigraphs.R
import com.geektech.multigraphs.data.locale.preferences.userdata.UserPreferencesData
import com.geektech.multigraphs.databinding.FragmentSingnUpBinding
import com.geektech.multigraphs.toastFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SignUpFragment : Fragment(R.layout.fragment_singn_up) {

    @Inject
    lateinit var userPreferencesData: UserPreferencesData
    private val binding by viewBinding(FragmentSingnUpBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupListener()
    }

    private fun setupListener() {

        migrationToMenuFragment()
    }

    private fun migrationToMenuFragment() = with(binding) {

        btnRegistration.setOnClickListener {
            val requireCountSymbols = 6
            val textLengthMail = editRegistration.text.length

            if (textLengthMail >= requireCountSymbols) {
                userPreferencesData.isAuthorized = true
                requireActivity()
                    .findNavController(R.id.nav_host_fragment)
                    .navigate(R.id.action_global_mainFlowFragment)

            } else {
                toastFragment("Text must be more then 6 symbols")

            }
        }
    }
}