package mony

import io.dropwizard.Application
import io.dropwizard.Configuration
import io.dropwizard.setup.Environment
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path

class MonyConfiguration : Configuration()

class MonyApplication : Application<MonyConfiguration>() {
    override fun run(configuration: MonyConfiguration?, environment: Environment?) {
        environment?.jersey()?.register(AccountResource())
    }
}

fun main(args: Array<String>) {
    MonyApplication().run(*args)
}

data class Account(val name: String, val initialAmount: Int)

@Path("/api/accounts")
class AccountResource {
    val accounts: Array<Account> = emptyArray()

    @GET
    fun getAccount(): String {
        return "Hello Kotlin !"
    }

    @POST
    fun addAccount(account: Account): Unit {
        accounts.plus(account)
    }
}
