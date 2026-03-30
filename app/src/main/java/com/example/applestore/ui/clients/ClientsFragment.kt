package com.example.applestore.ui.clients

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applestore.R
import com.example.applestore.data.repository.StoreRepository

class ClientsFragment : Fragment() {

    private lateinit var adapter: ClientsAdapter
    private lateinit var etSearch: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_clients, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvClients = view.findViewById<RecyclerView>(R.id.rvClients)
        etSearch = view.findViewById(R.id.etSearchClient)

        adapter = ClientsAdapter(StoreRepository.clients) { client ->
            Toast.makeText(context, client.name, Toast.LENGTH_SHORT).show()
        }

        rvClients.layoutManager = LinearLayoutManager(context)
        rvClients.adapter = adapter

        // Відкриваємо клавіатуру при натисканні
        etSearch.setOnClickListener {
            etSearch.requestFocus()
            val imm = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(etSearch, InputMethodManager.SHOW_IMPLICIT)
        }

        etSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val query = s?.toString() ?: ""
                val list = if (query.isEmpty()) StoreRepository.clients.toList()
                else StoreRepository.searchClients(query)
                adapter.updateList(list)
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }
}