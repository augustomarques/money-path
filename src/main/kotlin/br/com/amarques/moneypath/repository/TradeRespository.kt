package br.com.amarques.moneypath.repository

import br.com.amarques.moneypath.model.Trade
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TradeRespository: JpaRepository<Trade, Long> {
}