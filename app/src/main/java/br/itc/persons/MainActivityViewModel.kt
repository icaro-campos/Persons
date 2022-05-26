package br.itc.persons

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import br.itc.persons.model.Person
import br.itc.persons.network.RetroInstance
import br.itc.persons.network.RetroService
import br.itc.persons.paging.PersonPagingSource
import kotlinx.coroutines.flow.Flow

class MainActivityViewModel: ViewModel() {

    var retroService: RetroService = RetroInstance.getRetroInstance().create(RetroService::class.java)

    fun getListData(): Flow<PagingData<Person>> = Pager (
        config = PagingConfig(pageSize = 10),
        pagingSourceFactory = { PersonPagingSource(retroService) }
    ).flow.cachedIn(viewModelScope)
    }
