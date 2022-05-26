package br.itc.persons.adapter

import br.itc.persons.model.Person

interface OnClickListener {
    fun onClickEvent(person: Person)
}