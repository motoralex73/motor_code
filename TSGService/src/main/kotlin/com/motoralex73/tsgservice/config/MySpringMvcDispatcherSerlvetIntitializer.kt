package com.motoralex73.tsgservice.config

import org.springframework.web.filter.HiddenHttpMethodFilter
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer
import javax.servlet.ServletContext


class MySpringMvcDispatcherSerlvetIntitializer: AbstractAnnotationConfigDispatcherServletInitializer() {

    override fun onStartup(aServletContext: ServletContext) {
        super.onStartup(aServletContext)
        registerHiddenFieldFilter(aServletContext)
        println("print onStartup")
    }

    private fun registerHiddenFieldFilter(aContext: ServletContext) {
        aContext.addFilter("hiddenHttpMethodFilter",
                HiddenHttpMethodFilter()).addMappingForUrlPatterns(null ,true, "/*")
        println("print registerHiddenFieldFilter")
    }

    override fun getServletMappings(): Array<String> {
        println("print getServletMappings")
        return arrayOf("/")
    }

    override fun getRootConfigClasses(): Array<Class<*>>? {
        println("print getRootConfigClasses")
        return null
    }

    override fun getServletConfigClasses(): Array<Class<*>>? {
        val cl = SpringConfig().javaClass
        println("print getServletConfigClasses")
        return arrayOf(cl)
        //return null//Class[]{SpringConfig.class}
    }
}
