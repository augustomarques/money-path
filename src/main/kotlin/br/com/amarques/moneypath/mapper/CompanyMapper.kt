package br.com.amarques.moneypath.mapper

import br.com.amarques.moneypath.dto.form.CompanyForm
import br.com.amarques.moneypath.dto.view.CompanyView
import br.com.amarques.moneypath.model.Company

class CompanyMapper {

    fun mapToModel(dto: CompanyForm): Company {
        return Company(
            name = dto.name,
            stockSymbol = dto.stockSymbol
        )
    }

    fun mapToViem(company: Company): CompanyView {
        return CompanyView(
            id = company.id,
            name = company.name,
            stockSymbol = company.stockSymbol
        )
    }
}
