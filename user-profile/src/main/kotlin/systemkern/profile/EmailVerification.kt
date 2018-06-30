package systemkern.profile

import org.springframework.data.repository.CrudRepository
import org.springframework.http.HttpStatus
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id


@RestController
internal class EmailVerificationController(
    val emailVerificationService: EmailVerificationService,
    val authenticationService: AuthenticationService) {

    @PostMapping("/verify-email/{id}")
    fun verifyUserByToken(@PathVariable("id") tokenId: String,
                          @RequestHeader password: String,
                          auth: Authentication): AuthenticationResponse {

        val emailVerification = emailVerificationService.findById(UUID.fromString(tokenId)).get()
        val completionDate = LocalDateTime.now()
        if (LocalDateTime.now() <= emailVerification.validUntil) {
            emailVerification.completionDate = completionDate
            emailVerificationService.save(emailVerification)

            return authenticationService.authenticationProcess(auth, password)
        }
        throw ExpiredTokenException("Token has expired")
    }
}

@Service
internal class EmailVerificationService(val repo: EmailVerificationRepository) {
    internal fun findById(id: UUID) =
        repo.findById(id)

    internal fun save(emailVerification: EmailVerification) =
        repo.save(emailVerification)
}

internal interface EmailVerificationRepository : CrudRepository<EmailVerification, UUID>

@Entity
internal data class EmailVerification(
    @Id
    val id: UUID,
    val creationDate: LocalDateTime,
    val validUntil: LocalDateTime,
    var completionDate: LocalDateTime,
    val userProfileId: UUID
)

@ResponseStatus(HttpStatus.UNAUTHORIZED)
internal class ExpiredTokenException(message: String?) : RuntimeException()