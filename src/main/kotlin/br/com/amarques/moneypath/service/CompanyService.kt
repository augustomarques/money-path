package br.com.amarques.moneypath.service

import br.com.amarques.moneypath.exception.NotFoundException
import br.com.amarques.moneypath.dto.form.CompanyForm
import br.com.amarques.moneypath.dto.view.CompanyView
import br.com.amarques.moneypath.mapper.CompanyMapper
import br.com.amarques.moneypath.model.Company
import br.com.amarques.moneypath.repository.CompanyRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CompanyService(
    private val repository: CompanyRepository
) {

    @Transactional
    fun create(dto: CompanyForm): CompanyView {
        val company = CompanyMapper().mapToModel(dto)
        repository.save(company)

        return CompanyMapper().mapToViem(company)
    }

    fun getById(id: Long) : CompanyView {
        return CompanyMapper().mapToViem(getCompanyId(id))
    }

    private fun getCompanyId(id: Long): Company {
        return repository.findById(id).orElseThrow{ NotFoundException("Company not found") };
    }

    @Transactional
    fun delete(id: Long) {
        repository.deleteById(id)
    }

    fun listAll(pagination: Pageable): Page<CompanyView> {
        return repository.findAll(pagination).map { company -> CompanyMapper().mapToViem(company) }
    }

    @Transactional
    fun update(id: Long, dto: CompanyForm): CompanyView {
        val company = getCompanyId(id)
        company.name = dto.name
        company.stockSymbol = dto.stockSymbol

        repository.save(company)

        return CompanyMapper().mapToViem(company)
    }
}