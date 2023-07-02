package br.com.amarques.moneypath.resource

import br.com.amarques.moneypath.dto.form.CompanyForm
import br.com.amarques.moneypath.dto.view.CompanyView
import br.com.amarques.moneypath.service.CompanyService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/companies")
class CompanyResource(private val companyService: CompanyService) {

    @GetMapping
    fun list(@PageableDefault(size = 10, sort = ["name"], direction = Sort.Direction.ASC) pagination: Pageable): Page<CompanyView> {
        return companyService.listAll(pagination)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): CompanyView {
        return companyService.getById(id)
    }

    @PostMapping
    fun create(@RequestBody company: CompanyForm, uriBuilder: UriComponentsBuilder): ResponseEntity<CompanyView> {
        val companyView = companyService.create(company)

        val uri = uriBuilder.path("/companies/${companyView.id}").build().toUri()
        return ResponseEntity.created(uri).body(companyView)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody company: CompanyForm): ResponseEntity<CompanyView> {
        val companyView = companyService.update(id, company)
        return ResponseEntity.ok(companyView)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        companyService.delete(id)
    }

}