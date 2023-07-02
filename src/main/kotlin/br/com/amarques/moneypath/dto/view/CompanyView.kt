package br.com.amarques.moneypath.dto.view

import br.com.amarques.moneypath.model.Company

data class CompanyView(
    val id: Long? = null,
    val name: String,
    val stockSymbol: String
) {
    constructor(company: Company) : this (
        id = company.id,
        name = company.name,
        stockSymbol = company.stockSymbol
    )
}