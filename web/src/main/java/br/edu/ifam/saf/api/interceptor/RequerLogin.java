package br.edu.ifam.saf.api.interceptor;


import br.edu.ifam.saf.modelo.Perfil;

import javax.ws.rs.NameBinding;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@NameBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface RequerLogin {
    Perfil[] value() default {};
}
