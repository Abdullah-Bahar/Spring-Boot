package com.example.demo.error;

import com.example.demo.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


// @RestControllerAdvice = @ControllerAdvice + @ResponseBody


/*
- Bir controller advice, exception'ları handle etmek için
controller metodlarının dönüş değerlerini yakalamamıza ve değiştirmemize olanak tanır.
- Bir kac tane controller olsaydi hepsiniden firlatilan exceptionlari yakalayacakti.
Eger sadece belirli bir pakette bulunan controller'ı manipule etmesini istiyorsak
parametre olarak bu anatasyona veriririz.
*/

@ControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler
{
    @ExceptionHandler(EmployeeNotFoundException.class) // belirli bir turdeki istisnayi islemek icin belirtilir
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)  // yanıtımızın HTTP durumunu değiştirmemize izin verir.
     // eger bunu kullanmayip method icindeki ile yetindeydik
     // "200 OK" statusu ile "404 Not Found" Statusunu göndermiş olurduk.
    public ErrorMessage employeeeNotFoundExceptionHandler(EmployeeNotFoundException ex)
    {
         return new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
    }



    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage GenericException(RuntimeException ex)
    {
        return new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    }
}
