package com.geektech.multigraphs

import android.widget.Toast
import androidx.fragment.app.Fragment


fun Fragment.toastFragment(text: String) {

    Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
}