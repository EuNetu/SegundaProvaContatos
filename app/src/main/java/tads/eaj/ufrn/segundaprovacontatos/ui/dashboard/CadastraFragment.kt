package tads.eaj.ufrn.segundaprovacontatos.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import tads.eaj.ufrn.segundaprovacontatos.databinding.FragmentCadastraBinding

@AndroidEntryPoint
class CadastraFragment : Fragment() {

    private lateinit var _binding: FragmentCadastraBinding
    private lateinit var _viewmodel: CadastraViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewmodel = ViewModelProvider(this).get(CadastraViewModel::class.java)
        _binding = FragmentCadastraBinding.inflate(inflater, container, false)

        _binding.viewmodel = _viewmodel
        _binding.lifecycleOwner = this

        return _binding.root
    }
}