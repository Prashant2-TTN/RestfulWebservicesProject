package com.prashant.RestApiProject.versioningController;

import com.prashant.RestApiProject.entity.Employee;
import org.springframework.cglib.core.Local;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RequestMapping("/internationalization")
@RestController
public class EmployeeVersion {

    MessageSource messageSource;
    public EmployeeVersion(MessageSource messageSource){
        this.messageSource=messageSource;
    }

    @GetMapping("/message")
    public String retrieveMessage(){
        Locale locale= LocaleContextHolder.getLocale();
        return messageSource.getMessage("greeting.message",null,"default message",locale);

    }

    @GetMapping(path="/message/{username}")
    public String retrieveParameterisedMessage(@PathVariable String username){
        Locale locale=LocaleContextHolder.getLocale();
        return messageSource.getMessage("prefix.message",null,"default message",locale)+" "+username;
    }
}
