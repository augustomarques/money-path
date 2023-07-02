package br.com.amarques.moneypath.repository

import br.com.amarques.moneypath.model.Company
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CompanyRepository: JpaRepository<Company, Long> {
}