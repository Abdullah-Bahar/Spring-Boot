package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer
{
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer)
    {
        configurer.favorParameter(true) // Bu yöntem, istemcinin talep URL'sinde bir sorgu parametresi ile istediği veri formatını belirtmesine izin verir.
                .parameterName("") // veri formatinin belirtmek icin kullanılan sorgu parametresinin adını belirler
                .defaultContentType(MediaType.APPLICATION_JSON) // default olarak json kullanılacagini belirtir
                .mediaType("xml", MediaType.APPLICATION_XML) // xml parametresi girilirse xml formatında verş gonderecek
                .mediaType("json", MediaType.APPLICATION_JSON); // json parametresi girilirse json formatında verş gonderecek
    }
}
