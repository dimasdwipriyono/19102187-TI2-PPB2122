package com.dimasdwipriyono_19102187.modul14.ui.globalquotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dimasdwipriyono_19102187.modul14.CoroutineContextProvider
import com.dimasdwipriyono_19102187.modul14.QuoteAdapter
import com.dimasdwipriyono_19102187.modul14.R
import com.dimasdwipriyono_19102187.modul14.TokenPref
import com.dimasdwipriyono_19102187.modul14.`interface`.MainView
import com.dimasdwipriyono_19102187.modul14.api.MainPresenter
import com.dimasdwipriyono_19102187.modul14.databinding.FragmentClassQuotesBinding
import com.dimasdwipriyono_19102187.modul14.databinding.FragmentGlobalQuotesBinding
import com.dimasdwipriyono_19102187.modul14.databinding.FragmentMyQuotesBinding
import com.dimasdwipriyono_19102187.modul14.model.Login
import com.dimasdwipriyono_19102187.modul14.model.Quote
import com.dimasdwipriyono_19102187.modul14.model.Token
import kotlinx.android.synthetic.main.fragment_my_quotes.*

class GlobalQuotesFragment : Fragment(), MainView {
    private lateinit var presenter: MainPresenter
    private var quotes: MutableList<Quote> = mutableListOf()
    private lateinit var adapter: QuoteAdapter
    private lateinit var tokenPref: TokenPref
    private lateinit var token: Token
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:
        Bundle?
    ): View? = inflater.inflate(R.layout.fragment_global_quotes, container, false)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentGlobalQuotesBinding.bind(view)
        binding.recyclerviewGlobalQuotes.layoutManager = LinearLayoutManager(activity)
        tokenPref = TokenPref(requireActivity())
        token = tokenPref.getToken()
        adapter = QuoteAdapter(requireActivity())
        binding.recyclerviewGlobalQuotes.adapter = adapter
        presenter =
            MainPresenter(this, CoroutineContextProvider())
        progressbar.visibility = View.VISIBLE
        presenter.getAllQuotes(token.token.toString())
        swiperefresh.setOnRefreshListener(){
            progressbar.visibility = View.INVISIBLE
            presenter.getAllQuotes(token.token.toString())
        }
    }
    override fun onResume() {
        super.onResume()
        presenter.getAllQuotes(token.token.toString())
    }
    override fun showMessage(messsage: String) {
        Toast.makeText(requireActivity(),messsage, Toast.LENGTH_SHORT).show()
    }
    override fun resultQuote(data: ArrayList<Quote>) {
        quotes.clear()
        adapter.listQuotes = data
        quotes.addAll(data)
        adapter.notifyDataSetChanged()
        progressbar.visibility = View.INVISIBLE
        swiperefresh.isRefreshing = false
    }
    override fun resultLogin(data: Login) {
    }
}