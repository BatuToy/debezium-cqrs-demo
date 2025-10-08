package com.btoy.debezium.application.product.controller;

import com.btoy.debezium.event_bus.command.InitializeProductCommandDto;
import com.btoy.debezium.event_bus.command.InitializeProductResponseDto;
import com.btoy.debezium.application.base.AppResponse;
import com.btoy.debezium.application.base.BaseController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/product")
public class ProductController extends BaseController {

    @PostMapping(value = "/initialize")
    public ResponseEntity<AppResponse<InitializeProductResponseDto>> initializeProduct
            (@RequestBody InitializeProductCommandDto commandDto) {
        InitializeProductResponseDto response = publish(commandDto);
        return ResponseEntity.ok(respond(response, HttpStatus.CREATED.value()));
    }
}
