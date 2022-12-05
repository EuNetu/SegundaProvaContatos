package tads.eaj.ufrn.segundaprovacontatos.ui.detalhes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import tads.eaj.ufrn.segundaprovacontatos.databinding.FragmentDetalhesBinding

@AndroidEntryPoint
class AlteraFragment : Fragment() {

    private lateinit var _binding: FragmentDetalhesBinding
    private lateinit var _viewmodel: DetalhesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetalhesBinding.inflate(inflater, container, false)
        _viewmodel = ViewModelProvider(this)[DetalhesViewModel::class.java]

        _binding.viewmodel = _viewmodel
        _binding.lifecycleOwner = this

        val id = arguments?.getLong("id")
        _viewmodel.contatoSelecionado(id!!)
        return _binding.root
    }
}