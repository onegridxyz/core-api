package xyz.onegrid.coreapi.config

import com.github.benmanes.caffeine.jcache.configuration.CaffeineConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer
import org.springframework.boot.info.BuildProperties
import org.springframework.boot.info.GitProperties
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import tech.jhipster.config.JHipsterProperties
import tech.jhipster.config.cache.PrefixedKeyGenerator
import java.util.OptionalLong
import java.util.concurrent.TimeUnit

@Configuration
@EnableCaching
class CacheConfiguration(
    @Autowired val gitProperties: GitProperties?,
    @Autowired val buildProperties: BuildProperties?,
    private val jHipsterProperties: JHipsterProperties
) {

    private val jcacheConfiguration: javax.cache.configuration.Configuration<Any, Any>

    init {
        val caffeine = jHipsterProperties.cache.caffeine

        val caffeineConfiguration = CaffeineConfiguration<Any, Any>()
        caffeineConfiguration.maximumSize = OptionalLong.of(caffeine.maxEntries)
        caffeineConfiguration.expireAfterWrite = OptionalLong.of(TimeUnit.SECONDS.toNanos(caffeine.timeToLiveSeconds.toLong()))
        caffeineConfiguration.isStatisticsEnabled = true
        jcacheConfiguration = caffeineConfiguration
    }

    @Bean
    fun cacheManagerCustomizer(): JCacheManagerCustomizer {
        return JCacheManagerCustomizer { cm ->
            createCache(cm, xyz.onegrid.coreapi.repository.UserRepository.USERS_BY_LOGIN_CACHE)
            createCache(cm, xyz.onegrid.coreapi.repository.UserRepository.USERS_BY_EMAIL_CACHE)
            // jhipster-needle-caffeine-add-entry
        }
    }

    private fun createCache(cm: javax.cache.CacheManager, cacheName: String) {
        val cache: javax.cache.Cache<Any, Any>? = cm.getCache(cacheName)
        if (cache != null) {
            cache.clear()
        } else {
            cm.createCache(cacheName, jcacheConfiguration)
        }
    }

    @Bean
    fun keyGenerator() = PrefixedKeyGenerator(gitProperties, buildProperties)
}
