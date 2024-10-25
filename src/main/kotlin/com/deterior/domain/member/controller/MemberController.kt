package com.deterior.domain.member.controller

import com.deterior.sercurity.dto.ReissueTokenRequest
import com.deterior.domain.member.dto.SignInRequest
import com.deterior.domain.member.dto.SignUpRequest
import com.deterior.domain.member.dto.SignUpResponse
import com.deterior.domain.member.service.MemberService
import com.deterior.sercurity.dto.JwtToken
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Controller
class MemberController @Autowired constructor(
    private val memberService: MemberService
) {
    @PostMapping("/api/member/sign-in")
    fun signIn(
        @RequestBody signInRequest: SignInRequest
    ): ResponseEntity<JwtToken> {
        val jwtToken = memberService.signIn(signInRequest)
        return ResponseEntity.ok(jwtToken)
    }

    @PostMapping("/api/member/sign-up")
    fun signUp(
        @RequestBody signUpRequest: SignUpRequest
    ): ResponseEntity<SignUpResponse> {
        val signUpResponse = memberService.signUp(signUpRequest)
        return ResponseEntity.ok(signUpResponse)
    }

    @PostMapping("/api/member/reissue")
    fun reissueToken(
        @RequestBody reissueTokenRequest: ReissueTokenRequest
    ): ResponseEntity<JwtToken> {
        val jwtToken = memberService.reissue(reissueTokenRequest)
        return ResponseEntity.ok(jwtToken)
    }
}