package tads.eaj.ufrn.segundaprovacontatos.ui.detalhes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import tads.eaj.ufrn.segundaprovacontatos.databinding.FragmentDetalhesBinding

class DetalhesFragment : Fragment() {

    private var _binding: FragmentDetalhesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val detalhesViewModel =
            ViewModelProvider(this).get(DetalhesViewModel::class.java)

        _binding = FragmentDetalhesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textNotifications
        detalhesViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}