package com.biblioteca.projetoBiblioteca.configuration;

import org.modelmapper.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class ModelMapperConfiguration {
    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelmapper = new ModelMapper();
        modelmapper.addConverter(toStringDate);
        modelmapper.getTypeMap(String.class, LocalDate.class);
        modelmapper.validate();

        modelmapper.addConverter(toDateString);
        modelmapper.getTypeMap(LocalDate.class,String.class);
        modelmapper.validate();
        return modelmapper;
    }

    Converter<String, LocalDate> toStringDate = new AbstractConverter<String, LocalDate>() {
        @Override
        protected LocalDate convert(String source) {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate localDate = LocalDate.parse(source, format);
            return localDate;
        }
    };
    Converter< LocalDate,String> toDateString = new AbstractConverter<LocalDate,String>() {
        @Override
        protected String convert(LocalDate localDate) {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String date = localDate.format(format);
            return date;
        }

    };




}

