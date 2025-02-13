package com.deterior.global.controller

import com.deterior.global.dto.AutoCompleteGetResponse
import com.deterior.global.dto.AutoCompleteGetRequest
import com.deterior.global.dto.AutoCompleteUpdateRequest
import com.deterior.global.dto.AutoCompleteUpdateResponse
import com.deterior.global.service.AutoCompleteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/api/auto-complete")
class AutoCompleteController @Autowired constructor(
    private val autoCompleteService: AutoCompleteService
) {
    @GetMapping("/get-string/{input}")
    fun getAutoCompleteString(
        @PathVariable input: String,
        //@RequestBody autoCompleteGetRequest: AutoCompleteGetRequest
    ): ResponseEntity<AutoCompleteGetResponse> {
        val result = autoCompleteService.getAutoComplete(input)
        return ResponseEntity.ok(result.toResponse())
    }

    @PostMapping("/update-string")
    fun updateAutoCompleteString(
        @RequestBody autoCompleteUpdateRequest: AutoCompleteUpdateRequest
    ): ResponseEntity<AutoCompleteUpdateResponse> {
        autoCompleteService.updateAutoComplete(autoCompleteUpdateRequest.input)
        return ResponseEntity.ok(autoCompleteUpdateRequest.toResponse())
    }
}