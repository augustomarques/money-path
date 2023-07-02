package br.com.amarques.moneypath.dto.form

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

data class CompanyForm(
    @field:NotEmpty(message = "The Name cannot be empty")
    @field:Size(min = 5, max = 200, message = "The name must contain between 05 and 200 characters")
    val name: String,

    @field:NotEmpty(message = "The Stock Symbol cannot be empty")
    @field:Size(min = 5, max = 10, message = "The Stock Symbol must contain between 05 and 10 characters")
    val stockSymbol: String
)
