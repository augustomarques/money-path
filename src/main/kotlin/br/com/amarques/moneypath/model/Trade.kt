package br.com.amarques.moneypath.model

import br.com.amarques.moneypath.enums.TradeTypeEnum
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate

@Entity
@Table(name = "trade")
data class Trade(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var date: LocalDate = LocalDate.now(),
    var type: TradeTypeEnum,
    var quantity: Int,
    var unitValue: BigDecimal,
    @ManyToOne
    var company: Company
)
