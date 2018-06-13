import com.typesafe.config.ConfigFactory
import com.typesafe.config.ConfigParseOptions
import net.corda.nodeapi.config.parseAs
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class Abcd {
    companion object {
        val  defaultConfig = ConfigFactory.parseResources("simple.conf", ConfigParseOptions.defaults().setAllowMissing(false))
    }
    @Test
    fun `the configuration should not be null`(){
        assertNotNull(defaultConfig)
    }

    @Test
    fun `convert the configuration to a friendly pojo`(){
        val simpleConfiguration = defaultConfig!!.resolve().parseAs<LoadTestConfiguration>()
        assertNotNull(simpleConfiguration)
    }

    @Test
    fun `get values from the friendly pojo`(){
        val simpleConfiguration = defaultConfig!!.resolve().parseAs<LoadTestConfiguration>()
        assertEquals(simpleConfiguration.basedir,"/opt/corda")
        assertEquals(simpleConfiguration.rpcUsers.get(1),"Grant")
    }
}

data class LoadTestConfiguration(
        val basedir: String,
        val p2pAddress: String,
        val h2port : Int,
        val useHTTPS : Boolean,
        val rpcUsers : List<String>
)